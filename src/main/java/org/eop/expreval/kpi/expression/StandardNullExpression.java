package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * null表达式实现
 * @author lixinjie
 * @since 2018-06-21
 */
public class StandardNullExpression extends AbstractExpression implements NullExpression {

	private Object nullValue;
	
	//只会返回null
	@Override
	public Object getNullValue() {
		return nullValue;
	}

	//只会设置null
	@Override
	public void setNullValue(Object nullValue) {
		this.nullValue = nullValue;
	}

	//只会返回null
	@Override
	public Object evaluate(ExpEvalContext context) {
		return nullValue;
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
