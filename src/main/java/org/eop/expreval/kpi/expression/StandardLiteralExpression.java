package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 字符串常量表达式实现
 * @author lixinjie
 * @since 2018-06-20
 */
public class StandardLiteralExpression extends AbstractExpression implements LiteralExpression {

	private Object literalValue;
	
	@Override
	public Object getLiteralValue() {
		return literalValue;
	}

	@Override
	public void setLiteralValue(Object literalValue) {
		this.literalValue = literalValue;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return literalValue;
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
