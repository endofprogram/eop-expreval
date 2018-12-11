package org.eop.expreval.kpi.builder;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Statement;
import org.eop.expreval.kpi.bean.statement.DelegateStatement;
import org.eop.expreval.kpi.bean.statement.ElseStatement;
import org.eop.expreval.kpi.bean.statement.ExpressionStatement;
import org.eop.expreval.kpi.bean.statement.IfStatement;
import org.eop.expreval.kpi.bean.statement.StandardElseStatement;
import org.eop.expreval.kpi.bean.statement.StandardExpressionStatement;
import org.eop.expreval.kpi.bean.statement.StandardIfStatement;
import org.eop.expreval.kpi.utils.StmtUtils;

/**
 * @author lixinjie
 * @since 2018-06-24
 */
public class StandardStmtBuilder implements StmtBuilder {

	@Override
	public Statement build(String statements) {
		String[] stmts = statements.split(";");
		Statement delegate = new DelegateStatement();
		Statement first = null;
		Statement last = null;
		for (String stmt : stmts) {
			stmt = stmt.trim();
			if (StmtUtils.isIf(stmt)) {
				String[] exps = getExprForIf(stmt);
				Expression condition = new StandardExprBuilder().build(exps[0]);
				Expression result = new StandardExprBuilder().build(exps[1]);
				IfStatement ifStmt = new StandardIfStatement();
				ifStmt.setCondition(condition);
				ifStmt.setResult(result);
				if (first == null) {
					first = ifStmt;
					last = ifStmt;
				} else {
					if (last instanceof IfStatement) {
						((IfStatement)last).setNext(ifStmt);
						last = ifStmt;
					}
				}
				continue;
			}
			if (StmtUtils.isElse(stmt)) {
				String exp = getExprForElse(stmt);
				Expression result = new StandardExprBuilder().build(exp);
				ElseStatement elseStmt = new StandardElseStatement();
				elseStmt.setResult(result);
				if (last instanceof IfStatement) {
					((IfStatement)last).setNext(elseStmt);
					last = elseStmt;
				}
				continue;
			}
			Expression expression = new StandardExprBuilder().build(stmt);
			ExpressionStatement exprstmt = new StandardExpressionStatement();
			exprstmt.setExpression(expression);
			if (first == null) {
				first = exprstmt;
				last = exprstmt;
			} else {
				last = exprstmt;
			}
			continue;
		}
		delegate.addChild(first);
		return delegate;
	}
	
	private String[] getExprForIf(String stmt) {
		int thenIndex = stmt.indexOf("then");
		return new String[] {stmt.substring(2, thenIndex).trim(), stmt.substring(thenIndex + 4).trim()};
	}
	
	private String getExprForElse(String stmt) {
		return stmt.substring(4).trim();
	}

}
