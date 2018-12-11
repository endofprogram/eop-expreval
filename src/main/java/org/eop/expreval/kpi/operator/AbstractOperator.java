package org.eop.expreval.kpi.operator;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Operator;
import org.eop.expreval.kpi.builder.Priority;

/**
 * @author lixinjie
 * @since 2018-06-11
 */
public abstract class AbstractOperator implements Operator {

	private Expression parent;
	
	@Override
	public abstract Object operate(ExpEvalContext context, Expression... exps);
	
	@Override
	public abstract Priority getPriority();

	@Override
	public Expression getParent() {
		return parent;
	}

	@Override
	public void setParent(Expression parent) {
		this.parent = parent;
	}

}
