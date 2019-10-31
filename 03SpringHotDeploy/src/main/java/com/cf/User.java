package com.cf;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private String userName;
	private String userId;
	@JSONField(format="yyyy-mm-dd")
	private Date createDate;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	

}
