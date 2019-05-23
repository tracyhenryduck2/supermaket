package com.zt.supermarket.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.system.bean.SUserBean;
import com.zt.supermarket.bean.ContentBean;
import com.zt.supermarket.dao.ContentDAO;
import com.common.Common;
import com.common.BaseActionSupport;
import com.common.SimpleImageUtils;

/**
 * 内容维护
 * @author xin.chou
 *
 */
public class ContentAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private ContentDAO dao = new ContentDAO(); 
    private ContentBean contentBean = new ContentBean();
    private File file;
    private String fileFileName;
    private final String tableDesc = "内容维护";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddContent() {
    	List<Map<String, Object>> typeList = dao.getList(user);
        request.setAttribute("typeList", typeList);
        if ("1".equals(oper)) {   
    	    contentBean = dao.select(ContentBean.class,contentBean.getId());  
    	}    
    	return "toAddContent";    
    } 
 
    /**    
     * 新增
     */    
    public String addContent() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            contentBean.setCreateTime(new Date().getTime()/1000);
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                String marketname = dao.GetMarketName(user.getMarketId());
                contentBean.setMarket(marketname);
                result = dao.update(contentBean); 
            } else {
                String marketname = dao.GetMarketName(user.getMarketId());
                contentBean.setMarket(marketname);
                result = dao.insert(contentBean); 
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
            "id","title","picUrl","digest","createTime","typeId"
        };
        boolean result=dao.update(contentBean,param);
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
    public String delContent() {  
    	try {
    		boolean result = dao.delete(ContentBean.class,contentBean.getId());  
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
    public String delContents() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(ContentBean.class,ids);
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
    	List<Map<String, Object>> list = dao.getPageList(page,user,contentBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public void importFile() throws Exception{
    	response.setContentType("text/html;charset=utf-8");
    	out=response.getWriter();
    	InputStream in=new FileInputStream(file);
    	String dateStr = new Date().getTime()+"";
    	String fileName=dateStr+fileFileName.substring(fileFileName.lastIndexOf("."));
    	String minFileName=dateStr+"_200"+fileFileName.substring(fileFileName.lastIndexOf("."));
    	FileOutputStream fs=new FileOutputStream(getUploadPath()+fileName);
    	int byteread=0;
    	int bytesum=0;
    	byte[] buffer=new byte[1024];
    	while((byteread=in.read(buffer))!=-1){
    		bytesum+=byteread;
    		fs.write(buffer, 0, byteread);
    	}
    	fs.close();
    	in.close();
    	String uploadPath = getUploadPath();
    	SimpleImageUtils.resizeImage(uploadPath+fileName, uploadPath+minFileName, 200, 200);
    	out.print(minFileName);
    	out.close();
    }
    
    public void importFile1() throws Exception{
    	response.setContentType("text/html;charset=utf-8");
    	out=response.getWriter();
    	InputStream in=new FileInputStream(file);

    	String fileName=fileFileName;
    	FileOutputStream fs=new FileOutputStream(getUploadPath()+fileName);
    	int byteread=0;
    	int bytesum=0;
    	byte[] buffer=new byte[1024];
    	while((byteread=in.read(buffer))!=-1){
    		bytesum+=byteread;
    		fs.write(buffer, 0, byteread);
    	}
    	fs.close();
    	in.close();
    	out.print(fileName);
    	out.close();
    }
    
    private String getUploadPath() {
    	File file=new File(request.getSession().getServletContext().getRealPath(""));
    	File tmpFile = new File(file.getParentFile().getAbsolutePath()+"/supermarket_images/news/");
    	if(!tmpFile.exists()) {
    		tmpFile.mkdirs();
    	}
		return file.getParentFile().getAbsolutePath()+"/supermarket_images/news/";
	}

	public void removeFile() throws IOException{
		out=response.getWriter();
    	String fileName=request.getParameter("fileName");
    	File file=new File(getUploadPath()+fileName);
    	boolean flag=true;
    	if(file.isFile()&&file.exists()){
    		flag=file.delete();
    	}
    	out.print(flag);
    	out.close();
    }
    
    public ContentBean getContentBean() { 
    	return contentBean;    
    } 
 
    public void setContentBean(ContentBean contentBean) {   
    	this.contentBean = contentBean;
    }

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	} 
}
