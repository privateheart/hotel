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
public class HDic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer dicId;
	//类别id
	private Integer dicType;
	//名称
	private String dicName;
	//备注
	private String remark;
	//排序
	private Integer sort;
	//值
	private Integer value;

	/**
	 * 设置：id
	 */
	public void setDicId(Integer dicId) {
		this.dicId = dicId;
	}
	/**
	 * 获取：id
	 */
	public Integer getDicId() {
		return dicId;
	}
	/**
	 * 设置：类别id
	 */
	public void setDicType(Integer dicType) {
		this.dicType = dicType;
	}
	/**
	 * 获取：类别id
	 */
	public Integer getDicType() {
		return dicType;
	}
	/**
	 * 设置：名称
	 */
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	/**
	 * 获取：名称
	 */
	public String getDicName() {
		return dicName;
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
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：值
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	/**
	 * 获取：值
	 */
	public Integer getValue() {
		return value;
	}
}
