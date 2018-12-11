package org.eop.expreval.kpi.function;

/**
 * @author lixinjie
 * @since 2018-06-25
 */
public abstract class AbstractFunction implements Function {

	private String name;
	private String type;
	private String body;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getType() {
		return type;
	}
	
	@Override
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String getBody() {
		return body;
	}
	
	@Override
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public abstract void compile();
	
	@Override
	public abstract Object call(Object... params);

}
