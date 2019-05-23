package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.BannerBean;
                        
/**                     
 *                      
 * 首页banner <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class BannerDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, BannerBean bannerBean) {   
    	String sql ="select a.* from banner a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(bannerBean!=null) { 
    		if(bannerBean.getId() != null) { 
    			objectList.add(bannerBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(bannerBean.getFilename() != null && bannerBean.getFilename().trim().length()>0) { 
    			objectList.add(bannerBean.getFilename());
    			sqlWhere += " AND a.filename = ? ";
    		} 
    		if(bannerBean.getUrl() != null && bannerBean.getUrl().trim().length()>0) { 
    			objectList.add(bannerBean.getUrl());
    			sqlWhere += " AND a.url = ? ";
    		} 
    		if(bannerBean.getSeqNo() != null) { 
    			objectList.add(bannerBean.getSeqNo());
    			sqlWhere += " AND a.seq_no = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from banner a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
