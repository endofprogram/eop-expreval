package org.eop.expreval.kpi;

import org.eop.expreval.kpi.builder.StandardStmtBuilder;

/**
 * @author lixinjie
 * @since 2018-06-17
 */
public class Main {

	public static void main(String[] args) {
		/*
		Expression exp1 = new StandardExprBuilder().build("-(-10) / 2 * 4 + -(-1) * (10 + 20 * 10) * 6");
		Expression exp2 = new StandardExprBuilder().build("f_sum(v_ten,10^2,f_sum(i_one,i_two,i_three,i_four),b_ten)");
		Expression exp3 = new StandardExprBuilder().build("3.14");
		Expression exp4 = new StandardExprBuilder().build("!(!3.14 == 3.14 && !abc == abc && !2 < 3 && !true == true && !false == false && !true && !false)");
		Expression exp5 = new StandardExprBuilder().build("!(!(!true)) || !(!(!false))");
		Expression exp6 = new StandardExprBuilder().build("!(3 / 2 + 5 * 10 > 10 * 45 / 54 - 88) == (你好 != 你好)");
		ExpEvalContext context = new ExpEvalContext();
		context.addVariable("ten", 10);
		context.addBasedata("ten", 10);
		context.addIndicator("one", 1.0);
		context.addIndicator("two", 2.0);
		context.addIndicator("three", 3.0);
		context.addIndicator("four", 4.0);
		context.addFunction("sum", new Function() {

			@Override
			public String getName() {
				return "sum";
			}

			@Override
			public String getType() {
				return "simple";
			}
			
			@Override
			public void setBody(String body) {
			}

			@Override
			public void compile() {
			}

			@Override
			public Object call(Object[] params) {
				Double value = 0.0;
				for (Object param : params) {
					value += Double.valueOf(param.toString());
				}
				return value;
			}});
		System.out.println(exp1.evaluate(context));
		System.out.println(exp2.evaluate(context));
		System.out.println(exp3.evaluate(context));
		System.out.println(exp4.evaluate(context));
		System.out.println(exp5.evaluate(context));
		System.out.println(exp6.evaluate(context));
		*/
		Statement stmt1 = new StandardStmtBuilder().build("if aa==a then 10;if bb==b then 20;else 30;");
		Statement stmt2 = new StandardStmtBuilder().build("if i_sms >= 0.8 then 10; if i_sms >= 0.6 then 20; else 30;");
		Statement stmt3 = new StandardStmtBuilder().build("20.1 - 20.0 * 541.5 / 4585.65 + 25^2.1");
		StmtExeContext ctx = new StmtExeContext();
		ctx.addIndicator("sms", 0.1);
		System.out.println(stmt1.execute(ctx));
		System.out.println(stmt2.execute(ctx));
		System.out.println(stmt3.execute(ctx));
	}

}
