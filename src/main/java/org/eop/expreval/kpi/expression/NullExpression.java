package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * null表达式
 * @author lixinjie
 * @since 2018-06-21
 */
public interface NullExpression extends Expression {

	Object getNullValue();
	
	void setNullValue(Object nullValue);
}
