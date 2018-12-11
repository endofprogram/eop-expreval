package org.eop.expreval.kpi;

import org.eop.expreval.kpi.builder.Priority;

/**
 * 操作符
 * @author lixinjie
 * @since 2018-06-11
 */
public interface Operator {

	Object operate(ExpEvalContext context, Expression... exps);
	
	Expression getParent();
	
	void setParent(Expression parent);
	
	Priority getPriority();
}
