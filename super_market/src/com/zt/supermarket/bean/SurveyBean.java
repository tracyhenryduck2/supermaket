package com.zt.supermarket.bean;

import com.avatar.db.annotation.*;
import com.common.*;

/**
 * 调查
 * @author xin.chou
 *
 */
@Table(name="survey")
public class SurveyBean {

	/**
	 *  
	*/
	@Column(name="id",primaryKey=true,generatorType=GeneratorType.AUTO_INCREMENT)
	private Long id;

	/**
	 * 名称 
	*/
	@Column(name="name")
	private String name;

	/**
	 * 创建时间 
	*/
	@Column(name="create_time")
	private Long createTime;

	/**
	 * 题目数量 
	*/
	@Column(name="number")
	private Long number;
    
	/**
	 * 状态
	 */
	@Column(name="state")
	private Long state;
	
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
     * 名称
     * @return 
     */ 
    public String getName() {
    	return name;
    }
    
    /** 
     * 名称
     * @param 
     */ 
    public void setName(String name) {
    	this.name = name;
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
     * 题目数量
     * @return 
     */ 
    public Long getNumber() {
    	return number;
    }
    
    /** 
     * 题目数量
     * @param 
     */ 
    public void setNumber(Long number) {
    	this.number = number;
    }
    	
    public String getCreateTimeStr() {
    	return Common.TimeLongToStr(createTime);
    }
    
    public void setCreateTimeStr(String createTime) {
    	this.createTime = Common.TimeStrToLong(createTime);
    }

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}
}