package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 数字常量表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface ConstantExpression extends Expression {

	Object getConstantValue();
	
	void setConstantValue(Object constantValue);
}
