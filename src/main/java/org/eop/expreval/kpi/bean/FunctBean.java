package org.eop.expreval.kpi.bean;

import java.util.Date;

/**
 * 函数
 * @author lixinjie
 * @since 2018-06-24
 */
public class FunctBean {

	//名称
	private String functName;
	//参数
	private String functParam;
	//体
	private String functBody;
	//用于哪种绩效类型
	private String perforType;
	//函数说明
	private String functIntro;
	//参数说明
	private String paramIntro;
	//返回值说明
	private String retvalIntro;
	//测试样例
	private String testExample;
	//展示顺序（列表展示时的排序）
	private Integer showOrder;
	private Date insertTime;
	private Date updateTime;
	
	public String getFunctName() {
		return functName;
	}
	public void setFunctName(String functName) {
		this.functName = functName;
	}
	public String getFunctParam() {
		return functParam;
	}
	public void setFunctParam(String functParam) {
		this.functParam = functParam;
	}
	public String getFunctBody() {
		return functBody;
	}
	public void setFunctBody(String functBody) {
		this.functBody = functBody;
	}
	public String getFunctIntro() {
		return functIntro;
	}
	public void setFunctIntro(String functIntro) {
		this.functIntro = functIntro;
	}
	public String getParamIntro() {
		return paramIntro;
	}
	public void setParamIntro(String paramIntro) {
		this.paramIntro = paramIntro;
	}
	public String getRetvalIntro() {
		return retvalIntro;
	}
	public void setRetvalIntro(String retvalIntro) {
		this.retvalIntro = retvalIntro;
	}
	public String getTestExample() {
		return testExample;
	}
	public void setTestExample(String testExample) {
		this.testExample = testExample;
	}
	public Integer getShowOrder() {
		return showOrder;
	}
	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getPerforType() {
		return perforType;
	}
	public void setPerforType(String perforType) {
		this.perforType = perforType;
	}
}
