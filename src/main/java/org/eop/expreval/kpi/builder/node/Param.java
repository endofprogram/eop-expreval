package org.eop.expreval.kpi.builder.node;

import java.util.List;

import org.eop.expreval.kpi.builder.Node;

/**
 * 函数参数
 * @author lixinjie
 * @since 2018-06-15
 */
public interface Param extends Node {

	void addNode(Node node);
	
	List<Node> getNodes();
}
