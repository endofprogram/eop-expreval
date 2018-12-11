package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 指标表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface IndicatorExpression extends Expression {

	String getIndicatorName();
	
	void setIndicatorName(String indicatorName);
}
