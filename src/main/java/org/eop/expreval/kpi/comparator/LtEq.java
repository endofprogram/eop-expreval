package org.eop.expreval.kpi.comparator;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 小于
 * @author lixinjie
 * @since 2018-06-20
 */
public class LtEq extends AbstractComparator {

	@Override
	public Boolean compare(ExpEvalContext context, Expression... exps) {
		return Double.valueOf(exps[0].evaluate(context).toString()) <= Double.valueOf(exps[1].evaluate(context).toString());
	}

	@Override
	public Priority getPriority() {
		return null;
	}

}
