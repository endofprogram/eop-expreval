package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardUnaryExpression;

/**
 * @author lixinjie
 * @since 2018-06-13
 */
public class UnaryBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardUnaryExpression();
	}

}
