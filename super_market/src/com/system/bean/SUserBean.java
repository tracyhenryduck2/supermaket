package com.system.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 系统用户表
 * @author xin.chou
 *
 */
@Table(name="s_user")
public class SUserBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 用户名 
	*/
	@Column(name="username")
	private String username;

	/**
	 * 密码 
	*/
	@Column(name="password")
	private String password;

	/**
	 * 昵称 
	*/
	@Column(name="nickname")
	private String nickname;

	/**
	 * 电话 
	*/
	@Column(name="tel")
	private String tel;

	/**
	 * 邮箱 
	*/
	@Column(name="email")
	private String email;

	/**
	 * 状态 
	*/
	@Column(name="state")
	private Long state;

	/**
	 * 备注 
	*/
	@Column(name="comments")
	private String comments;
	
	
	/*
	 * 权限
	 */
	@Column(name="role")
	private Long role;
	
	/*
	 * 超市编号
	 */
	@Column(name="market_id")
	private Long marketId;
    	
    /** 
     * 
     * @return 
     */ 
    public Long getId() {
    	return id;
    }
    
    /** 
     * 
     * @param 
     */ 
    public void setId(Long id) {
    	this.id = id;
    }
    	
    /** 
     * 用户名
     * @return 
     */ 
    public String getUsername() {
    	return username;
    }
    
    /** 
     * 用户名
     * @param 
     */ 
    public void setUsername(String username) {
    	this.username = username;
    }
    	
    /** 
     * 密码
     * @return 
     */ 
    public String getPassword() {
    	return password;
    }
    
    /** 
     * 密码
     * @param 
     */ 
    public void setPassword(String password) {
    	this.password = password;
    }
    	
    /** 
     * 昵称
     * @return 
     */ 
    public String getNickname() {
    	return nickname;
    }
    
    /** 
     * 昵称
     * @param 
     */ 
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }
    	
    /** 
     * 电话
     * @return 
     */ 
    public String getTel() {
    	return tel;
    }
    
    /** 
     * 电话
     * @param 
     */ 
    public void setTel(String tel) {
    	this.tel = tel;
    }
    	
    /** 
     * 邮箱
     * @return 
     */ 
    public String getEmail() {
    	return email;
    }
    
    /** 
     * 邮箱
     * @param 
     */ 
    public void setEmail(String email) {
    	this.email = email;
    }
    	
    /** 
     * 状态
     * @return 
     */ 
    public Long getState() {
    	return state;
    }
    
    /** 
     * 状态
     * @param 
     */ 
    public void setState(Long state) {
    	this.state = state;
    }
    	
    /** 
     * 备注
     * @return 
     */ 
    public String getComments() {
    	return comments;
    }
    
    /** 
     * 备注
     * @param 
     */ 
    public void setComments(String comments) {
    	this.comments = comments;
    }

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
    
}