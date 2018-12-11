package org.eop.expreval.kpi.expression;

import java.util.ArrayList;
import java.util.List;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 函数表达式实现
 * @author lixinjie
 * @since 2018-06-12
 */
public class StandardFunctionExpression extends AbstractExpression implements FunctionExpression {

	private String functionName;
	private List<Expression> functionParams = new ArrayList<>(5);
	
	@Override
	public String getFunctionName() {
		return functionName;
	}

	@Override
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	@Override
	public void addFunctionParam(Expression functionParam) {
		functionParams.add(functionParam);
	}
	
	@Override
	public void addFunctionParams(List<Expression> functionParams) {
		this.functionParams.addAll(functionParams);
	}

	@Override
	public Expression[] getFunctionParams() {
		return functionParams.toArray(new Expression[functionParams.size()]);
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return context.getFunctionValue(functionName, getFunctionParams());
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
