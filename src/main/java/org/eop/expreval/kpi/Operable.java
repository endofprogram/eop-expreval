package org.eop.expreval.kpi;

/**
 * 可运算的
 * @author lixinjie
 * @since 2018-06-11
 */
public interface Operable {

	Operator getOperator();
	
	void setOperator(Operator operator);
}
