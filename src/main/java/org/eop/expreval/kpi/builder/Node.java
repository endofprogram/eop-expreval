package org.eop.expreval.kpi.builder;

import org.eop.expreval.kpi.Expression;

/**
 * 节点，用于构建表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface Node {

	String getMark();
	void setMark(String mark);
	
	Node getLeft();
	void setLeft(Node node);
	
	Node getRight();
	void setRight(Node node);
	
	Priority getPriority();
	void setPriority(Priority priority);
	void plusPriority(Priority priority);
	
	Expression buildExpression();
}
