package org.eop.expreval.kpi.builder.comparator;

import org.eop.expreval.kpi.Comparator;
import org.eop.expreval.kpi.comparator.Gt;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class GtBuilder implements ComparatorBuilder {

	@Override
	public Comparator build() {
		return new Gt();
	}

}
