package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;

/**
 * 括号表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface ParenthesesExpression extends Expression {

	Expression getInnerExpression();
	
	void setInnerExpression(Expression innerExpression);
}
