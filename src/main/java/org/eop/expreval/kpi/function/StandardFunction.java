package org.eop.expreval.kpi.function;

import org.eop.expreval.kpi.Statement;
import org.eop.expreval.kpi.StmtExeContext;
import org.eop.expreval.kpi.builder.StandardStmtBuilder;

/**
 * 函数实现
 * @author lixinjie
 * @since 2018-06-25
 */
public class StandardFunction extends AbstractFunction {

	private Statement statement;
	private StmtExeContext context;
	
	@Override
	public void compile() {
		statement = new StandardStmtBuilder().build(getBody());
		context = new StmtExeContext();
	}

	@Override
	public Object call(Object... params) {
		prepareArguments(params);
		return statement.execute(context);
	}

	private void prepareArguments(Object[] params) {
		context.clearArguments();
		for (int i = 0, len = params.length; i < len; i++) {
			context.addArgument("arg" + i, params[i]);
		}
	}
}
