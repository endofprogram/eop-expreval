package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardBooleanExpression;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class BooleanBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardBooleanExpression();
	}

}
