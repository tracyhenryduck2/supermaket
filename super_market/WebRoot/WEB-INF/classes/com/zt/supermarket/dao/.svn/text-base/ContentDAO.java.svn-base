package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.system.bean.SUserBean;
import com.zt.supermarket.bean.ContentBean;
                        
/**                     
 *                      
 * 内容维护 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class ContentDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page,SUserBean userbean, ContentBean contentBean) {
    	String usertable = "content";
    	if(userbean!=null&&userbean.getRole()==1)
    	{
    		usertable = "(select * from content where content.type_id>=4 and content.type_id<=5)";
    	}
    	String sql ="select a.*,b.name type_name from "+usertable+" a left join type b on a.type_id=b.id"; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(contentBean!=null) { 
    		if(contentBean.getId() != null) { 
    			objectList.add(contentBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(contentBean.getTitle() != null && contentBean.getTitle().trim().length()>0) { 
    			objectList.add(contentBean.getTitle());
    			sqlWhere += " AND a.title = ? ";
    		} 
    		if(contentBean.getPicUrl() != null && contentBean.getPicUrl().trim().length()>0) { 
    			objectList.add(contentBean.getPicUrl());
    			sqlWhere += " AND a.pic_url = ? ";
    		} 
    		if(contentBean.getDigest() != null && contentBean.getDigest().trim().length()>0) { 
    			objectList.add(contentBean.getDigest());
    			sqlWhere += " AND a.digest = ? ";
    		} 
    		if(contentBean.getCreateTime() != null) { 
    			objectList.add(contentBean.getCreateTime());
    			sqlWhere += " AND a.create_time = ? ";
    		} 
    		if(contentBean.getTypeId() != null) { 
    			objectList.add(contentBean.getTypeId());
    			sqlWhere += " AND a.type_id = ? ";
    		}
    		if(contentBean.getMarket() != null&& contentBean.getMarket().trim().length()>0) { 
    			objectList.add(contentBean.getMarket());
    			sqlWhere += " AND a.market = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from "+usertable+" a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }
    
//	public boolean insertContent(ContentBean contentbean,String marketname){
//		
//	    String sql="insert into content (title,pic_url,digest,create_time,type_id,content,detial_pic_url,market) values ("
//	    	+contentbean.getTitle()+","
//	    	+contentbean.getPicUrl()+","
//	    	+contentbean.getDigest()+","
//	    	+contentbean.getCreateTime()+","
//	    	+contentbean.getTypeId()+","
//	    	+contentbean.getDetialPicUrl()+","
//	    	+contentbean.getContent()+",'"
//	    	+marketname
//	    	+"')";
//		
//		return j.execute(sql);
//	}
//	
//	public boolean updateContent(ContentBean contentbean,String marketname){
//		
//	    String sqlStr = "UPDATE content SET \r\n"
//				+ "title=?,pic_url=?,digest=?,create_time=?,type_id=? \r\n"
//				+ ",content=?,detial_pic_url=?,market=? \r\n"
//				+ " WHERE id=? ";
//	
//		Object[] params = { contentbean.getTitle(),
//				contentbean.getPicUrl(), contentbean.getDigest(),
//				contentbean.getCreateTime(), contentbean.getTypeId(),
//				contentbean.getContent(), contentbean.getDetialPicUrl(),
//				marketname,
//				contentbean.getId() };
//		return j.execute(sqlStr, params);
//	}

	public List<Map<String, Object>> getList(SUserBean userbean) {
		String condition="";
		if(userbean!=null&&userbean.getRole()==1)
		{
			condition = " where type.id>=4 and type.id<=5";
		}
		String sql="select * from type"+condition;
		return j.queryForList(sql);
	}
	
	public String GetMarketName(Long id){
		String sql="select market.name from market where id="+id;
		return (String)j.queryForObject(sql);
	}
}                       
