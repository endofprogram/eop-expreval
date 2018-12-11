package org.eop.expreval.kpi.logictor;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 非
 * @author lixinjie
 * @since 2018-06-21
 */
public class Not extends AbstractLogictor {

	@Override
	public Boolean logic(ExpEvalContext context, Expression... exps) {
		return !(Boolean)exps[1].evaluate(context);
	}

	@Override
	public Priority getPriority() {
		return null;
	}

}
