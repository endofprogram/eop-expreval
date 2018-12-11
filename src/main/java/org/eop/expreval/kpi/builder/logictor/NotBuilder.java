package org.eop.expreval.kpi.builder.logictor;

import org.eop.expreval.kpi.Logictor;
import org.eop.expreval.kpi.logictor.Not;

/**
 * @author lixinjie
 * @since 2018-06-21
 */
public class NotBuilder implements LogictorBuilder {

	@Override
	public Logictor build() {
		return new Not();
	}

}
