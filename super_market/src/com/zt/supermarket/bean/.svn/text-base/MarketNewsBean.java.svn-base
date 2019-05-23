package com.zt.supermarket.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 新闻
 * @author xin.chou
 *
 */
@Table(name="market_news")
public class MarketNewsBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * marketId 
	*/
	@Column(name="market_id")
	private Long marketId;

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
	 * 附件地址 
	*/
	@Column(name="file_url")
	private String fileUrl;

	/**
	 * 摘要 
	*/
	@Column(name="digest")
	private String digest;

	/**
	 * 内容 
	*/
	@Column(name="content")
	private String content;
	/**
	 * 是否在首页显示喇叭
	*/
	@Column(name="show_index")
	private Long showIndex;
    
	
	/**
	 * 创建时间
	 */
	@Column(name="create_time")
	private Long createTime;
    public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	 public String getCreateTimeStr() {
	    	return Common.TimeLongToStr(createTime);
	    }
	    
	    public void setCreateTimeStr(String createTime) {
	    	this.createTime = Common.TimeStrToLong(createTime);
	    }

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
     * marketId
     * @return 
     */ 
    public Long getMarketId() {
    	return marketId;
    }
    
    /** 
     * marketId
     * @param 
     */ 
    public void setMarketId(Long marketId) {
    	this.marketId = marketId;
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

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Long getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(Long showIndex) {
		this.showIndex = showIndex;
	}
    
	
    
}