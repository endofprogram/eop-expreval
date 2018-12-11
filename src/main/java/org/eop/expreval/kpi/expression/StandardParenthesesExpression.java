package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 括号表达式实现
 * @author lixinjie
 * @since 2018-06-12
 */
public class StandardParenthesesExpression extends AbstractExpression implements ParenthesesExpression {

	private Expression innerExpression;
	
	@Override
	public Expression getInnerExpression() {
		return innerExpression;
	}

	@Override
	public void setInnerExpression(Expression innerExpression) {
		this.innerExpression = innerExpression;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return innerExpression.evaluate(context);
	}

	@Override
	public Priority getPriority() {
		return Priority.Parent();
	}

}
