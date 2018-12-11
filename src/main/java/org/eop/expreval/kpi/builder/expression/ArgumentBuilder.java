package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardArgumentExpression;

/**
 * @author lixinjie
 * @since 2018-06-20
 */
public class ArgumentBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardArgumentExpression();
	}

}
