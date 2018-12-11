package org.eop.expreval.kpi.builder.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.expression.StandardLogicExpression;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class LogicBuilder implements ExpressionBuilder {

	@Override
	public Expression build() {
		return new StandardLogicExpression();
	}

}
