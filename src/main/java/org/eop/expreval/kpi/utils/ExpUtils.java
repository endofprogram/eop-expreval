package org.eop.expreval.kpi.utils;

import java.util.regex.Pattern;

/**
 * @author lixinjie
 * @since 2018-06-12
 */
public class ExpUtils {

	public static final Pattern CONSTANT_PATTERN = Pattern.compile("\\d+\\.?\\d*");
	
	/**
	 * 数字常量
	 */
	public static boolean isConstant(String token) {
		char ch0 = token.charAt(0);
		return (ch0 >= '0' && ch0 <= '9') && CONSTANT_PATTERN.matcher(token).matches();
	}
	
	/**
	 * null常量
	 */
	public static boolean isNull(String token) {
		return "null".equalsIgnoreCase(token);
	}
	
	/**
	 * 空字符串常量
	 */
	public static boolean isEmpty(String token) {
		return "empty".equalsIgnoreCase(token);
	}
	
	/**
	 * 布尔常量
	 */
	public static boolean isBoolean(String token) {
		return "true".equalsIgnoreCase(token) || "false".equalsIgnoreCase(token);
	}
	
	/**
	 * 比较器
	 */
	public static boolean isComparator(String token) {
		return ">".equals(token)
				|| "<".equals(token)
				|| ">=".equals(token)
				|| "<=".equals(token)
				|| "==".equals(token)
				|| "!=".equals(token);
	}
	
	/**
	 * 逻辑器
	 */
	public static boolean isLogictor(String token) {
		return "&&".equals(token)
				|| "||".equals(token)
				|| "!".equals(token);
	}
	
	/**
	 * 以v_开头是变量
	 */
	public static boolean isVariable(String token) {
		return token.startsWith("v_");
	}
	
	/**
	 * 以b_开头是基础数据
	 */
	public static boolean isBasedata(String token) {
		return token.startsWith("b_");
	}
	
	/**
	 * 以i_开头是指标
	 */
	public static boolean isIndicator(String token) {
		return token.startsWith("i_");
	}
	
	/**
	 * 以f_开头是函数
	 */
	public static boolean isFunction(String token) {
		return token.startsWith("f_");
	}
	
	/**
	 * 以a_开头是对函数参数的引用
	 */
	public static boolean isArgument(String token) {
		return token.startsWith("a_");
	}
}
