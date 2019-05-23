package com.zt.supermarket.app;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.common.BaseDAO;
import com.zt.supermarket.bean.UserBean;

public class SuperMarketNewDao extends BaseDAO{
	
	public List<Map<String, Object>> getUserList() {
		String sql="select * from user";
		return j.queryForList(sql);
	}

	public Long getUserbeanCount (String username){
	  String sql = "select count(*) from user where username='"+username+"'";	
   		
	  return j.queryForLong(sql);
	}
	
	//登录
	public Map<String, Object> login(String username, String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		String sql="select id,nickname,avatar,type,point " +
				" from user" +
				" where username=? and password=?";
		Object[] param={username,password};
		
		Map<String,Object> user=j.queryForMap(sql,param);
		if(user!=null){
			//签到获取积分
		
			Long today=getTodayTimestamp(0);
			Long a=signcheck(user.get("id").toString(),today);
		
			if(a==0)
			{	
			boolean sign=Sign(user.get("id").toString(),today,user.get("point").toString());
			boolean up=updateSign(user.get("id").toString());
			if(sign){
				user.put("sign", 1);
				user.put("point",Integer.parseInt(user.get("point").toString())+5 );
				
			}
			}
			
			map.put("result", "1");
			map.put("user", user);
		}else{
			System.out.println(user);
			map.put("result", "0");
		}
	
		
		
		
		
		return map;
	}
	
	
	public static Long getTodayTimestamp(int a){
		
		return getTimestampByOffsetDay(a)/1000;
	} 
    
public static long getTimestampByOffsetDay(int day){
	
	Calendar calendar = Calendar.getInstance();
	calendar.add(Calendar.DAY_OF_MONTH, day);
	calendar.set(Calendar.HOUR_OF_DAY, 0);
	calendar.set(Calendar.SECOND, 0);
	calendar.set(Calendar.MINUTE, 0);
	calendar.set(Calendar.MILLISECOND, 0);
	
	return calendar.getTimeInMillis();
}
	
	//登录签到
	public Long signcheck(String Id,Long today){
		String sql="select count(*) from points_log where user_id="+Id+" and log_time="+today+" and get_type=3";
		return j.queryForLong(sql);
	}
	
	
	public boolean Sign(String Id,Long today,String init){
		String sql="insert into points_log(get_type,user_id,log_time,point,init_point) values(3,"+Id+","+today+",5,"+init+") " ;
				
				
		return j.execute(sql);
		
	}
	
	public boolean updateSign(String Id){
		String sql="update user set point=point+5 where id="+Id;
				
		return j.execute(sql);
		
	}
	
	public Map<String, Object> weixlogin(String openid, String avatar,String nickname) {
		Map<String,Object> map=new HashMap<String,Object>();
		String sql="select count(*)" +
				" from user" +
				" where openid=?";
		Object[] param={openid};
		int count=j.queryForInteger(sql,param);
		if(count==0){
			String sql1="insert into user (type,nickname,avatar,openid) values(?,?,?,?)";
			Object[] param2={2,nickname,avatar,openid};
			j.execute(sql1,param2);
		}

			String sql2="select id,nickname,avatar,type" +
			" from user" +
			" where openid=?";
			Object[] param3={openid};
			Map<String,Object> user =j.queryForMap(sql2,param3);
			if(user!=null){
				map.put("result", "1");
				map.put("user", user);
			}else{
				map.put("result", "0");
			}

		return map;
	}
	
	public List<Map<String, Object>> getCollectionList(String uid) {
		String sql = "select content_id as id,type from collection where is_cancel=0 and user_id="+uid;
		List<Map<String,Object>> lsit = j.queryForList(sql);
		List<Integer> l = new ArrayList<Integer>();
		for(int i=0;i<lsit.size();i++){                  //list遍历
			 Long type = Long.parseLong(lsit.get(i).get("type")+"");
			 Long id = Long.parseLong(lsit.get(i).get("id")+"");
			 if(type==1){
				 String sql2="select a.title,a.pic_url,a.digest,a.type_id from content a where  a.id="+id;
				 Map<String,Object> map2 = j.queryForMap(sql2);
				 
				 if(map2!=null){
					 lsit.get(i).put("title", map2.get("title")+"");
					 lsit.get(i).put("pic_url", map2.get("pic_url")+"");
					 lsit.get(i).put("digest", map2.get("digest")+"");
					 lsit.get(i).put("type_id", map2.get("type_id")+"");
				 }else{
					 l.add(i);
				 }

			 }
			 else if(type==2){
				 String sql2="select a.title,a.pic_url,a.digest from market_news a where  a.id="+id;
				 Map<String,Object> map2 = j.queryForMap(sql2);
				 if(map2!=null){
					 lsit.get(i).put("title", map2.get("title")+"");
					 lsit.get(i).put("pic_url", map2.get("pic_url")+"");
					 lsit.get(i).put("digest", map2.get("digest")+"");
				 }else{
					 l.add(i);
				 }

			 }
		}
		List<Map<String,Object>> lsit2 = new ArrayList<Map<String,Object>>();
		for(int i=0;i<lsit.size();i++){
			if(!l.contains(i)){
				lsit2.add(lsit.get(i));
			}
		}

		return lsit2;
	}
	public boolean collectionIsExist(String uid,String content_id ){
		String sql = "select count(*) from collection where user_id = ? and content_id = ?";
		Object[] param ={uid,content_id};
		Long i = j.queryForLong(sql, param);
		if(i>0){
			return true;
		}
		return false;
	}
	
	public boolean updateCollection(String uid,String content_id){
		String sql = "update collection set is_cancel = 0 where user_id = ? and content_id = ?";
		Object[] param = {uid,content_id};
		return j.execute(sql,param);
	}
	
	public boolean addCollection(String uid,String content_id,Long type,Long initpoint){
		String sql ="insert into collection (user_id,content_id,type) values (?,?,?)";
		String sql2 = "update user set point=point+2 where id = ?";
		Long today=getTodayTimestamp(0);
		String sql3 = "insert into points_log(get_type,user_id,log_time,point,init_point) values(2,"+uid+","+today+",2,"+initpoint+") ";
		Object[] param={uid,content_id,type};
		if(j.execute(sql,param)&&j.execute(sql2,uid)&&j.execute(sql3)){
			return true;
		}
		return false;
	}
	
	public Long initpoint(String uid){
		String sql="select point from user where id="+uid;
		return j.queryForLong(sql);
		
	}
	
	public boolean deleteCollection(String uid,String content_id,Long type){
		String sql = "update collection set is_cancel = 1 where user_id = ? and content_id = ? and type = ?";
		Object[] param={uid,content_id,type};
		
		return j.execute(sql,param);
	}
	
	public boolean insertSuggestion(String uid,String content,Long time){

		
		String sql ="insert into comments (member_id,content,create_time,weight) values (?,?,?,?)";
		Object[] param={uid,content,time,3211};
		
		return j.execute(sql,param);
	}
	
	public List<Map<String, Object>> getLiuyanList(String uid) {
		String sql="select a.*,b.avatar from comments a left join user b on a.member_id=b.id where member_id="+uid+" order by create_time";
		return j.queryForList(sql);
	} 
	
	public Map<String, Object> modavatar(String uId, String url) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean result=false;
		String sql="update user set avatar=? where id=?";
		Object[] param={url,uId};
		result=j.execute(sql,param);
		if(result){
			map.put("fileName", url);
		}else{
			map.put("fileName", null);
		}
		return map;
	}
	
	public Map<String, Object> modPassword(String uId, String password,String newpassword) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean result=false;
		String sql = "select count(*) from user where id="+uId+" and password='"+password+"'";
		if(j.queryForLong(sql)>0){
			String sql1="update user set password=? where id=?";
			Object[] param={newpassword,uId};
			result=j.execute(sql1,param);
			if(result){
				map.put("result", 1);
			}else{
				map.put("result", 0);
			}
		}
		else {
			map.put("result", 2);
		}

		return map;
	}
	
	public Map<String, Object> modNickname(String uId, String nickname) {
		Map<String,Object> map=new HashMap<String,Object>();
		boolean result=false;
		String sql="update user set nickname=? where id=?";
		Object[] param={nickname,uId};
		result=j.execute(sql,param);
		if(result){
			map.put("result", 1);
		}else{
			map.put("result", 0);
		}
		return map;
	}
	
	public List<Map<String, Object>> gethotlist() {
		 String sql = "select a.id,a.title from market_news a where a.show_index=1 order by id desc";
		 return j.queryForList(sql);
	}
	
	public List<Map<String,Object>> getpoint_log(String userid){
		String sql = "select user_id , get_type ,exchange_name ,log_time , point,init_point  from points_log where user_id = "+userid;
		return j.queryForList(sql);
	}
	
	public boolean addPoint(Long id){
		String sql = "update user set point = 50 where id = "+id;
		return j.execute(sql);
	}
	
	public boolean addPointLog(Long id){
		Long today=getTodayTimestamp(0);
		String sql = "insert into points_log(get_type,user_id,log_time,point,init_point) values(1,"+id+","+today+",50,0) ";
		return j.execute(sql);
	}
	public List<Map<String, Object>> exchangeList() {
	String sql="select * from exchange_gift ";
	return j.queryForList(sql);
	}
}
