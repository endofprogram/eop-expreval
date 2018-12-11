package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * @author lixinjie
 * @since 2018-06-11
 */
public abstract class AbstractExpression implements Expression {

	private Expression parent;
	
	@Override
	public abstract Object evaluate(ExpEvalContext context);
	
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
