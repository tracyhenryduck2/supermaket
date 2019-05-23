package com.zt.supermarket.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.zt.supermarket.bean.SurveyBean;
import com.zt.supermarket.dao.SurveyDAO;
import com.common.Common;
import com.common.BaseActionSupport;
import com.common.Transaction;

/**
 * 调查
 * @author xin.chou
 *
 */
public class SurveyAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private SurveyDAO dao = new SurveyDAO(); 
    private SurveyBean surveyBean = new SurveyBean();    
    private final String tableDesc = "调查";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddSurvey() {
        if ("1".equals(oper)) {   
    	    surveyBean = dao.select(SurveyBean.class,surveyBean.getId());  
    	}    
    	return "toAddSurvey";    
    } 
 
    /**    
     * 新增
     */    
    public String addSurvey() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            surveyBean.setCreateTime(new Date().getTime()/1000);
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(surveyBean); 
            } else { 
                result = dao.insert(surveyBean); 
            }
            if (result) {  
                showMessage += "成功";  
                return reload_success; 
            } else {
                showMessage += "失败";  
                return error;   
            }  
        } catch (Exception e) {    
            showMessage = "数据异常，操作失败";   
            return error;  
        } 
    } 
 
    /**    
     * 编辑部分字段专用
     * @return
     */
    public String addTest2(){
        showMessage = "编辑2"+tableDesc;
        String[] param={
            "id","name","createTime","number"
        };
        boolean result=dao.update(surveyBean,param);
        if (result) { 
            showMessage += "成功";
            return reload_success;
        } else {
            showMessage += "失败"; 
           return error; 
        }
    }
    /**    
     * 删除操作 
     */    
    public String delSurvey() {  
    	try {
    		boolean result = dao.delete(SurveyBean.class,surveyBean.getId());  
    		if (result) {
    		    showMessage = "删除"+tableDesc+"成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除"+tableDesc+"失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    } 
 
 
    /**    
     * 删除操作 
     */    
    public String delSurveys() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(SurveyBean.class,ids);
    		if (result) {
    		    showMessage = "删除"+tableDesc+"成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除"+tableDesc+"失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    } 
    public String search() {
        return "search"; 
    }
 
    public String delQuestion(){
    	try {
    		final long questionId=Long.parseLong(request.getParameter("questionId"));
    		boolean result=new Transaction() {
				public void run() {
					dao.deleteQuestion(questionId);
				}
			}.start(); 
    			  
    		if (result) {
    		    showMessage = "删除成功"; //reload   
    		    return reload_success;  
    		} else {
    		    showMessage = "删除失败";  
    		    return error; 
    		}  
    	} catch (Exception e) {  
    		return exception; 
    	}    
    }
    
    /**    
     * 查询列表页面  
     * @return  
     */    
    public String list() {
    	page.execute(request, "ID", "desc");
    	List<Map<String, Object>> list = dao.getPageList(page, surveyBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public String toAddSurveyQuestion(){
    	List<Map<String,Object>> questionList=dao.getQuestionList(surveyBean.getId());
    	request.setAttribute("questionList", questionList);
    	return "toAddSurveyQuestion";
    }
    
    public String toNewQues(){
    	if ("1".equals(oper)) {   
    	    long questionId=Long.parseLong(request.getParameter("questionId")); 
    	    Map<String,Object> map=dao.getQuestion(questionId);
    	    request.setAttribute("content", map.get("content"));
    	    List<Map<String,Object>> answerList=dao.getAnswerList(questionId);
    	    request.setAttribute("answerList", answerList);
    	    request.setAttribute("questionId", questionId);
    	    request.setAttribute("type", map.get("type"));
    	} 
    	return "toNewQues";
    }
    
    public String newQues(){
    	try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            final String[] txt=request.getParameterValues("txt");
            final String content=request.getParameter("content");
            final long type = Long.parseLong(request.getParameter("type"));
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc; 
                final long questionId=Long.parseLong(request.getParameter("questionId"));
                result=new Transaction() {
					public void run() {
						if(type==0) {
							dao.insertAnswer(questionId,txt);
						}
						else {
							dao.updateQuestion(content, questionId);
						}
					}
				}.start();
            } else { 
                result=new Transaction() {
					public void run() {
						long qSortId=dao.getQuesSortId(surveyBean.getId());
						long questionId=dao.insertQuestion(content,surveyBean.getId(),qSortId,type);
						if(type==0) {
							dao.insertAnswer(questionId,txt);
						}
					}
				}.start();
            }
            if (result) {  
                showMessage += "成功";  
                return reload_success; 
            } else {
                showMessage += "失败";  
                return error;   
            }  
        } catch (Exception e) {    
            showMessage = "数据异常，操作失败";   
            return error;  
        } 
    }
    
    public SurveyBean getSurveyBean() { 
    	return surveyBean;    
    } 
 
    public void setSurveyBean(SurveyBean surveyBean) {   
    	this.surveyBean = surveyBean;
    } 
}
