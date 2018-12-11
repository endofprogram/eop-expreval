package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardFunctionExpression;

/**
 * @author lixinjie
 * @since 2018-06-13
 */
public class FunctionBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardFunctionExpression();
	}

}
