package org.eop.expreval.kpi;

import org.eop.expreval.kpi.builder.Priority;

/**
 * 比较器
 * @author lixinjie
 * @since 2018-06-20
 */
public interface Comparator {

	Boolean compare(ExpEvalContext context, Expression... exps);
	
	Expression getParent();
	
	void setParent(Expression parent);
	
	Priority getPriority();
}
