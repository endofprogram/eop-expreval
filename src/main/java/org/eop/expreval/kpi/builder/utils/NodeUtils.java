package org.eop.expreval.kpi.builder.utils;

import java.util.regex.Pattern;

/**
 * @author lixinjie
 * @since 2018-06-14
 */
public class NodeUtils {

	public static final Pattern CONSTANT_PATTERN = Pattern.compile("\\d+\\.?\\d*");
	
	public static boolean isToken(String mark) {
		char ch0 = mark.charAt(0);
		return (ch0 >= '0' && ch0 <= '9' && CONSTANT_PATTERN.matcher(mark).matches())
				|| mark.startsWith("v_")
				|| mark.startsWith("b_")
				|| mark.startsWith("i_")
				|| mark.startsWith("a_")
				|| "null".equalsIgnoreCase(mark)
				|| "empty".equalsIgnoreCase(mark)
				|| "true".equalsIgnoreCase(mark)
				|| "false".equalsIgnoreCase(mark);
	}
	
	public static boolean isFunct(String mark) {
		return mark.startsWith("f_");
	}
	
	public static boolean isLinker(String mark) {
		char ch = mark.charAt(0);
		return ch == '+'
				|| ch == '-'
				|| ch == '*'
				|| ch == '/'
				|| ch == '^';
	}
	
	public static boolean isBooler(String mark) {
		char ch = mark.charAt(0);
		return ch == '>'
				|| ch == '<'
				|| ch == '='
				|| ch == '&'
				|| ch == '|'
				|| ch == '!';
	}
	
	public static boolean isComma(String mark) {
		char ch = mark.charAt(0);
		return ch == ',';
	}
	
}
