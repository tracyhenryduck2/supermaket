package com.zt.supermarket.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zt.supermarket.bean.MarketNewsBean;
import com.zt.supermarket.dao.MarketNewsDAO;
import com.common.Common;
import com.common.BaseActionSupport;
import com.common.SimpleImageUtils;

/**
 * 新闻
 * @author xin.chou
 *
 */
public class MarketNewsAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private MarketNewsDAO dao = new MarketNewsDAO(); 
    private MarketNewsBean marketNewsBean = new MarketNewsBean(); 
    private File file;
    private String fileFileName;
    private final String tableDesc = "新闻";
    /**    
     * 转向添加页面  
     * @return  
     */    
    public String toAddMarketNews() {
    	List<Map<String, Object>> list=null; 
    	if(user.getRole()==0){
    		list=dao.getList();
    	}
    	else{
    		list=dao.getListById(user.getMarketId());
    	}
    	List<Map<String,Object>> list2= new ArrayList<Map<String,Object>>(); 
    	Map<String,Object> map =new HashMap<String,Object>();
    	map.put("id", 0);
    	map.put("name", "不显示");
    	list2.add(map);
    	Map<String,Object> map2 =new HashMap<String,Object>();
    	map2.put("id", 1);
    	map2.put("name", "显示");
    	list2.add(map2);
        request.setAttribute("list", list);
        request.setAttribute("list2", list2);
        if ("1".equals(oper)) {   
    	    marketNewsBean = dao.select(MarketNewsBean.class,marketNewsBean.getId());  
    	}    
    	return "toAddMarketNews";    
    } 
 
    /**    
     * 新增
     */    
    public String addMarketNews() {  
        try {   
            showMessage = "新增"+tableDesc; 
            boolean result = true;  
            marketNewsBean.setCreateTime(new Date().getTime()/1000);
            if ("1".equals(oper)) {    
                showMessage = "编辑"+tableDesc;  
                result = dao.update(marketNewsBean); 
            } else { 
                result = dao.insert(marketNewsBean); 
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
            "id","marketId","title","picUrl","digest","content"
        };
        boolean result=dao.update(marketNewsBean,param);
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
    public String delMarketNews() {  
    	try {
    		boolean result = dao.delete(MarketNewsBean.class,marketNewsBean.getId());  
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
    public String delMarketNewss() { 
    	try {
    		String[] idArr = request.getParameterValues("idArr");   
    		String ids = Common.array2String(idArr);   
    		boolean result = dao.deletes(MarketNewsBean.class,ids);
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
    	if(user.getRole()==1)
    	{
    		marketNewsBean.setMarketId(user.getMarketId());
    	}
    	List<Map<String, Object>> list = dao.getPageList(page, marketNewsBean);
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
    
    
    public MarketNewsBean getMarketNewsBean() { 
    	return marketNewsBean;    
    } 
 
    public void setMarketNewsBean(MarketNewsBean marketNewsBean) {   
    	this.marketNewsBean = marketNewsBean;
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
