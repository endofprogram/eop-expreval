package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardBasedataExpression;

/**
 * @author lixinjie
 * @since 2018-06-13
 */
public class BasedataBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardBasedataExpression();
	}

}
