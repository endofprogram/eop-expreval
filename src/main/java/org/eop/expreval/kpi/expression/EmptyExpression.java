package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 空字符串表达式
 * @author lixinjie
 * @since 2018-06-21
 */
public interface EmptyExpression extends Expression {

	Object getEmptyValue();
	
	void setEmptyValue(Object emptyValue);
}
