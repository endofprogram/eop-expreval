package org.eop.expreval.kpi.bean.statement;

import java.util.ArrayList;
import java.util.List;

import org.eop.expreval.kpi.Statement;
import org.eop.expreval.kpi.StmtExeContext;

/**
 * @author lixinjie
 * @since 2018-06-24
 */
public abstract class AbstractStatement implements Statement {

	private Statement parent;
	private List<Statement> children = new ArrayList<>();
	
	@Override
	public abstract Object execute(StmtExeContext context);

	@Override
	public Statement getParent() {
		return parent;
	}

	@Override
	public void setParent(Statement parent) {
		this.parent = parent;
	}

	@Override
	public void addChild(Statement child) {
		children.add(child);
	}

	@Override
	public List<Statement> getChildren() {
		return children;
	}

}
