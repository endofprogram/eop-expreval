package org.eop.expreval.kpi.builder.logictor;

import org.eop.expreval.kpi.Logictor;
import org.eop.expreval.kpi.logictor.Or;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class OrBuilder implements LogictorBuilder {

	@Override
	public Logictor build() {
		return new Or();
	}

}
