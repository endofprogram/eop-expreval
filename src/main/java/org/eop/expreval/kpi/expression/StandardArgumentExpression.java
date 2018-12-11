package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 函数参数表达式实现
 * @author lixinjie
 * @since 2018-06-20
 */
public class StandardArgumentExpression extends AbstractExpression implements ArgumentExpression {

	private String argumentName;
	
	@Override
	public String getArgumentName() {
		return argumentName;
	}

	@Override
	public void setArgumentName(String argumentName) {
		this.argumentName = argumentName;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return context.getArgumentValue(argumentName);
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
