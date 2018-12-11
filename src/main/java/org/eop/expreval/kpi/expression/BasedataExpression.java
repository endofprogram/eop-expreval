package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 基础数据表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface BasedataExpression extends Expression {

	String getBasedataName();
	
	void setBasedataName(String basedataName);
}
