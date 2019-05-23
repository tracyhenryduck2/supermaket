package com.zt.supermarket.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 环境图片
 * @author xin.chou
 *
 */
@Table(name="market_pic")
public class MarketPicBean {

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
	 * 名称 
	*/
	@Column(name="filename")
	private String filename;

	/**
	 * 图片地址 
	*/
	@Column(name="pic_url")
	private String picUrl;

	/**
	 * 链接地址 
	*/
	@Column(name="url")
	private String url;

	/**
	 * 排序 
	*/
	@Column(name="seq_no")
	private Long seqNo;
    	
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
     * 名称
     * @return 
     */ 
    public String getFilename() {
    	return filename;
    }
    
    /** 
     * 名称
     * @param 
     */ 
    public void setFilename(String filename) {
    	this.filename = filename;
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
     * 链接地址
     * @return 
     */ 
    public String getUrl() {
    	return url;
    }
    
    /** 
     * 链接地址
     * @param 
     */ 
    public void setUrl(String url) {
    	this.url = url;
    }
    	
    /** 
     * 排序
     * @return 
     */ 
    public Long getSeqNo() {
    	return seqNo;
    }
    
    /** 
     * 排序
     * @param 
     */ 
    public void setSeqNo(Long seqNo) {
    	this.seqNo = seqNo;
    }
}