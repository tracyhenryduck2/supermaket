package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.MarketBean;
                        
/**                     
 *                      
 * 超市 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class MarketDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, MarketBean marketBean) {   
    	String sql ="select a.* from market a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(marketBean!=null) { 
    		if(marketBean.getId() != null) { 
    			objectList.add(marketBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(marketBean.getName() != null && marketBean.getName().trim().length()>0) { 
    			objectList.add(marketBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(marketBean.getRank() != null) { 
    			objectList.add(marketBean.getRank());
    			sqlWhere += " AND a.rank = ? ";
    		} 
    		if(marketBean.getHeadPic() != null) { 
    			objectList.add(marketBean.getHeadPic());
    			sqlWhere += " AND a.head_pic = ? ";
    		} 
    		if(marketBean.getInfo() != null && marketBean.getInfo().trim().length()>0) { 
    			objectList.add(marketBean.getInfo());
    			sqlWhere += " AND a.info = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from market a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }

	public List<Map<String, Object>> getPicList(Long id) {
		String sql="select * from market_pic where market_id="+id;
		return j.queryForList(sql);
	}

	public List<Map<String, Object>> getVedio(Long id) {
		String sql="select * from market_vedio where market_id="+id;
		return j.queryForList(sql);
	}                   
}                       
