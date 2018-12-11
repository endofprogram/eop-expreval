package org.eop.expreval.kpi.comparator;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 不相等
 * @author lixinjie
 * @since 2018-06-20
 */
public class NtEq extends AbstractComparator {

	@Override
	public Boolean compare(ExpEvalContext context, Expression... exps) {
		return !exps[0].evaluate(context).equals(exps[1].evaluate(context));
	}

	@Override
	public Priority getPriority() {
		return null;
	}

}
