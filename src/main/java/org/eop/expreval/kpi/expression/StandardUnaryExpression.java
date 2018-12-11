package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Operator;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 一元表达式实现
 * @author lixinjie
 * @since 2018-06-11
 */
public class StandardUnaryExpression extends AbstractExpression implements UnaryExpression {

	private Operator operator;
	private Expression operand;
	
	@Override
	public Operator getOperator() {
		return operator;
	}

	@Override
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	@Override
	public Expression getOperand() {
		return operand;
	}

	@Override
	public void setOperand(Expression operand) {
		this.operand = operand;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return operator.operate(context, operand);
	}

	@Override
	public Priority getPriority() {
		return operator.getPriority();
	}

}
