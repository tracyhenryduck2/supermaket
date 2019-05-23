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
import com.zt.supermarket.dao.MarketDAO;
import com.common.Common;
import com.common.BaseActionSupport;
import com.common.SimpleImageUtils;

/**
 * 超市
 * @author xin.chou
 *
 */
public class MarketAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private MarketDAO dao = new MarketDAO(); 
    private MarketBean marketBean = new MarketBean();    
    private final String tableDesc = "超市";
    private File file;
    private String fileFileName;
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddMarket() {
        if ("1".equals(oper)) {   
    	    marketBean = dao.select(MarketBean.class,marketBean.getId());  
    	}    
    	return "toAddMarket";    
    } 
 
    public String marketPicList() {
    	List<Map<String,Object>> picList=dao.getPicList(marketBean.getId());
    	request.setAttribute("picList", picList);
    	return "marketPicList";    
    } 
    
    public String marketVedioList(){
    	List<Map<String,Object>> vedioList=dao.getVedio(marketBean.getId());
    	request.setAttribute("vedioList", vedioList);
    	return "marketVedioLost";
    }
    
    
    /**    
     * 新增
     */    
    public String addMarket() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(marketBean); 
            } else { 
                result = dao.insert(marketBean); 
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
            "id","name","rank","headPic","info"
        };
        boolean result=dao.update(marketBean,param);
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
    public String delMarket() {  
    	try {
    		boolean result = dao.delete(MarketBean.class,marketBean.getId());  
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
    public String delMarkets() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(MarketBean.class,ids);
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
    	if(user.getRole()==1){
    		marketBean.setId(user.getMarketId());
    	}
    	List<Map<String, Object>> list = dao.getPageList(page, marketBean);
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
    
    private String getUploadPath() {
    	File file=new File(request.getSession().getServletContext().getRealPath(""));
    	File tmpFile = new File(file.getParentFile().getAbsolutePath()+"/supermarket_images/market/");
    	if(!tmpFile.exists()) {
    		tmpFile.mkdirs();
    	}
		return file.getParentFile().getAbsolutePath()+"/supermarket_images/market/";
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
    
    public MarketBean getMarketBean() { 
    	return marketBean;    
    } 
 
    public void setMarketBean(MarketBean marketBean) {   
    	this.marketBean = marketBean;
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
