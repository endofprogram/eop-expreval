package org.eop.expreval.kpi.builder.node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.Node;
import org.eop.expreval.kpi.builder.expression.ExpressionBuilder;
import org.eop.expreval.kpi.builder.expression.FunctionBuilder;
import org.eop.expreval.kpi.expression.FunctionExpression;
import org.eop.expreval.kpi.utils.ExpUtils;

/**
 * 函数实现
 * @author lixinjie
 * @since 2018-06-13
 */
public class StandardFunct extends AbstractNode implements Funct {

	private List<Node> params = new ArrayList<>(5);
	
	private static Map<String, ExpressionBuilder> EXPRESSION_BUILDER;
	
	static {
		EXPRESSION_BUILDER = new HashMap<>();
		EXPRESSION_BUILDER.put("f_", new FunctionBuilder());
	}
	
	@Override
	public Expression buildExpression() {
		String mark = getMark();
		if (ExpUtils.isFunction(mark)) {
			FunctionExpression expression = (FunctionExpression)EXPRESSION_BUILDER.get("f_").build();
			expression.setFunctionName(mark.substring(2));
			Node funct = this;
			Node right = getRight();
			if (right != null) {
				boolean have = false;
				if (right instanceof Token) {
					addParam(right);
					have = true;
				} else if (right instanceof Param) {
					addParams(((Param)right).getNodes());
					have = true;
				} else if (right instanceof Merge) {
					addParam(right);
					have = true;
				}
				if (have) {
					Node rright = right.getRight();
					right.setLeft(null);
					right.setRight(null);
					funct.setRight(rright);
					if (rright != null) {
						rright.setLeft(funct);
					}
				}
			}
			for (Node param : params) {
				expression.addFunctionParam(param.buildExpression());
			}
			Node left = getLeft();
			right = getRight();
			Merge merge = new StandardMerge();
			merge.setExpression(expression);
			funct.setLeft(null);
			funct.setRight(null);
			merge.setLeft(left);
			merge.setRight(right);
			if (left != null) {
				left.setRight(merge);
			}
			if (right != null) {
				right.setLeft(merge);
			}
			return expression;
		}
		return null;
	}

	@Override
	public void addParam(Node param) {
		params.add(param);
	}
	
	@Override
	public void addParams(List<Node> params) {
		this.params.addAll(params);
	}

	@Override
	public List<Node> getParams() {
		return params;
	}

}
