package org.eop.expreval.kpi;

/**
 * 可比较的
 * @author lixinjie
 * @since 2018-06-20
 */
public interface Comparable {

	Comparator getComparator();
	
	void setComparator(Comparator comparator);
}
