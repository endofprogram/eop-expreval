package org.eop.expreval.kpi.function;

/**
 * 函数
 * @author lixinjie
 * @since 2018-06-12
 */
public interface Function {

	String getName();
	void setName(String name);
	
	String getType();
	void setType(String type);
	
	String getBody();
	void setBody(String body);
	
	void compile();
	
	Object call(Object... params);
}
