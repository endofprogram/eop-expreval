package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Comparator;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 比较表达式实现
 * @author lixinjie
 * @since 2018-06-20
 */
public class StandardCompareExpression extends AbstractExpression implements CompareExpression {

	private Comparator comparator;
	private Expression leftOperand;
	private Expression rightOperand;
	
	@Override
	public Comparator getComparator() {
		return comparator;
	}

	@Override
	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
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
		return comparator.compare(context, leftOperand, rightOperand);
	}

	@Override
	public Priority getPriority() {
		return comparator.getPriority();
	}

}
