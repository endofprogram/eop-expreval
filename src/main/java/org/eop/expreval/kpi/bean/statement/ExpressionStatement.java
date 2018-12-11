package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Statement;

/**
 * 表达式语句
 * @author lixinjie
 * @since 2018-06-25
 */
public interface ExpressionStatement extends Statement {

	Expression getExpression();
	
	void setExpression(Expression expression);
}
