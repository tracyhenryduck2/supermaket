package com.zt.supermarket.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zt.supermarket.bean.MarketBean;
import com.zt.supermarket.bean.MarketVedioBean;
import com.zt.supermarket.dao.MarketVedioDAO;
import com.common.Common;
import com.common.BaseActionSupport;

/**
 * 视频
 * @author xin.chou
 *
 */
public class MarketVedioAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private MarketVedioDAO dao = new MarketVedioDAO(); 
    private MarketVedioBean marketVedioBean = new MarketVedioBean();  
    private MarketBean marketBean=new MarketBean();
    private final String tableDesc = "视频";
    private File file;
    private String fileFileName;
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddMarketVedio() {
        if ("1".equals(oper)) {   
    	    marketVedioBean = dao.select(MarketVedioBean.class,marketVedioBean.getId());  
    	}    
    	return "toAddMarketVedio";    
    } 
 
    /**    
     * 新增
     */    
    public String addMarketVedio() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(marketVedioBean); 
            } else { 
                result = dao.insert(marketVedioBean); 
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
            "id","marketId","name","picUrl","url","seqNo"
        };
        boolean result=dao.update(marketVedioBean,param);
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
    public String delMarketVedio() {  
    	try {
    		boolean result = dao.delete(MarketVedioBean.class,marketVedioBean.getId());  
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
    public String delMarketVedios() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(MarketVedioBean.class,ids);
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
    	marketVedioBean.setMarketId(marketBean.getId());
    	List<Map<String, Object>> list = dao.getPageList(page, marketVedioBean);
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
		String path = file.getParentFile().getAbsolutePath()+"/supermarket_images/market/";
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
    
    public MarketVedioBean getMarketVedioBean() { 
    	return marketVedioBean;    
    } 
 
    public void setMarketVedioBean(MarketVedioBean marketVedioBean) {   
    	this.marketVedioBean = marketVedioBean;
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

	public MarketBean getMarketBean() {
		return marketBean;
	}

	public void setMarketBean(MarketBean marketBean) {
		this.marketBean = marketBean;
	} 
}
