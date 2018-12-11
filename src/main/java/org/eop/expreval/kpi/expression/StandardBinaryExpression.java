package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Operator;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 二元表达式实现
 * @author lixinjie
 * @since 2018-06-11
 */
public class StandardBinaryExpression extends AbstractExpression implements BinaryExpression {

	private Operator operator;
	private Expression leftOperand;
	private Expression rightOperand;
	
	@Override
	public Operator getOperator() {
		return operator;
	}

	@Override
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public Expression getLeftOperand() {
		return leftOperand;
	}

	@Override
	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}

	@Override
	public Expression getRightOperand() {
		return rightOperand;
	}

	@Override
	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return operator.operate(context, leftOperand, rightOperand);
	}

	@Override
	public Priority getPriority() {
		return operator.getPriority();
	}

}
