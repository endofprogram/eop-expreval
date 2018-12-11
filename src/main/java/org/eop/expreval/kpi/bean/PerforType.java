package org.eop.expreval.kpi.bean;

import java.util.Date;

/**
 * 绩效类型
 * @author lixinjie
 * @since 2018-06-24
 */
public class PerforType {

	//编码
	private String typeCode;
	//名称
	private String typeName;
	//显示顺序
	private Integer showOrder;
	private Date insertTime;
	private Date updateTime;
	
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
}
