package org.eop.expreval.kpi.builder.node;

import java.util.HashMap;
import java.util.Map;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Operator;
import org.eop.expreval.kpi.builder.Node;
import org.eop.expreval.kpi.builder.expression.BinaryBuilder;
import org.eop.expreval.kpi.builder.expression.ExpressionBuilder;
import org.eop.expreval.kpi.builder.expression.UnaryBuilder;
import org.eop.expreval.kpi.builder.operator.AddBuilder;
import org.eop.expreval.kpi.builder.operator.DivBuilder;
import org.eop.expreval.kpi.builder.operator.MinusBuilder;
import org.eop.expreval.kpi.builder.operator.MulBuilder;
import org.eop.expreval.kpi.builder.operator.OperatorBuilder;
import org.eop.expreval.kpi.builder.operator.PositiveBuilder;
import org.eop.expreval.kpi.builder.operator.PowBuilder;
import org.eop.expreval.kpi.builder.operator.SubBuilder;
import org.eop.expreval.kpi.expression.BinaryExpression;
import org.eop.expreval.kpi.expression.UnaryExpression;

/**
 * 链接器（操作符）实现
 * @author lixinjie
 * @since 2018-06-13
 */
public class StandardLinker extends AbstractNode implements Linker {

	private static Map<String, OperatorBuilder> OPERATOR_BUILDER;
	private static Map<String, ExpressionBuilder> EXPRESSION_BUILDER;
	
	static {
		OPERATOR_BUILDER = new HashMap<>();
		OPERATOR_BUILDER.put("+", new AddBuilder());
		OPERATOR_BUILDER.put("-", new SubBuilder());
		OPERATOR_BUILDER.put("*", new MulBuilder());
		OPERATOR_BUILDER.put("/", new DivBuilder());
		OPERATOR_BUILDER.put("^", new PowBuilder());
		OPERATOR_BUILDER.put("(+", new PositiveBuilder());
		OPERATOR_BUILDER.put("(-", new MinusBuilder());
		
		EXPRESSION_BUILDER = new HashMap<>();
		ExpressionBuilder binaryBuilder = new BinaryBuilder();
		ExpressionBuilder unaryBuilder = new UnaryBuilder();
		EXPRESSION_BUILDER.put("+", binaryBuilder);
		EXPRESSION_BUILDER.put("-", binaryBuilder);
		EXPRESSION_BUILDER.put("*", binaryBuilder);
		EXPRESSION_BUILDER.put("/", binaryBuilder);
		EXPRESSION_BUILDER.put("^", binaryBuilder);
		EXPRESSION_BUILDER.put("(+", unaryBuilder);
		EXPRESSION_BUILDER.put("(-", unaryBuilder);
	}
	
	@Override
	public Expression buildExpression() {
		String mark = getMark();
		Node linker = this;
		Node left = getLeft();
		Node right = getRight();
		if ("+".equals(mark) || "-".equals(mark)) {
			if ((left == null) || (left instanceof Linker)) {
				mark = "(" + mark;
				Operator operator = OPERATOR_BUILDER.get(mark).build();
				UnaryExpression expression = (UnaryExpression)EXPRESSION_BUILDER.get(mark).build();
				expression.setOperator(operator);
				expression.setOperand(right.buildExpression());
				Node rright = right.getRight();
				Merge merge = new StandardMerge();
				merge.setExpression(expression);
				linker.setLeft(null);
				linker.setRight(null);
				right.setLeft(null);
				right.setRight(null);
				merge.setLeft(left);
				if (left != null) {
					left.setRight(merge);
				}
				merge.setRight(rright);
				if (rright != null) {
					rright.setLeft(merge);
				}
				return expression;
			}
		}
		Operator operator = OPERATOR_BUILDER.get(mark).build();
		BinaryExpression expression = (BinaryExpression)EXPRESSION_BUILDER.get(mark).build();
		expression.setOperator(operator);
		expression.setLeftOperand(left.buildExpression());
		expression.setRightOperand(right.buildExpression());
		Node lleft = left.getLeft();
		Node rright = right.getRight();
		Merge merge = new StandardMerge();
		merge.setExpression(expression);
		left.setLeft(null);
		left.setRight(null);
		linker.setLeft(null);
		linker.setRight(null);
		right.setLeft(null);
		right.setRight(null);
		merge.setLeft(lleft);
		merge.setRight(rright);
		if (lleft != null) {
			lleft.setRight(merge);
		}
		if (rright != null) {
			rright.setLeft(merge);
		}
		return expression;
	}

}
