package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardIndicatorExpression;

/**
 * @author lixinjie
 * @since 2018-06-13
 */
public class IndicatorBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardIndicatorExpression();
	}

}
