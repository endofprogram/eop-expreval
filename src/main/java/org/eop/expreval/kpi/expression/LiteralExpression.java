package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 字符串常量表达式
 * @author lixinjie
 * @since 2018-06-20
 */
public interface LiteralExpression extends Expression {

	Object getLiteralValue();
	
	void setLiteralValue(Object literalValue);
}
