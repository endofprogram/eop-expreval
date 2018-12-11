package org.eop.expreval.kpi.comparator;

import org.eop.expreval.kpi.Comparator;
import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * @author lixinjie
 * @since 2018-06-20
 */
public abstract class AbstractComparator implements Comparator {

	private Expression parent;
	
	@Override
	public abstract Boolean compare(ExpEvalContext context, Expression... exps);
	
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
