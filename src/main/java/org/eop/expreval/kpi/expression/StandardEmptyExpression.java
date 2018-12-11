package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 空字符串表达式实现
 * @author lixinjie
 * @since 2018-06-21
 */
public class StandardEmptyExpression extends AbstractExpression implements EmptyExpression {

	private Object emptyValue;
	
	//只会返回""
	@Override
	public Object getEmptyValue() {
		return emptyValue;
	}

	//只会设置""
	@Override
	public void setEmptyValue(Object emptyValue) {
		this.emptyValue = emptyValue;
	}

	//只会返回""
	@Override
	public Object evaluate(ExpEvalContext context) {
		return emptyValue;
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
