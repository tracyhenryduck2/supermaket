package com.system.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.system.bean.SUserBean;
                        
/**                     
 *                      
 * 系统用户表 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class SUserDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, SUserBean suserBean) {   
    	String sql ="select a.* from s_user a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(suserBean!=null) { 
    		if(suserBean.getId() != null) { 
    			objectList.add(suserBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(suserBean.getUsername() != null && suserBean.getUsername().trim().length()>0) { 
    			objectList.add(suserBean.getUsername());
    			sqlWhere += " AND a.username = ? ";
    		} 
    		if(suserBean.getPassword() != null && suserBean.getPassword().trim().length()>0) { 
    			objectList.add(suserBean.getPassword());
    			sqlWhere += " AND a.password = ? ";
    		} 
    		if(suserBean.getNickname() != null && suserBean.getNickname().trim().length()>0) { 
    			objectList.add(suserBean.getNickname());
    			sqlWhere += " AND a.nickname = ? ";
    		} 
    		if(suserBean.getTel() != null && suserBean.getTel().trim().length()>0) { 
    			objectList.add(suserBean.getTel());
    			sqlWhere += " AND a.tel = ? ";
    		} 
    		if(suserBean.getEmail() != null && suserBean.getEmail().trim().length()>0) { 
    			objectList.add(suserBean.getEmail());
    			sqlWhere += " AND a.email = ? ";
    		} 
    		if(suserBean.getState() != null) { 
    			objectList.add(suserBean.getState());
    			sqlWhere += " AND a.state = ? ";
    		} 
    		if(suserBean.getComments() != null && suserBean.getComments().trim().length()>0) { 
    			objectList.add(suserBean.getComments());
    			sqlWhere += " AND a.comments = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from s_user a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }

	public boolean checkPwd(SUserBean sUserBean) {
		String sql = "select count(*) from S_USER where password=? and id=? ";
		Object[] params = {sUserBean.getPassword(), sUserBean.getId()};
		return j.queryForInteger(sql, params)>0;
	}

	public void updateSUserPWD(SUserBean sUserBean) {
		Object[] params = {sUserBean.getPassword()};
		String sql = " update S_USER set password=? where id=" +sUserBean.getId();
		j.execute(sql, params);
	}                   
}                       
