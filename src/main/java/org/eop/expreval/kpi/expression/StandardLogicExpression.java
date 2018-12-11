package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Logictor;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 逻辑表达式实现
 * @author lixinjie
 * @since 2018-06-20
 */
public class StandardLogicExpression extends AbstractExpression implements LogicExpression {

	private Logictor logictor;
	private Expression leftOperand;
	private Expression rightOperand;
	
	@Override
	public Logictor getLogictor() {
		return logictor;
	}

	@Override
	public void setLogictor(Logictor logictor) {
		this.logictor = logictor;
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
		return logictor.logic(context, leftOperand, rightOperand);
	}

	@Override
	public Priority getPriority() {
		return logictor.getPriority();
	}

}
