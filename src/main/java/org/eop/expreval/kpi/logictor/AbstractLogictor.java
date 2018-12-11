package org.eop.expreval.kpi.logictor;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Logictor;
import org.eop.expreval.kpi.builder.Priority;

/**
 * @author lixinjie
 * @since 2018-06-20
 */
public abstract class AbstractLogictor implements Logictor {

	private Expression parent;
	
	@Override
	public abstract Boolean logic(ExpEvalContext context, Expression... exps);
	
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
