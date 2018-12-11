package org.eop.expreval.kpi.operator;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 除法
 * @author lixinjie
 * @since 2018-06-11
 */
public class Div extends AbstractOperator {

	@Override
	public Object operate(ExpEvalContext context, Expression... exps) {
		return Double.valueOf(exps[0].evaluate(context).toString()) / Double.valueOf(exps[1].evaluate(context).toString());
	}

	@Override
	public Priority getPriority() {
		return Priority.Div();
	}

}
