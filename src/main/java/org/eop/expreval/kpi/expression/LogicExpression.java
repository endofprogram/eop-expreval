package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Logicable;

/**
 * 逻辑表达式
 * @author lixinjie
 * @since 2018-06-20
 */
public interface LogicExpression extends Expression, Logicable {

	Expression getLeftOperand();
	
	void setLeftOperand(Expression leftOperand);
	
	Expression getRightOperand();
	
	void setRightOperand(Expression rightOperand);
}
