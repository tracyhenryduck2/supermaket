package com.zt.supermarket.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.common.BaseDAO;
import com.common.Page;
import com.zt.supermarket.bean.SurveyBean;
                        
/**                     
 *                      
 * 调查 <br>          
 *                      
 * @author   <br>   
 * @taskId   <br>   
 */                     
public class SurveyDAO extends BaseDAO { 
    /**                 
     * 分页查询         
     * @param page      
     * @param           
     * @return          
     */                 
    public List<Map<String,Object>> getPageList(Page page, SurveyBean surveyBean) {   
    	String sql ="select a.* from survey a "; 
    	List<Object> objectList = new ArrayList<Object>();
    	String sqlWhere = " where 1=1 ";  
    	if(surveyBean!=null) { 
    		if(surveyBean.getId() != null) { 
    			objectList.add(surveyBean.getId());
    			sqlWhere += " AND a.id = ? ";
    		} 
    		if(surveyBean.getName() != null && surveyBean.getName().trim().length()>0) { 
    			objectList.add(surveyBean.getName());
    			sqlWhere += " AND a.name = ? ";
    		} 
    		if(surveyBean.getCreateTime() != null) { 
    			objectList.add(surveyBean.getCreateTime());
    			sqlWhere += " AND a.create_time = ? ";
    		} 
    		if(surveyBean.getNumber() != null) { 
    			objectList.add(surveyBean.getNumber());
    			sqlWhere += " AND a.number = ? ";
    		} 
    	}                 
    	sql = sql + sqlWhere; 
    	Object[] pram = objectList.toArray(); 
    	if(page.getSortname()!=null && page.getSortorder()!=null) {   
    		sql += " order by "+page.getSortname()+" " +page.getSortorder(); 
    	}                 
    	page.setTotalRows(j.queryForInteger("select count(*) from survey a "+sqlWhere, pram));
    	List<Map<String,Object>> list=j.queryForPageList(sql, page.getPageNo(),page.getPageSize(),pram);  
    	return list;      
    }

	public List<Map<String, Object>> getQuestionList(Long id) {
		String sql="select * from question where survey_id="+id+" order by sort_id asc";
		List<Map<String,Object>> list=j.queryForList(sql);
		for(Map<String,Object> map:list){
			long questionId=Long.parseLong(map.get("id")+"");
			sql="select * from answer where question_id="+questionId+" order by sort_id asc";
			List<Map<String,Object>> answerList=j.queryForList(sql);
			map.put("answerList", answerList);
		}
		return list;
	}

	public long getQuesSortId(Long id) {
		String sql="select max(sort_id) maxId from question where survey_id="+id;
		Long maxId=j.queryForLong(sql);
		return maxId==null?1:((long)(maxId)+1);
	}

	public long insertQuestion(String content, Long id, long sortId, long type) {
		String sql="insert into question (survey_id,sort_id,content,type) values (?,?,?,?)";
		Object[] param={id,sortId,content,type};
		return j.saveForGeneratedKey(sql, param);
	}
	
	public void updateQuestion(String content, Long id) {
		String[] sql=new String[2];
		sql[0]="delete from answer where question_id="+id;
		sql[1]="update question set type=1, content='"+content+"' where id="+id;
		j.batchUpdate(sql);
	}

	public void insertAnswer(long questionId, String[] txt) {
		String _sql="delete from answer where question_id="+questionId;
		j.execute(_sql);
		_sql="update question set type=0 where id="+questionId;
		j.execute(_sql);
		String[] sql=new String[txt.length];
		for(int i=0;i<txt.length;i++){
			sql[i]="insert into answer (question_id,content,sort_id) values ("+questionId+",'"+txt[i]+"',"+(i+1)+")";
		}
		j.batchUpdate(sql);
	}

	public void deleteQuestion(long questionId) {
		String[] sql=new String[3];
		sql[0]="update question set sort_id=sort_id-1 where id>"+questionId;
		sql[1]="delete from answer where question_id="+questionId;
		sql[2]="delete from question where id="+questionId;
		j.batchUpdate(sql);
	}

	public Map<String, Object> getQuestion(long questionId) {
		String sql="select * from question where id="+questionId;
		return j.queryForMap(sql);
	}

	public List<Map<String, Object>> getAnswerList(long questionId) {
		String sql="select * from answer where question_id="+questionId+" order by sort_id asc";
		return j.queryForList(sql);
	}                   
}                       
