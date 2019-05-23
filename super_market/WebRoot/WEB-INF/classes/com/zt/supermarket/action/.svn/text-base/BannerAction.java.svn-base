package com.zt.supermarket.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.zt.supermarket.bean.BannerBean;
import com.zt.supermarket.dao.BannerDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 首页banner
 * @author xin.chou
 *
 */
public class BannerAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private BannerDAO dao = new BannerDAO(); 
    private BannerBean bannerBean = new BannerBean();    
    private final String tableDesc = "首页banner";
    private File file;
    private String fileFileName;
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddBanner() {
        if ("1".equals(oper)) {   
    	    bannerBean = dao.select(BannerBean.class,bannerBean.getId());  
    	}    
    	return "toAddBanner";    
    } 
 
    /**    
     * 新增
     */    
    public String addBanner() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(bannerBean); 
            } else { 
                result = dao.insert(bannerBean); 
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
            "id","filename","url","seqNo"
        };
        boolean result=dao.update(bannerBean,param);
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
    public String delBanner() {  
    	try {
    		boolean result = dao.delete(BannerBean.class,bannerBean.getId());  
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
    public String delBanners() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(BannerBean.class,ids);
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
    	List<Map<String, Object>> list = dao.getPageList(page, bannerBean);
    	request.setAttribute("list", list);   
    	return "list";    
    } 
 
    public void importFile() throws Exception{
    	response.setContentType("text/html;charset=utf-8");
    	out=response.getWriter();
    	InputStream in=new FileInputStream(file);
    	String fileName=new Date().getTime()+fileFileName.substring(fileFileName.lastIndexOf("."));
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
		String path = file.getParentFile().getAbsolutePath()+"/supermarket_images/banner/";
		File f = new File(path);
		if(!f.exists()) {
			f.mkdirs();
		}
		return path;
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
    
    public BannerBean getBannerBean() { 
    	return bannerBean;    
    } 
 
    public void setBannerBean(BannerBean bannerBean) {   
    	this.bannerBean = bannerBean;
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
