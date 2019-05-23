package com.system.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.system.bean.SFunctionGroupBean;
                        
/**                     
 *                      
 * 功能组 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class SFunctionGroupDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, SFunctionGroupBean sfunctiongroupBean) {   
    	String sql ="select a.* from s_function_group a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(sfunctiongroupBean!=null) { 
    		if(sfunctiongroupBean.getId() != null) { 
    			objectList.add(sfunctiongroupBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(sfunctiongroupBean.getName() != null && sfunctiongroupBean.getName().trim().length()>0) { 
    			objectList.add(sfunctiongroupBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(sfunctiongroupBean.getSortId() != null) { 
    			objectList.add(sfunctiongroupBean.getSortId());
    			sqlWhere += " AND a.sort_id = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from s_function_group a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }                   
}                       
