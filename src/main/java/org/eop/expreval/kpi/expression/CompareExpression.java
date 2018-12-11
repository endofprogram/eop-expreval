package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Comparable;
import org.eop.expreval.kpi.Expression;

/**
 * 比较表达式
 * @author lixinjie
 * @since 2018-06-20
 */
public interface CompareExpression extends Expression, Comparable {

	Expression getLeftOperand();
	
	void setLeftOperand(Expression leftOperand);
	
	Expression getRightOperand();
	
	void setRightOperand(Expression rightOperand);
}
