package org.eop.expreval.kpi.logictor;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 与
 * @author lixinjie
 * @since 2018-06-20
 */
public class And extends AbstractLogictor {

	@Override
	public Boolean logic(ExpEvalContext context, Expression... exps) {
		return (Boolean)exps[0].evaluate(context) && (Boolean)exps[1].evaluate(context);
	}

	@Override
	public Priority getPriority() {
		return null;
	}

}
