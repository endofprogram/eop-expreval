package org.eop.expreval.kpi;

import org.eop.expreval.kpi.builder.Priority;

/**
 * 逻辑运算器
 * @author lixinjie
 * @since 2018-06-20
 */
public interface Logictor {

	Boolean logic(ExpEvalContext context, Expression... exps);
	
	Expression getParent();
	
	void setParent(Expression parent);
	
	Priority getPriority();
}
