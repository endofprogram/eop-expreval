package org.eop.expreval.kpi.bean.statement;

import org.eop.expreval.kpi.Statement;
import org.eop.expreval.kpi.StmtExeContext;

/**
 * @author lixinjie
 * @since 2018-06-24
 */
public class DelegateStatement extends AbstractStatement {

	@Override
	public Object execute(StmtExeContext context) {
		Object result = null;
		for (Statement child : getChildren()) {
			result = child.execute(context);
		}
		return result;
	}

}
