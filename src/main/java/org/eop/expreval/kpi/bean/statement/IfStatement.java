package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Statement;

/**
 * if语句
 * @author lixinjie
 * @since 2018-06-24
 */
public interface IfStatement extends Statement {

	Expression getCondition();
	
	void setCondition(Expression condition);
	
	Expression getResult();
	
	void setResult(Expression result);
	
	Statement getNext();
	
	void setNext(Statement next);
}
