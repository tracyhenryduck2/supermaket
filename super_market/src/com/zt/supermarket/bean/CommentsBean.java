package com.zt.supermarket.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 留言
 * @author xin.chou
 *
 */
@Table(name="comments")
public class CommentsBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 会员  （没用到） 
	*/
	@Column(name="member_id")
	private Long memberId;

	/**
	 * 创建时间 
	*/
	@Column(name="create_time")
	private Long createTime;

	/**
	 * 内容 
	*/
	@Column(name="content")
	private String content;

	/**
	 * 权重 
	*/
	@Column(name="weight")
	private Long weight;
    
	/**
	 * 微信昵称 
	*/
	@Column(name="feedback_content")
	private String feedbackContent;

	
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
     * 会员  （没用到）
     * @return 
     */ 
    public Long getMemberId() {
    	return memberId;
    }
    
    /** 
     * 会员  （没用到）
     * @param 
     */ 
    public void setMemberId(Long memberId) {
    	this.memberId = memberId;
    }
    	
    /** 
     * 创建时间
     * @return 
     */ 
    public Long getCreateTime() {
    	return createTime;
    }
    
    /** 
     * 创建时间
     * @param 
     */ 
    public void setCreateTime(Long createTime) {
    	this.createTime = createTime;
    }
    	
    /** 
     * 内容
     * @return 
     */ 
    public String getContent() {
    	return content;
    }
    
    /** 
     * 内容
     * @param 
     */ 
    public void setContent(String content) {
    	this.content = content;
    }
    	
    /** 
     * 权重
     * @return 
     */ 
    public Long getWeight() {
    	return weight;
    }
    
    /** 
     * 权重
     * @param 
     */ 
    public void setWeight(Long weight) {
    	this.weight = weight;
    }
    	
    public String getCreateTimeStr() {
    	return Common.TimeLongToStr(createTime);
    }
    
    public void setCreateTimeStr(String createTime) {
    	this.createTime = Common.TimeStrToLong(createTime);
    }

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}


    
    
}