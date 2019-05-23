package com.system.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.system.bean.SFunctionBean;
                        
/**                     
 *                      
 * 功能 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class SFunctionDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, SFunctionBean sfunctionBean) {   
    	String sql ="select a.*,b.name group_name from s_function a left join s_function_group b on a.group_id=b.id"; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(sfunctionBean!=null) { 
    		if(sfunctionBean.getId() != null) { 
    			objectList.add(sfunctionBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(sfunctionBean.getName() != null && sfunctionBean.getName().trim().length()>0) { 
    			objectList.add(sfunctionBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(sfunctionBean.getUrl() != null && sfunctionBean.getUrl().trim().length()>0) { 
    			objectList.add(sfunctionBean.getUrl());
    			sqlWhere += " AND a.url = ? ";
    		} 
    		if(sfunctionBean.getGroupId() != null) { 
    			objectList.add(sfunctionBean.getGroupId());
    			sqlWhere += " AND a.group_id = ? ";
    		} 
    		if(sfunctionBean.getSortId() != null) { 
    			objectList.add(sfunctionBean.getSortId());
    			sqlWhere += " AND a.sort_id = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from s_function a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }

	public List<Map<String, Object>> getList(Long role) {
		String sql="select a.*,b.name group_name from s_function a left join s_function_group b on a.group_id=b.id";
		if(role==1l)
		{
			sql="select a.*,b.name group_name from s_function a left join s_function_group b on a.group_id=b.id where b.id=2";
		}
		return j.queryForList(sql);
	}

	public List<Map<String, Object>> getGroupList() {
		String sql="select * from s_function_group";
		return j.queryForList(sql);
	}                   
}                       
