package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.StmtExeContext;

/**
 * 表达式语句实现
 * @author lixinjie
 * @since 2018-06-25
 */
public class StandardExpressionStatement extends AbstractStatement implements ExpressionStatement {

	private Expression expression;
	
	@Override
	public Expression getExpression() {
		return expression;
	}

	@Override
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Object execute(StmtExeContext context) {
		return expression.evaluate(context);
	}

}
