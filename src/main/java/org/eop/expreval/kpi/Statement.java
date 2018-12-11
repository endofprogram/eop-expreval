package org.eop.expreval.kpi;

import java.util.List;

/**
 * 语句
 * @author lixinjie
 * @since 2018-06-24
 */
public interface Statement {

	Object execute(StmtExeContext context);
	
	Statement getParent();
	
	void setParent(Statement parent);
	
	void addChild(Statement child);
	
	List<Statement> getChildren();
}
