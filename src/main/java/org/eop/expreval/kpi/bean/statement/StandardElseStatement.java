package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.StmtExeContext;

/**
 * else语句实现
 * @author lixinjie
 * @since 2018-06-24
 */
public class StandardElseStatement extends AbstractStatement implements ElseStatement {

	private Expression result;
	
	@Override
	public Expression getResult() {
		return result;
	}

	@Override
	public void setResult(Expression result) {
		this.result = result;
	}

	@Override
	public Object execute(StmtExeContext context) {
		return result.evaluate(context);
	}

}
