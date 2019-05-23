package com.zt.supermarket.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.zt.supermarket.bean.CommentsBean;
import com.zt.supermarket.dao.CommentsDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 留言
 * @author xin.chou
 *
 */
public class CommentsAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private CommentsDAO dao = new CommentsDAO(); 
    private CommentsBean commentsBean = new CommentsBean();    
    private final String tableDesc = "留言";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddComments() {
        if ("1".equals(oper)) {   
    	    commentsBean = dao.select(CommentsBean.class,commentsBean.getId());  
    	}    
    	return "toAddComments";    
    } 
 
    /**    
     * 新增
     */    
    public String addComments() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            commentsBean.setCreateTime(new Date().getTime()/1000);
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(commentsBean); 
            } else { 
                result = dao.insert(commentsBean); 
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
            "id","memberId","createTime","content","weight"
        };
        boolean result=dao.update(commentsBean,param);
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
    public String delComments() {  
    	try {
    		boolean result = dao.delete(CommentsBean.class,commentsBean.getId());  
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
    public String delCommentss() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(CommentsBean.class,ids);
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
 
    /**    
     * 查询列表页面  
     * @return  
     */    
    public String list() {
    	page.execute(request, "ID", "desc");
    	List<Map<String, Object>> list = dao.getPageList(page, commentsBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public CommentsBean getCommentsBean() { 
    	return commentsBean;    
    } 
 
    public void setCommentsBean(CommentsBean commentsBean) {   
    	this.commentsBean = commentsBean;
    } 
}
