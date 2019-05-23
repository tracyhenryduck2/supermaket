package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.MarketPicBean;
                        
/**                     
 *                      
 * 环境图片 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class MarketPicDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, MarketPicBean marketpicBean) {   
    	String sql ="select a.*,b.name market_name from market_pic a left join market b on a.market_id=b.id"; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(marketpicBean!=null) { 
    		if(marketpicBean.getId() != null) { 
    			objectList.add(marketpicBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(marketpicBean.getMarketId() != null) { 
    			objectList.add(marketpicBean.getMarketId());
    			sqlWhere += " AND a.market_id = ? ";
    		} 
    		if(marketpicBean.getFilename() != null && marketpicBean.getFilename().trim().length()>0) { 
    			objectList.add(marketpicBean.getFilename());
    			sqlWhere += " AND a.filename = ? ";
    		} 
    		if(marketpicBean.getPicUrl() != null && marketpicBean.getPicUrl().trim().length()>0) { 
    			objectList.add(marketpicBean.getPicUrl());
    			sqlWhere += " AND a.pic_url = ? ";
    		} 
    		if(marketpicBean.getUrl() != null && marketpicBean.getUrl().trim().length()>0) { 
    			objectList.add(marketpicBean.getUrl());
    			sqlWhere += " AND a.url = ? ";
    		} 
    		if(marketpicBean.getSeqNo() != null) { 
    			objectList.add(marketpicBean.getSeqNo());
    			sqlWhere += " AND a.seq_no = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from market_pic a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
