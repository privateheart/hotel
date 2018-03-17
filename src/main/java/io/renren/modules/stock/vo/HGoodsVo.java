package io.renren.modules.stock.vo;

import java.io.Serializable;
import java.util.Date;


/**
 * 物品表
 * 
 * @author ${author}
 * @email ${email}
 * @date 2018-03-04 09:01:11
 */
public class HGoodsVo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer goodsId;
	//物品名称
	private String goodsName;
	//物品类型
	private Integer goodsType;
	//创建时间
	private Date createTime;
	//创建人
	private Integer creator;
	//修改时间
	private Date modifyTime;
	//是否有效
	private Integer isValid;
	//修改者
	private Integer modifier;

	private String creatorName;

	private String modifierName;

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

	/**
	 * 设置：主键
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：主键
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：物品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：物品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：物品类型
	 */
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：物品类型
	 */
	public Integer getGoodsType() {
		return goodsType;
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
	 * 设置：修改时间
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModifyTime() {
		return modifyTime;
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
}
