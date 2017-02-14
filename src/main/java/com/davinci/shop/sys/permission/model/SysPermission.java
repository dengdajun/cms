package com.davinci.shop.sys.permission.model;

public class SysPermission {
	private Integer id;
	private Integer parentId;
	private String permissionsName;
	private String permissionsDesc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getPermissionsName() {
		return permissionsName;
	}
	public void setPermissionsName(String permissionsName) {
		this.permissionsName = permissionsName;
	}
	public String getPermissionsDesc() {
		return permissionsDesc;
	}
	public void setPermissionsDesc(String permissionsDesc) {
		this.permissionsDesc = permissionsDesc;
	}
	
	

}
