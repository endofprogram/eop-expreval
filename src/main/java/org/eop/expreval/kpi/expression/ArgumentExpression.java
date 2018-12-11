package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 函数参数表达式
 * @author lixinjie
 * @since 2018-06-20
 */
public interface ArgumentExpression extends Expression {

	String getArgumentName();
	
	void setArgumentName(String argumentName);
}
