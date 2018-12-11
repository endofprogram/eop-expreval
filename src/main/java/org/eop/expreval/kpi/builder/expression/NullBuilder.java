package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardNullExpression;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class NullBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardNullExpression();
	}

}
