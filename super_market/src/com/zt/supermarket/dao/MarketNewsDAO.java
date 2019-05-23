package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.MarketNewsBean;
                        
/**                     
 *                      
 * 新闻 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class MarketNewsDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, MarketNewsBean marketnewsBean) {   
    	String sql ="select a.*,b.name market_name from market_news a left join market b on a.market_id=b.id"; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(marketnewsBean!=null) { 
    		if(marketnewsBean.getId() != null) { 
    			objectList.add(marketnewsBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(marketnewsBean.getMarketId() != null) { 
    			objectList.add(marketnewsBean.getMarketId());
    			sqlWhere += " AND a.market_id = ? ";
    		} 
    		if(marketnewsBean.getTitle() != null && marketnewsBean.getTitle().trim().length()>0) { 
    			objectList.add(marketnewsBean.getTitle());
    			sqlWhere += " AND a.title = ? ";
    		} 
    		if(marketnewsBean.getPicUrl() != null && marketnewsBean.getPicUrl().trim().length()>0) { 
    			objectList.add(marketnewsBean.getPicUrl());
    			sqlWhere += " AND a.pic_url = ? ";
    		} 
    		if(marketnewsBean.getDigest() != null && marketnewsBean.getDigest().trim().length()>0) { 
    			objectList.add(marketnewsBean.getDigest());
    			sqlWhere += " AND a.digest = ? ";
    		} 
    		if(marketnewsBean.getContent() != null && marketnewsBean.getContent().trim().length()>0) { 
    			objectList.add(marketnewsBean.getContent());
    			sqlWhere += " AND a.content = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from market_news a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }

	public List<Map<String, Object>> getList() {
		String sql="select * from market";
		return j.queryForList(sql);
	}  
	
	public List<Map<String, Object>> getListById(Long id) {
		String sql="select * from market where id="+id;
		return j.queryForList(sql);
	}  
}                       
