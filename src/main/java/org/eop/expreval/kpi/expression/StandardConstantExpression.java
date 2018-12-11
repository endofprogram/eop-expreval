package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 数字常量表达式实现
 * @author lixinjie
 * @since 2018-06-12
 */
public class StandardConstantExpression extends AbstractExpression implements ConstantExpression {

	private Object constantValue;
	
	@Override
	public Object getConstantValue() {
		return constantValue;
	}

	@Override
	public void setConstantValue(Object constantValue) {
		this.constantValue = constantValue;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return constantValue;
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
