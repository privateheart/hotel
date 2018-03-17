package io.renren.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-02-25 15:32:17
 */
public class HDicType implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer dicTypeId;
	//类别名称
	private String categoryName;
	//备注
	private String remark;

	/**
	 * 设置：id
	 */
	public void setDicTypeId(Integer dicTypeId) {
		this.dicTypeId = dicTypeId;
	}
	/**
	 * 获取：id
	 */
	public Integer getDicTypeId() {
		return dicTypeId;
	}
	/**
	 * 设置：类别名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：类别名称
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
