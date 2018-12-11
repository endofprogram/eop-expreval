package org.eop.expreval.kpi.builder.node;

import org.eop.expreval.kpi.Expression;

/**
 * 合并实现
 * @author lixinjie
 * @since 2018-06-13
 */
public class StandardMerge extends AbstractNode implements Merge {

	private Expression expression;
	
	@Override
	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	@Override
	public Expression buildExpression() {
		return expression;
	}

}
