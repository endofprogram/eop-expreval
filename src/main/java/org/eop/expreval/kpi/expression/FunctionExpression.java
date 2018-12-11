package org.eop.expreval.kpi.expression;

import java.util.List;

import org.eop.expreval.kpi.Expression;

/**
 * 函数表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface FunctionExpression extends Expression {

	String getFunctionName();
	
	void setFunctionName(String functionName);
	
	void addFunctionParam(Expression functionParam);
	
	void addFunctionParams(List<Expression> functionParams);
	
	Expression[] getFunctionParams();
}
