package org.eop.expreval.kpi.builder;

/**
 * 表达式读取器
 * @author lixinjie
 * @since 2018-06-14
 */
public interface Reader {

	/**
	 * 读取字符直至遇到停止符
	 */
	String read();
	
	/**
	 * 将已读出的字符回退回去
	 */
	void back();
}
