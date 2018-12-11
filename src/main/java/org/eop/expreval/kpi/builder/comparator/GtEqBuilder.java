package org.eop.expreval.kpi.builder.comparator;

import org.eop.expreval.kpi.Comparator;
import org.eop.expreval.kpi.comparator.GtEq;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class GtEqBuilder implements ComparatorBuilder {

	@Override
	public Comparator build() {
		return new GtEq();
	}

}
