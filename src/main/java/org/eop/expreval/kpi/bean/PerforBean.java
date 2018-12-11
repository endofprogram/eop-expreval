package org.eop.expreval.kpi.bean;

import java.util.Date;

/**
 * 绩效
 * @author lixinjie
 * @since 2018-06-24
 */
public class PerforBean {

	//编码
	private String perforCode;
	//名称
	private String perforName;
	//表达式
	private String perforExpression;
	//哪类员工的绩效
	private String perforType;
	//绩效说明
	private String perforIntro;
	//表达式说明
	private String expressionInto;
	//计算结果说明
	private String resultIntro;
	//测试样例
	private String testExample;
	//展示顺序（列表展示时的排序）
	private Integer showOrder;
	private Date insertTime;
	private Date updateTime;
	
	public String getPerforCode() {
		return perforCode;
	}
	public void setPerforCode(String perforCode) {
		this.perforCode = perforCode;
	}
	public String getPerforName() {
		return perforName;
	}
	public void setPerforName(String perforName) {
		this.perforName = perforName;
	}
	public String getPerforExpression() {
		return perforExpression;
	}
	public void setPerforExpression(String perforExpression) {
		this.perforExpression = perforExpression;
	}
	public String getPerforIntro() {
		return perforIntro;
	}
	public void setPerforIntro(String perforIntro) {
		this.perforIntro = perforIntro;
	}
	public String getExpressionInto() {
		return expressionInto;
	}
	public void setExpressionInto(String expressionInto) {
		this.expressionInto = expressionInto;
	}
	public String getResultIntro() {
		return resultIntro;
	}
	public void setResultIntro(String resultIntro) {
		this.resultIntro = resultIntro;
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
	public String getPerforType() {
		return perforType;
	}
	public void setPerforType(String perforType) {
		this.perforType = perforType;
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
}
