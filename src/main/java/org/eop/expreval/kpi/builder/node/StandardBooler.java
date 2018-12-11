package org.eop.expreval.kpi.builder.node;

import java.util.HashMap;
import java.util.Map;

import org.eop.expreval.kpi.Comparator;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.Logictor;
import org.eop.expreval.kpi.builder.Node;
import org.eop.expreval.kpi.builder.comparator.ComparatorBuilder;
import org.eop.expreval.kpi.builder.comparator.EqBuilder;
import org.eop.expreval.kpi.builder.comparator.GtBuilder;
import org.eop.expreval.kpi.builder.comparator.GtEqBuilder;
import org.eop.expreval.kpi.builder.comparator.LtBuilder;
import org.eop.expreval.kpi.builder.comparator.LtEqBuilder;
import org.eop.expreval.kpi.builder.comparator.NtEqBuilder;
import org.eop.expreval.kpi.builder.expression.CompareBuilder;
import org.eop.expreval.kpi.builder.expression.ExpressionBuilder;
import org.eop.expreval.kpi.builder.expression.LogicBuilder;
import org.eop.expreval.kpi.builder.logictor.AndBuilder;
import org.eop.expreval.kpi.builder.logictor.LogictorBuilder;
import org.eop.expreval.kpi.builder.logictor.NotBuilder;
import org.eop.expreval.kpi.builder.logictor.OrBuilder;
import org.eop.expreval.kpi.expression.CompareExpression;
import org.eop.expreval.kpi.expression.LogicExpression;
import org.eop.expreval.kpi.utils.ExpUtils;

/**
 * 布尔连接器（操作符）实现
 * @author lixinjie
 * @since 2018-06-21
 */
public class StandardBooler extends AbstractNode implements Booler {

	private static Map<String, ComparatorBuilder> COMPARATOR_BUILDER;
	private static Map<String, LogictorBuilder> LOGICTOR_BUILDER;
	private static Map<String, ExpressionBuilder> EXPRESSION_BUILDER;
	
	static {
		COMPARATOR_BUILDER = new HashMap<>();
		COMPARATOR_BUILDER.put(">", new GtBuilder());
		COMPARATOR_BUILDER.put("<", new LtBuilder());
		COMPARATOR_BUILDER.put(">=", new GtEqBuilder());
		COMPARATOR_BUILDER.put("<=", new LtEqBuilder());
		COMPARATOR_BUILDER.put("==", new EqBuilder());
		COMPARATOR_BUILDER.put("!=", new NtEqBuilder());
		
		LOGICTOR_BUILDER = new HashMap<>();
		LOGICTOR_BUILDER.put("&&", new AndBuilder());
		LOGICTOR_BUILDER.put("||", new OrBuilder());
		LOGICTOR_BUILDER.put("!", new NotBuilder());
		
		EXPRESSION_BUILDER = new HashMap<>();
		ExpressionBuilder compareBuilder = new CompareBuilder();
		ExpressionBuilder LogicBuilder = new LogicBuilder();
		EXPRESSION_BUILDER.put(">", compareBuilder);
		EXPRESSION_BUILDER.put("<", compareBuilder);
		EXPRESSION_BUILDER.put(">=", compareBuilder);
		EXPRESSION_BUILDER.put("<=", compareBuilder);
		EXPRESSION_BUILDER.put("==", compareBuilder);
		EXPRESSION_BUILDER.put("!=", compareBuilder);
		EXPRESSION_BUILDER.put("&&", LogicBuilder);
		EXPRESSION_BUILDER.put("||", LogicBuilder);
		EXPRESSION_BUILDER.put("!", LogicBuilder);
	}
	
	@Override
	public Expression buildExpression() {
		String mark = getMark();
		Node booler = this;
		Node left = getLeft();
		Node right = getRight();
		if (ExpUtils.isLogictor(mark)) {
			Logictor logictor = LOGICTOR_BUILDER.get(mark).build();
			LogicExpression expression = (LogicExpression)EXPRESSION_BUILDER.get(mark).build();
			expression.setLogictor(logictor);
			if ("!".equals(mark)) {
				expression.setLeftOperand(null);
				expression.setRightOperand(right.buildExpression());
				Merge merge = new StandardMerge();
				merge.setExpression(expression);
				Node rright = right.getRight();
				booler.setLeft(null);
				booler.setRight(null);
				right.setLeft(null);
				right.setRight(null);
				merge.setLeft(left);
				merge.setRight(rright);
				if (left != null) {
					left.setRight(merge);
				}
				if (rright != null) {
					rright.setLeft(merge);
				}
				return expression;
			}
			expression.setLeftOperand(left.buildExpression());
			expression.setRightOperand(right.buildExpression());
			Merge merge = new StandardMerge();
			merge.setExpression(expression);
			Node lleft = left.getLeft();
			Node rright = right.getRight();
			left.setLeft(null);
			left.setRight(null);
			booler.setLeft(null);
			booler.setRight(null);
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
		if (ExpUtils.isComparator(mark)) {
			Comparator comparator = COMPARATOR_BUILDER.get(mark).build();
			CompareExpression expression = (CompareExpression)EXPRESSION_BUILDER.get(mark).build();
			expression.setComparator(comparator);
			expression.setLeftOperand(left.buildExpression());
			expression.setRightOperand(right.buildExpression());
			Merge merge = new StandardMerge();
			merge.setExpression(expression);
			Node lleft = left.getLeft();
			Node rright = right.getRight();
			left.setLeft(null);
			left.setRight(null);
			booler.setLeft(null);
			booler.setRight(null);
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
		return null;
	}

}
