package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 布尔表达式实现
 * @author lixinjie
 * @since 2018-06-21
 */
public class StandardBooleanExpression extends AbstractExpression implements BooleanExpression {

	private Object booleanValue;
	
	//只会返回true或false
	@Override
	public Object getBooleanValue() {
		return booleanValue;
	}

	//只会设置true或false
	@Override
	public void setBooleanValue(Object booleanValue) {
		this.booleanValue = booleanValue;
	}

	//只会返回true或false
	@Override
	public Object evaluate(ExpEvalContext context) {
		return booleanValue;
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
