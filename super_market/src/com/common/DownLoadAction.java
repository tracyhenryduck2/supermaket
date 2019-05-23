package com.common;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DownLoadAction extends BaseActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uploadPath1;
	public void downLoad(){
    	String fileRealName=request.getParameter("fileRealName");
    	String fileName=request.getParameter("fileName");
    	try {
    	response.setContentType("text/plain; charset=utf-8");// 一下两行关键的设置
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("gb2312"), "ISO8859-1" ));
			BufferedOutputStream buff = new BufferedOutputStream(response.getOutputStream());
			FileInputStream fis = new FileInputStream(getUploadPath1()+File.separator+fileRealName);
			byte[] buffers = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffers)) != -1) {
				buff.write(buffers, 0, len);
			}
			buff.flush();
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	private String getUploadPath1(){
    	if(uploadPath1==null){
    		File file=new File(request.getSession().getServletContext().getRealPath(""));
    		uploadPath1=file.getParentFile().getAbsolutePath()+"/upload/";
    	}
    	return uploadPath1;
    }
}
