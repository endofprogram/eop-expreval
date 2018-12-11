package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 变量表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface VariableExpression extends Expression {

	String getVariableName();
	
	void setVariableName(String variableName);
}
