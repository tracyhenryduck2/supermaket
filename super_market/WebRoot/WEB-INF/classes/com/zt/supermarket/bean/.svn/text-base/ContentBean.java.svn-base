package com.zt.supermarket.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 内容维护
 * @author xin.chou
 *
 */
@Table(name="content")
public class ContentBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 标题 
	*/
	@Column(name="title")
	private String title;

	/**
	 * 图片地址 
	*/
	@Column(name="pic_url")
	private String picUrl;

	/**
	 * 摘要 
	*/
	@Column(name="digest")
	private String digest;

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
	 * 类型 
	*/
	@Column(name="type_id")
	private Long typeId;
	
	/**
	 * 附件地址 
	*/
	@Column(name="file_url")
	private String fileUrl;
    	
	
	@Column(name="market")
	private String market;
	


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
     * 标题
     * @return 
     */ 
    public String getTitle() {
    	return title;
    }
    
    /** 
     * 标题
     * @param 
     */ 
    public void setTitle(String title) {
    	this.title = title;
    }
    	
    /** 
     * 图片地址
     * @return 
     */ 
    public String getPicUrl() {
    	return picUrl;
    }
    
    /** 
     * 图片地址
     * @param 
     */ 
    public void setPicUrl(String picUrl) {
    	this.picUrl = picUrl;
    }
    	
    /** 
     * 摘要
     * @return 
     */ 
    public String getDigest() {
    	return digest;
    }
    
    /** 
     * 摘要
     * @param 
     */ 
    public void setDigest(String digest) {
    	this.digest = digest;
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
     * 类型
     * @return 
     */ 
    public Long getTypeId() {
    	return typeId;
    }
    
    /** 
     * 类型
     * @param 
     */ 
    public void setTypeId(Long typeId) {
    	this.typeId = typeId;
    }
    	
    public String getCreateTimeStr() {
    	return Common.TimeLongToStr(createTime);
    }
    
    public void setCreateTimeStr(String createTime) {
    	this.createTime = Common.TimeStrToLong(createTime);
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
    public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}
	
}