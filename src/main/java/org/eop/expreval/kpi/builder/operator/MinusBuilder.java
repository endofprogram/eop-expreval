package org.eop.expreval.kpi.builder.operator;

import org.eop.expreval.kpi.Operator;
import org.eop.expreval.kpi.operator.Minus;

/**
 * @author lixinjie
 * @since 2018-06-13
 */
public class MinusBuilder implements OperatorBuilder {

	@Override
	public Operator build() {
		return new Minus();
	}

}
