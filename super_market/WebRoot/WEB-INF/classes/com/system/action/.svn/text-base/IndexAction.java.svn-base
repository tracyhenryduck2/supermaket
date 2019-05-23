package com.system.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.BaseActionSupport;
import com.common.LoginUser;
import com.system.dao.IndexDAO;
import com.system.dao.SFunctionDAO;


public class IndexAction extends BaseActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	/**
	 * 登录
	 * @return
	 */
	public String index(){
		String result="error";
		if(session.get("user")!=null){
			return "success";
		}
		if(username!=null&&password!=null){
			if(username.length()>0&&password.length()>0){
				IndexDAO dao = new IndexDAO();
				LoginUser user=dao.selectUserBean(username,password);
				if(user!=null){
					SFunctionDAO fDAO = new SFunctionDAO();
					List<Map<String,Object>> functionList = fDAO.getList(user.getRole());
					 List<Map<String,Object>> groupList = new ArrayList<Map<String,Object>>();
					 Long groupId = null;
					 Map<String,Object> map = new HashMap<String,Object>();
					 for(int i=0; i<functionList.size();i++) {
						 if(!(functionList.get(i).get("group_id")+"").equals(groupId+"")) {
							 map.put("group_id", Long.parseLong(functionList.get(i).get("group_id")+""));
							 map.put("group_name", functionList.get(i).get("group_name")+"");
							 List<Map<String,Object>> funList = new ArrayList<Map<String,Object>>();
							 funList.add(functionList.get(i));
							 map.put("funList", funList);
							 groupList.add(map);
							 map = new HashMap<String,Object>();
						 } else {
							 ((List<Map<String,Object>>)groupList.get(groupList.size()-1).get("funList")).add(functionList.get(i));
						 }
						 groupId = Long.parseLong(functionList.get(i).get("group_id")+"");
					 }
					 user.setGroupMenuList(groupList);
					session.put("user", user);
					result="success";
				}else{
					showMessage="用户名密码错误或该账户被停用！";
				}
			}else{
				showMessage="请正确填写用户名和密码！";
			}
		}else{
			showMessage=null;
		}
		return result;
	}
	/**
	 * 登出
	 * @return
	 */
	public String logout(){
		if(session.get("user")!=null){
			session.remove("user");
		}
		return "logout";
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
