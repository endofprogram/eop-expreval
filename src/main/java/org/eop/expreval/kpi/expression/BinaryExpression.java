package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Operable;

/**
 * 二元表达式
 * @author lixinjie
 * @since 2018-06-11
 */
public interface BinaryExpression extends Expression, Operable {

	Expression getLeftOperand();
	
	void setLeftOperand(Expression leftOperand);
	
	Expression getRightOperand();
	
	void setRightOperand(Expression rightOperand);
}
