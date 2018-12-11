package org.eop.expreval.kpi.expression;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.builder.Priority;

/**
 * 基础数据表达式实现
 * @author lixinjie
 * @since 2018-06-12
 */
public class StandardBasedataExpression extends AbstractExpression implements BasedataExpression {

	private String basedataName;
	
	@Override
	public String getBasedataName() {
		return basedataName;
	}

	@Override
	public void setBasedataName(String basedataName) {
		this.basedataName = basedataName;
	}

	@Override
	public Object evaluate(ExpEvalContext context) {
		return context.getBasedataValue(basedataName);
	}

	@Override
	public Priority getPriority() {
		return Priority.Token();
	}

}
