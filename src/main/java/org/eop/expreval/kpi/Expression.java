package org.eop.expreval.kpi;

import org.eop.expreval.kpi.builder.Priority;

/**
 * 表达式
 * @author lixinjie
 * @since 2018-06-11
 */
public interface Expression {

	Object evaluate(ExpEvalContext context);
	
	Expression getParent();
	
	void setParent(Expression parent);
	
	Priority getPriority();
}
