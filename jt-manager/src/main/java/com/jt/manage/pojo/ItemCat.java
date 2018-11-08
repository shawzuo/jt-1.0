package com.jt.manage.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jt.common.po.BasePojo;

@Table(name="tb_item_cat")
public class ItemCat extends BasePojo{
	
	@Id	//主键定义
	//主键自增
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	//商品分类Id
	private Long parentId;	//商品分类的父级id
	private String name;	//商品分类名称
	private Integer status;	//1正常，2删除',
	private Integer sortOrder;//排序号
	private Boolean isParent;	//定义是否为上级
	
	/**
	 * 为了实现树形结构满足格式要求添加getXXX方法 
	 */
	public String getText(){
		return name;
	}
	//控制节点是否关闭 
	//state：节点状态，'open' 或 'closed'，
	//默认：'open'。如果为'closed'的时候，将不自动展开该节点。

	public String getState(){
		
		return isParent ? "closed": "open";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	
	
}
