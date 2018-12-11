package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Operable;

/**
 * 一元表达式
 * @author lixinjie
 * @since 2018-06-11
 */
public interface UnaryExpression extends Expression, Operable {

	Expression getOperand();
	
	void setOperand(Expression operand);
}
