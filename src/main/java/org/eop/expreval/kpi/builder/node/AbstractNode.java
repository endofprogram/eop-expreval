package org.eop.expreval.kpi.builder.node;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Node;
import org.eop.expreval.kpi.builder.Priority;

/**
 * @author lixinjie
 * @since 2018-06-13
 */
public abstract class AbstractNode implements Node {

	private String mark;
	private Node left;
	private Node right;
	private Priority priority;
	
	@Override
	public String getMark() {
		return mark;
	}

	@Override
	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public Node getLeft() {
		return left;
	}

	@Override
	public void setLeft(Node node) {
		this.left = node;
	}

	@Override
	public Node getRight() {
		return right;
	}

	@Override
	public void setRight(Node node) {
		this.right = node;
	}
	
	@Override
	public Priority getPriority() {
		return priority;
	}
	
	@Override
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	@Override
	public void plusPriority(Priority priority) {
		if (this.priority != null) {
			this.priority.plus(priority);
		}
	}

	@Override
	public abstract Expression buildExpression();

}
