package org.eop.expreval.kpi.builder.node;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Node;

/**
 * 合并，存储节点合并后生成的表达式
 * @author lixinjie
 * @since 2018-06-12
 */
public interface Merge extends Node {

	void setExpression(Expression expression);
}
