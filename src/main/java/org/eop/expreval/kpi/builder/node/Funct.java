package org.eop.expreval.kpi.builder.node;

import java.util.List;

import org.eop.expreval.kpi.builder.Node;

/**
 * 函数，参数节点会被并入
 * @author lixinjie
 * @since 2018-06-14
 */
public interface Funct extends Node {

	void addParam(Node param);
	
	void addParams(List<Node> params);
	
	List<Node> getParams();
}
