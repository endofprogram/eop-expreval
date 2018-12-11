package org.eop.expreval.kpi.test;

import org.eop.expreval.kpi.ExpEvalContext;
import org.eop.expreval.kpi.Expression;
import org.eop.expreval.kpi.builder.StandardExprBuilder;
import org.eop.expreval.kpi.function.Function;
import org.eop.expreval.kpi.function.StandardFunction;

/**
 * @author lixinjie
 * @since 2018-06-25
 */
public class FunctTest {

	public static void main(String[] args) {
		Function funct = new StandardFunction();
		funct.setName("f_sms");
		funct.setType("superstar");
		funct.setBody("if a_arg0 >= 0.985 then 20;"
				+ "if a_arg0 < 0.96 then 0;"
				+ "if a_arg1 <= 0.2 then 0.95 * 20;"
				+ "if a_arg1 <= 0.4 then 0.9 * 20;"
				+ "if a_arg1 <= 0.6 then 0.8 * 20;"
				+ "if a_arg1 <= 0.7 then 0.7 * 20;"
				+ "if a_arg1 <= 0.8 then 0.6 * 20;"
				+ "if a_arg1 > 0.8 then 0.5 * 20;");
		funct.compile();
		System.out.println(funct.call(0.986));
		System.out.println(funct.call(0.985));
		System.out.println(funct.call(0.95));
		System.out.println(funct.call(0.984, 0.2));
		System.out.println(funct.call(0.96, 0.2));
		System.out.println(funct.call(0.984, 0.4));
		System.out.println(funct.call(0.96, 0.4));
		System.out.println(funct.call(0.984, 0.6));
		System.out.println(funct.call(0.96, 0.6));
		System.out.println(funct.call(0.984, 0.7));
		System.out.println(funct.call(0.96, 0.7));
		System.out.println(funct.call(0.984, 0.8));
		System.out.println(funct.call(0.96, 0.8));
		System.out.println(funct.call(0.984, 0.9));
		System.out.println(funct.call(0.96, 0.9));
		System.out.println("---------------------------");
		Expression exp = new StandardExprBuilder().build("f_sms(i_sms, i_odr)");
		ExpEvalContext context = new ExpEvalContext();
		context.addFunction("sms", funct);
		context.addIndicator("sms", 0.96);
		context.addIndicator("odr", 0.3);
		System.out.println(exp.evaluate(context));
	}
}
