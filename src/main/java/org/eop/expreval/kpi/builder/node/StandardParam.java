package org.eop.expreval.kpi.builder.node;

import java.util.ArrayList;
import java.util.List;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Node;

/**
 * 实现函数参数
 * @author lixinjie
 * @since 2018-06-15
 */
public class StandardParam extends AbstractNode implements Param {

	private List<Node> nodes = new ArrayList<>(4);
	
	@Override
	public void addNode(Node node) {
		nodes.add(node);
	}

	@Override
	public List<Node> getNodes() {
		return nodes;
	}

	@Override
	public Expression buildExpression() {
		return null;
	}

}
