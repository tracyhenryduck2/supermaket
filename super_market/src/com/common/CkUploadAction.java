package com.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.avatar.gdk.util.DateUtils;

public class CkUploadAction  extends BaseActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File upload;// 这里的"fileName"一定要与表单中的文件域名相同
	private String uploadContentType;// 格式同上"fileName"+ContentType
	private String uploadFileName;// 格式同上"fileName"+FileName
	
	private String returnPath = "";
	public void upload() {
		try {
			String savePath =  request.getSession().getServletContext().getRealPath("/uploadImages/");
			File fileDir = new File(savePath);
	        if(!fileDir.exists()){
	        	fileDir.mkdirs();  
	        }  
        	String suffixName = uploadFileName.substring(uploadFileName.lastIndexOf(".")+1);
        	String name = DateUtils.getCurrentTime("yyyyMMddHHmmss")+"."+suffixName;
            FileOutputStream fos = new FileOutputStream(savePath+File.separator+name);  
            System.out.println(savePath+File.separator+name);
            returnPath  = "uploadImages/"+name;
            System.out.println(returnPath);
            FileInputStream fis=new FileInputStream(upload);  
            byte []buffers=new byte[1024];  
            int len=0;  
            while((len=fis.read(buffers))!=-1){  
                fos.write(buffers,0,len);  
            }  
            fos.close();
            fis.close();
            String callback = request.getParameter("CKEditorFuncNum"); 
            out = response.getWriter();
            out.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("+callback+",'../../"+returnPath+"')</script>");   
        	//out.println("<script type=\"text/javascript\">");  
            //out.println("window.parent.CKEDITOR.tools.callFunction("  + callback + ",'" + path+"/"+returnPath+"',''" + ");");
        	//out.println("window.parent.CKEDITOR.tools.callFunction("  + callback + ",'" + "../../"+returnPath+"',''" + ");");
           // out.println("</script>");  
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
