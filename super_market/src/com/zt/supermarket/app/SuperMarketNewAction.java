package com.zt.supermarket.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import com.common.BaseActionSupport;
import com.common.Transaction;
import com.common.UploadImg;
import com.zt.supermarket.bean.UserBean;

public class SuperMarketNewAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SuperMarketNewDao superNewDao = new SuperMarketNewDao();
	private UserBean userbean = new UserBean();
	private File file;
	private String fileFileName;
	
	
	
	/**
	 * 上传图片
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!upload.action
	 */
	public void upload(){
		String dir="market_avatar";
		UploadImg upload=new UploadImg(file,fileFileName,dir,request,response);
		try {
			upload.importFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * 用户注册
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!register.action
	 * @return
	 */

	public void register(){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String avatar=request.getParameter("avatar");
		String nickname=request.getParameter("nickname");

        userbean.setUsername(username);
        userbean.setPassword(password);
        userbean.setAvatar(avatar);
        userbean.setNickname(nickname);
        userbean.setType(1l);
         
        int reus = 0;
         if(superNewDao.getUserbeanCount(username)>0){
        	 reus=2;
         }
         else{
     		Long result=superNewDao.save(userbean);
     		if(result>0){
     			boolean addPoint = superNewDao.addPoint(result);
     			boolean addPoint_log=superNewDao.addPointLog(result);
     			if(addPoint)
     				reus=1;
     		}
     		else{
     			reus=0;
     		}
         }

       	Map<String,Object> map=new HashMap<String,Object>();
       	map.put("result", reus);
		outPrintJSONObject(map);
	}
	
	
	/**
	 * 用户登录获取基本信息
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!login.action?username=XX&password=XX
	 * @return
	 */
	public void login(){
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println("1");
		Map<String,Object> map=superNewDao.login(username,password);
		System.out.println(map);

		outPrintJSONObject(map);
	}
	

	
	
	/**
	 * 用户微信登录获取基本信息
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!weixlogin.action?openid=XX&avatar=XX&nickname=XX
	 * @return
	 */
	public void weixlogin(){
		String openid=request.getParameter("openid");
		String avatar=request.getParameter("avatar");
		String nickname = request.getParameter("nickname");
		
		Map<String,Object> map=superNewDao.weixlogin(openid,avatar,nickname);
		outPrintJSONObject(map);
	}
	
	
	
	/**
	 * 获取收藏列表
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!collectionlist.action?uid=XX
	 * @return
	 */
	public void collectionlist(){
		String uid=request.getParameter("uid");
		
		List<Map<String,Object>> list=superNewDao.getCollectionList(uid);
		outPrintJSON(list);
	}
	
	
	/**
	 * 新增收藏
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!addcollection.action?uid=XX&content_id=xx&type=xx;
	 * @return
	 */
	public void addcollection(){
		String uid=request.getParameter("uid");
		String content_id =request.getParameter("content_id");
		Long type=Long.parseLong(request.getParameter("type"));
		
//		boolean flag =superNewDao.addCollection(uid, content_id,type);
//		int result = 0;
//		Map<String,Object> map= new HashMap<String,Object>();
//		if(flag) result=1;
//		map.put("result", result);
//		outPrintJSONObject(map);
		
		boolean flag = superNewDao.collectionIsExist(uid, content_id);
		int result =0;
		Map<String,Object> map = new HashMap<String,Object>();
		if(flag){
			boolean update=superNewDao.updateCollection(uid, content_id);
			if(update){
				result = 2;
			}
			map.put("result", result);
		}else{
			Long init_point=superNewDao.initpoint(uid);
			
			boolean add = superNewDao.addCollection(uid, content_id, type,init_point);
			if(add){
				result = 1;
			}
			map.put("result", result);
		}
		outPrintJSONObject(map);
	}
	
	
	/**
	 * 取消收藏
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!deletecollection.action?uid=XX&content_id=xx&type=xx;
	 * @return
	 */
	public void deletecollection(){
		String uid=request.getParameter("uid");
		String content_id =request.getParameter("content_id");
		Long type=Long.parseLong(request.getParameter("type"));
		boolean flag =superNewDao.deleteCollection(uid, content_id,type);
		int result = 0;
		Map<String,Object> map= new HashMap<String,Object>();
		if(flag) result=1;
		map.put("result", result);
		outPrintJSONObject(map);
	}
	
	
	/**
	 * 用户留言
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!suggestion.action?uid=XX&content=xx;
	 * @return
	 */
	public void suggestion(){
		String uid=request.getParameter("uid");
		String content=request.getParameter("content");
		boolean flag =superNewDao.insertSuggestion(uid, content,new Date().getTime()/1000);
		int result = 0;
		Map<String,Object> map= new HashMap<String,Object>();
		if(flag) result=1;
		map.put("result", result);
		outPrintJSONObject(map);
	}
	
	
	
	/**
	 * 获取留言列表
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!suggestionlist.action?uid=XX
	 * @return
	 */
	public void suggestionlist(){
		String uid=request.getParameter("uid");

		List<Map<String,Object>> list= superNewDao.getLiuyanList(uid);

		outPrintJSON(list);
	}
	
	
	/**
	 * 上传用户头像
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!submitAvatar.action?uid=XX
	 * @return
	 * @throws Exception 
	 */
	public void submitAvatar() throws Exception{
		String uId=request.getParameter("uid");
		String fileName=null;		
		if(file!=null){
			fileName="avatar"+new Date().getTime()+".jpg";
			importFile(file,fileName);
		}
		
		Map<String,Object> map=superNewDao.modavatar(uId,fileName);
		outPrintJSONObject(map);
	}
	
	/**
	 * 用户修改密码
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!modPassword.action?uid=XX&newcode=XX&code=XX
	 * @return
	 */
	public void modPassword(){
		String uId=request.getParameter("uid");
		String newpassword=request.getParameter("newcode");
		String password = request.getParameter("code");
		Map<String,Object> map=superNewDao.modPassword(uId,password,newpassword);
		outPrintJSONObject(map);
	}
	
	
	/**
	 * 用户修改昵称
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!modNickname.action?uid=XX&nickname=XX
	 * @return
	 */
	public void modNickname(){
		String uId=request.getParameter("uid");
		String nickname=request.getParameter("nickname");
		Map<String,Object> map=superNewDao.modNickname(uId,nickname);
		outPrintJSONObject(map);
	}
	
	/**
	 * 获取首页喇叭内容
	 * http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!hotlist.action
	 * @return
	 */
	public void hotlist(){

		List<Map<String,Object>> list = superNewDao.gethotlist();
		outPrintJSON(list);
	}
	
	/**
	 *获取礼品列表
	 *
	 * @return
	 */
	public void exchangeList(){
		
		List<Map<String,Object>> list=superNewDao.exchangeList();
		

		outPrintJSON(list);
	}
	
	
	/**
	 * 获取积分获取纪录
	 *  http://SERVER[:PORT]/PROJECTNAME/app/SuperMarketNew!pointLog.action?userid=xx
	 * @return
	 */
	public void pointLog(){
		String userid = request.getParameter("userid");
		List<Map<String,Object>> list = superNewDao.getpoint_log(userid);
		outPrintJSON(list);
	}
	
	private String getUploadPath() {
		File file=new File(request.getSession().getServletContext().getRealPath(""));
		String uploadPath=file.getParentFile().getAbsolutePath()+"/market_avatar/";
		return uploadPath;
	}
	
	private void importFile(File file,String fileName) throws Exception {
		setHeader();
		InputStream is=new FileInputStream(file);
		FileOutputStream fs=new FileOutputStream(getUploadPath()+fileName);
		byte[] buffer=new byte[1024];
		int part=0;
		while((part=is.read(buffer))!=-1){
			fs.write(buffer, 0, part);
		}
		fs.close();
		is.close();
	}
	
	
	public void setHeader(){
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");

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
