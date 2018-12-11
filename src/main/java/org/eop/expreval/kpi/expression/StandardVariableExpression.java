package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 变量表达式实现
 * @author lixinjie
 * @since 2018-06-12
 */
public class StandardVariableExpression extends AbstractExpression implements VariableExpression {

	private String variableName;
	
	@Override
	public String getVariableName() {
		return variableName;
	}

	@Override
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return context.getVariableValue(variableName);
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
