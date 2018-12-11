package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Statement;
import org.eop.expreval.kpi.StmtExeContext;

/**
 * if语句实现
 * @author lixinjie
 * @since 2018-06-24
 */
public class StandardIfStatement extends AbstractStatement implements IfStatement {

	private Expression result;
	private Expression condition;
	private Statement next;
	
	@Override
	public Expression getCondition() {
		return condition;
	}

	@Override
	public void setCondition(Expression condition) {
		this.condition = condition;
	}

	@Override
	public Expression getResult() {
		return result;
	}

	@Override
	public void setResult(Expression result) {
		this.result = result;
	}

	@Override
	public Statement getNext() {
		return next;
	}

	@Override
	public void setNext(Statement next) {
		this.next = next;
	}

	@Override
	public Object execute(StmtExeContext context) {
		if ((Boolean)condition.evaluate(context)) {
			return result.evaluate(context);
		}
		if (next != null) {
			return next.execute(context);
		}
		return null;
	}

}
