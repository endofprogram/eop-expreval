package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Statement;

/**
 * else语句
 * @author lixinjie
 * @since 2018-06-24
 */
public interface ElseStatement extends Statement {

	Expression getResult();
	
	void setResult(Expression result);
}
