package org.eop.expreval.kpi.builder.node;

import java.util.HashMap;
import java.util.Map;

import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.expression.ArgumentBuilder;
import org.eop.expreval.kpi.builder.expression.BasedataBuilder;
import org.eop.expreval.kpi.builder.expression.BooleanBuilder;
import org.eop.expreval.kpi.builder.expression.ConstantBuilder;
import org.eop.expreval.kpi.builder.expression.EmptyBuilder;
import org.eop.expreval.kpi.builder.expression.ExpressionBuilder;
import org.eop.expreval.kpi.builder.expression.IndicatorBuilder;
import org.eop.expreval.kpi.builder.expression.LiteralBuilder;
import org.eop.expreval.kpi.builder.expression.NullBuilder;
import org.eop.expreval.kpi.builder.expression.VariableBuilder;
import org.eop.expreval.kpi.expression.ArgumentExpression;
import org.eop.expreval.kpi.expression.BasedataExpression;
import org.eop.expreval.kpi.expression.BooleanExpression;
import org.eop.expreval.kpi.expression.ConstantExpression;
import org.eop.expreval.kpi.expression.EmptyExpression;
import org.eop.expreval.kpi.expression.IndicatorExpression;
import org.eop.expreval.kpi.expression.LiteralExpression;
import org.eop.expreval.kpi.expression.NullExpression;
import org.eop.expreval.kpi.expression.VariableExpression;
import org.eop.expreval.kpi.utils.ExpUtils;

/**
 * 实现标记
 * @author lixinjie
 * @since 2018-06-13
 */
public class StandardToken extends AbstractNode implements Token {

	private static Map<String, ExpressionBuilder> EXPRESSION_BUILDER;
	
	static {
		EXPRESSION_BUILDER = new HashMap<>();
		EXPRESSION_BUILDER.put("constant", new ConstantBuilder());
		EXPRESSION_BUILDER.put("v_", new VariableBuilder());
		EXPRESSION_BUILDER.put("b_", new BasedataBuilder());
		EXPRESSION_BUILDER.put("i_", new IndicatorBuilder());
		EXPRESSION_BUILDER.put("a_", new ArgumentBuilder());
		EXPRESSION_BUILDER.put("null", new NullBuilder());
		EXPRESSION_BUILDER.put("empty", new EmptyBuilder());
		EXPRESSION_BUILDER.put("true", new BooleanBuilder());
		EXPRESSION_BUILDER.put("false", new BooleanBuilder());
		EXPRESSION_BUILDER.put("literal", new LiteralBuilder());
	}
	
	@Override
	public Expression buildExpression() {
		String mark = getMark();
		if (ExpUtils.isConstant(mark)) {
			ConstantExpression expression = (ConstantExpression)EXPRESSION_BUILDER.get("constant").build();
			expression.setConstantValue(Double.valueOf(mark));
			return expression;
		}
		if (ExpUtils.isVariable(mark)) {
			VariableExpression expression = (VariableExpression)EXPRESSION_BUILDER.get("v_").build();
			expression.setVariableName(mark.substring(2));
			return expression;
		}
		if (ExpUtils.isBasedata(mark)) {
			BasedataExpression expression = (BasedataExpression)EXPRESSION_BUILDER.get("b_").build();
			expression.setBasedataName(mark.substring(2));
			return expression;
		}
		if (ExpUtils.isIndicator(mark)) {
			IndicatorExpression expression = (IndicatorExpression)EXPRESSION_BUILDER.get("i_").build();
			expression.setIndicatorName(mark.substring(2));
			return expression;
		}
		if (ExpUtils.isArgument(mark)) {
			ArgumentExpression expression = (ArgumentExpression)EXPRESSION_BUILDER.get("a_").build();
			expression.setArgumentName(mark.substring(2));
			return expression;
		}
		if (ExpUtils.isNull(mark)) {
			NullExpression expression = (NullExpression)EXPRESSION_BUILDER.get(mark.toLowerCase()).build();
			expression.setNullValue(null);
			return expression;
		}
		if (ExpUtils.isEmpty(mark)) {
			EmptyExpression expression = (EmptyExpression)EXPRESSION_BUILDER.get(mark.toLowerCase()).build();
			expression.setEmptyValue("");
			return expression;
		}
		if (ExpUtils.isBoolean(mark)) {
			BooleanExpression expression = (BooleanExpression)EXPRESSION_BUILDER.get(mark.toLowerCase()).build();
			expression.setBooleanValue(Boolean.valueOf(mark));
			return expression;
		}
		LiteralExpression expression = (LiteralExpression)EXPRESSION_BUILDER.get("literal").build();
		expression.setLiteralValue(mark);
		return expression;
	}

}
