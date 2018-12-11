package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 指标表达式实现
 * @author lixinjie
 * @since 2018-06-12
 */
public class StandardIndicatorExpression extends AbstractExpression implements IndicatorExpression {

	private String indicatorName;
	
	@Override
	public String getIndicatorName() {
		return indicatorName;
	}

	@Override
	public void setIndicatorName(String indicatorName) {
		this.indicatorName = indicatorName;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return context.getIndicatorValue(indicatorName);
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
