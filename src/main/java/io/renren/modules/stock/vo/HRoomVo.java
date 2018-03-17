package io.renren.modules.stock.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 厅房表Vo
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-07 19:49:15
 */
public class HRoomVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//注解
	private Integer roomId;
	//厅名字
	private String roomName;
	//最大容纳人数
	private Integer seatingCapacity;
	//厅管理人
	private Integer custodian;
	//创建时间
	private Date createTime;
	//更新时间
	private Date modifyTime;
	//创建人
	private Integer creator;
	//修改者
	private Integer modifier;
	//是否有效
	private Integer isValid;
	//创建者
	private String creatorName;
	//修改者
	private String modifierName;

	private String custodianName;
	/**
	 * 设置：注解
	 */
	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	/**
	 * 获取：注解
	 */
	public Integer getRoomId() {
		return roomId;
	}
	/**
	 * 设置：厅名字
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * 获取：厅名字
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * 设置：最大容纳人数
	 */
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	/**
	 * 获取：最大容纳人数
	 */
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	/**
	 * 设置：厅管理人
	 */
	public void setCustodian(Integer custodian) {
		this.custodian = custodian;
	}
	/**
	 * 获取：厅管理人
	 */
	public Integer getCustodian() {
		return custodian;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreator() {
		return creator;
	}
	/**
	 * 设置：修改者
	 */
	public void setModifier(Integer modifier) {
		this.modifier = modifier;
	}
	/**
	 * 获取：修改者
	 */
	public Integer getModifier() {
		return modifier;
	}
	/**
	 * 设置：是否有效
	 */
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	/**
	 * 获取：是否有效
	 */
	public Integer getIsValid() {
		return isValid;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getModifierName() {
		return modifierName;
	}

	public void setModifierName(String modifierName) {
		this.modifierName = modifierName;
	}

	public String getCustodianName() {
		return custodianName;
	}

	public void setCustodianName(String custodianName) {
		this.custodianName = custodianName;
	}
}
