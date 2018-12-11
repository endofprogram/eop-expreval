package org.eop.expreval.kpi.utils;

/**
 * @author lixinjie
 * @since 2018-06-24
 */
public class StmtUtils {

	public static boolean isIf(String stmt) {
		return stmt.startsWith("if");
	}
	
	public static boolean isElse(String stmt) {
		return stmt.startsWith("else");
	}
}
