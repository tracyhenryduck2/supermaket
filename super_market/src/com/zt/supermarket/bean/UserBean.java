package com.zt.supermarket.bean;

import com.avatar.db.annotation.Column;
import com.avatar.db.annotation.GeneratorType;
import com.avatar.db.annotation.Table;

@Table(name="user")
public class UserBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;
	

	/**
	 * 登陆方式:1:self，2:微信，3:qq
	*/
	@Column(name="type")
	private Long type;

	/**
	 * 登录名 
	*/
	@Column(name="username")
	private String username;

	/**
	 * 昵称 
	*/
	@Column(name="nickname")
	private String nickname;

	
	/**
	 * 登录密码 
	*/
	@Column(name="password")
	private String password;

	
	/**
	 * 头像
	*/
	@Column(name="avatar")
	private String avatar;

	/**
	 * 微信授权openid
	*/
	@Column(name="openid")
	private String openid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	
}
