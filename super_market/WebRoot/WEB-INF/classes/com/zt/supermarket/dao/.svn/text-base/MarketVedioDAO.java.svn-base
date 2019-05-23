package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.MarketVedioBean;
                        
/**                     
 *                      
 * 视频 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class MarketVedioDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, MarketVedioBean marketvedioBean) {   
    	String sql ="select a.*,b.name market_name from market_vedio a left join market b on a.market_id=b.id"; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(marketvedioBean!=null) { 
    		if(marketvedioBean.getId() != null) { 
    			objectList.add(marketvedioBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(marketvedioBean.getMarketId() != null) { 
    			objectList.add(marketvedioBean.getMarketId());
    			sqlWhere += " AND a.market_id = ? ";
    		} 
    		if(marketvedioBean.getName() != null && marketvedioBean.getName().trim().length()>0) { 
    			objectList.add(marketvedioBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(marketvedioBean.getPicUrl() != null && marketvedioBean.getPicUrl().trim().length()>0) { 
    			objectList.add(marketvedioBean.getPicUrl());
    			sqlWhere += " AND a.pic_url = ? ";
    		} 
    		if(marketvedioBean.getUrl() != null && marketvedioBean.getUrl().trim().length()>0) { 
    			objectList.add(marketvedioBean.getUrl());
    			sqlWhere += " AND a.url = ? ";
    		} 
    		if(marketvedioBean.getSeqNo() != null) { 
    			objectList.add(marketvedioBean.getSeqNo());
    			sqlWhere += " AND a.seq_no = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from market_vedio a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
