package org.eop.expreval.kpi.builder;

import org.eop.expreval.kpi.Expression;

/**
 * 把表达式字符串转变为表达式
 * @author lixinjie
 * @since 2018-06-14
 */
public interface ExprBuilder {

	Expression build(String expression);
}
