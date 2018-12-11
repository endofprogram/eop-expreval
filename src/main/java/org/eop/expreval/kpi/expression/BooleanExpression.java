package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 布尔表达式
 * @author lixinjie
 * @since 2018-06-21
 */
public interface BooleanExpression extends Expression {

	Object getBooleanValue();
	
	void setBooleanValue(Object booleanValue);
}
