package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.CommentsBean;
                        
/**                     
 *                      
 * 留言 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class CommentsDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, CommentsBean commentsBean) {   
    	String sql ="select a.* from comments a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(commentsBean!=null) { 
    		if(commentsBean.getId() != null) { 
    			objectList.add(commentsBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(commentsBean.getMemberId() != null) { 
    			objectList.add(commentsBean.getMemberId());
    			sqlWhere += " AND a.member_id = ? ";
    		} 
    		if(commentsBean.getCreateTime() != null) { 
    			objectList.add(commentsBean.getCreateTime());
    			sqlWhere += " AND a.create_time = ? ";
    		} 
    		if(commentsBean.getContent() != null && commentsBean.getContent().trim().length()>0) { 
    			objectList.add(commentsBean.getContent());
    			sqlWhere += " AND a.content = ? ";
    		} 
    		if(commentsBean.getWeight() != null) { 
    			objectList.add(commentsBean.getWeight());
    			sqlWhere += " AND a.weight = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from comments a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
