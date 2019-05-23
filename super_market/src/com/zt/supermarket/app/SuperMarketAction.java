package com.zt.supermarket.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;


import com.common.Transaction;
import com.opensymphony.xwork2.ActionSupport;
import com.zt.supermarket.bean.CommentsBean;
import com.zt.supermarket.dao.CommentsDAO;

public class SuperMarketAction extends ActionSupport implements
ServletResponseAware, ServletRequestAware{
	protected HttpServletRequest request = null;
	protected HttpServletResponse response = null;
	private PrintWriter out = null;
	private SuperMarketDAO dao=new SuperMarketDAO();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 读取首页轮播图片信息
	 * 
	 * URL : app/SuperMarket!getCarouselInfo.action 
	 * 支持格式 : JSON 
	 * HTTP请求方式 : GET 
	 * 
	 */
	public void getCarouselInfo(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.getCarouseInfoList();
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 首页市场监管热点以及热门超市list获取
	 * 
	 * URL : app/SuperMarket!marketHotList.action
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET
	 * 返回结果示例 :
	 *  { manage: [ { title:”市场监管”; list: [ {
	 * content_title:”创建一个有效的移动主页也是优化的一部分”,
	 * content:“xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx” }, {
	 * content_title:”创建一个有效的移动主页也是优化的一部分”,
	 * content:“xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx” }
	 *  ] }, { title:”部门公告”; list: [ { content_title:”创建一个有效的移动主页也是优化的一部分”,
	 * content:“xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx” }, {
	 * content_title:”创建一个有效的移动主页也是优化的一部分”,
	 * content:“xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx” }
	 *  ] }, { title:”监管动态”; list: [ { content_title:”创建一个有效的移动主页也是优化的一部分”,
	 * content:“xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx” }, {
	 * content_title:”创建一个有效的移动主页也是优化的一部分”,
	 * content:“xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx” }
	 *  ] } ],
	 * 
	 * market: [ { market_pic_url:”http://server/SuperMarket/market1.jpg”,
	 * market_id: 1, marketName:”超市1” }, {
	 * market_pic_url:”http://server/SuperMarket/market2.jpg”, market_id: 2,
	 * marketName:”超市1”
	 *  }, { market_pic_url:”http://server/SuperMarket/market3.jpg”, market_id:
	 * 3, marketName:”超市3”
	 *  }
	 *  ] }
	 */
	public void marketHotList(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> titlelist=dao.getTitleList();
			for(Map<String,Object> map:titlelist){
				long titleId=Long.valueOf(map.get("id")+"");
				List<Map<String,Object>> list=dao.getList(titleId);
				map.put("list", list);
			}
			List<Map<String,Object>> marketlist=dao.getMarketList();
			String json="{ \"manage\": ";
			json+=JSONArray.fromObject(titlelist);
			json+=",\"market\": ";
			json+=JSONArray.fromObject(marketlist);
			json+="}";
			out.print(json);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 超市首页信息获取 
	 * 
	 * URL : app/SuperMarket!marketIndex.action?id=1 
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  { pic_list: [ {pic_url:”http://server/SuperMarket/1.jpg”},
	 * {pic_url:”http://server/SuperMarket/2.jpg”}, {pic_url:”http://server/SuperMarket/3.jpg”} ],
	 * introduce:”XXXXXXXXXXXXXXXXXXXXXXXXX”, videolist: [ {pic_url:
	 * ”http://server/SuperMarket/1.jpg”, videoid:1}, {pic_url:
	 * ”http://server/SuperMarket/2.jpg”, videoid:2}, {pic_url:
	 * ”http://server/SuperMarket/3.jpg”, videoid:3}, {pic_url:
	 * ”http://server/SuperMarket/4.jpg”, videoid:4} ], informationlist: [
	 * {id:1,content_title:”xxxxxx”,content:”xxxxxxxxxxxxxxx”},
	 * {id:2,content_title:”xxxxxx”,content:”xxxxxxxxxxxxxxx”}, {
	 * id:3,content_title:”xxxxxx”,content:”xxxxxxxxxxxxxxx”} ] }
	 * 
	 */
	public void marketIndex(){
		setTextEncode();
		try {
			out=response.getWriter();
			long id=Long.valueOf(request.getParameter("id"));
			Map<String,Object> map=new HashMap<String,Object>();
			List<Map<String,Object>> piclist=dao.getPicList(id);
			List<Map<String,Object>> videolist=dao.getVideoList(id);
			List<Map<String,Object>> informationlist=dao.marketNewsList(id);
			String introduce=dao.getIntroduce(id);
			map.put("pic_list", piclist);
			map.put("introduce", introduce);
			map.put("videolist", videolist);
			map.put("informationlist", informationlist);
			out.print(JSONObject.fromObject(map));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取商超的监控视频列表
	 * 
	 * URL : app/SuperMarket!marketVideoList.action?id=1
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 
	 */
	public void marketVideoList(){
		setTextEncode();
		try {
			out=response.getWriter();
			long id=Long.valueOf(request.getParameter("id"));
			List<Map<String,Object>> list=dao.getMarketVideoList(id);
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取商超信息动态新闻列表
	 * 
	 * URL : app/SuperMarket!marketNewsList.action?id=1
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET
	 * 
	 */
	public void marketNewsList(){
		setTextEncode();
		try {
			out=response.getWriter();
			long id=Long.valueOf(request.getParameter("id"));
			List<Map<String,Object>> list=dao.marketNewsList(id);
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取商超信息动态新闻详情
	 * 
	 * URL : app/SuperMarket!marketNewsDetail.action?newsId=1&id=1
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  { Content_title:”xxxxxxxxxx”， Pic_url:”
	 * http://server/SuperMarket/1.jpg”, Content:”xxxxxxxxxxxxxxxxxxxxxx” }
	 * 
	 */
	public void marketNewsDetail(){
		setTextEncode();
		try {
			out=response.getWriter();
			long id=Long.valueOf(request.getParameter("id"));
			String userid=request.getParameter("uId");
			Map<String,Object> map=dao.marketNewsDetail(id,userid);
			out.print(JSONObject.fromObject(map));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取市场监管列表标题
	 * 
	 * URL : app/SuperMarket!manageColumn.action
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例
	 *  [ {id:1,title:”xxxxx”}, {id:2,title:”xxxxx”},{id:3,title:”xxxxx”}, ]
	 * 
	 */
	public void manageColumn(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.manageColumn();
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取市场监管列表
	 * 
	 * URL : app/SuperMarket!manageList?id=1
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  [ {id:1,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”},
	 * {id:2,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”},
	 * {id:3,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”} ]
	 * 
	 */
	public void manageList(){
		setTextEncode();
		try {
			out=response.getWriter();
			long id=Long.valueOf(request.getParameter("id"));
			List<Map<String,Object>> list=dao.manageList(id);
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取留言板菜单列表
	 * 
	 * URL : app/SuperMarket!messageBoardMenu.action
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  [ {id:1,name:”想说就说”,uri:”xiangshuojiushuo.html”,img:”xxxxxxx.jpg” },
	 * {id:2,name:”满意度调查”,uri:”xiangshuojiushuo.html”,img:”xxxxxxx.jpg” },
	 * {id:3,name:”超市排行榜”,uri:”xiangshuojiushuo.html”,img:”xxxxxxx.jpg” }, ]
	 * 
	 */
	public void messageBoardMenu(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.messageBoardMenu();
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取超市排行榜列表(列表)
	 * 
	 * URL : app/SuperMarket!marketRank.action
	 * 支持格式 : JSON
	 * HTTP请求方式 :GET
	 * 返回结果示例 :
	 *  [ {id:1,name:”超市1”,pic_url:”xxxxx.jpg”},
	 * {id:2,name:”超市2”,pic_url:”xxxxx.jpg”},
	 * {id:3,name:”超市3”,pic_url:”xxxxx.jpg”},
	 * {id:4,name:”超市4”,pic_url:”xxxxx.jpg”},
	 * {id:5,name:”超市5”,pic_url:”xxxxx.jpg”}, ]
	 * 
	 */
	public void marketRank(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.marketRank();
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取超市排行榜列表
	 * 
	 * URL : app/SuperMarket!marketRankTwo.action
	 * 支持格式 : JSON
	 * HTTP请求方式 :GET
	 * 
	 */
	public void marketRankTwo(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.marketGood();
			List<Map<String,Object>> list2=dao.marketAdvanced();
			List<Map<String,Object>> list3=dao.marketAdmonishing();
			Map<String,Object> obj = new HashMap<String,Object>();
			obj.put("goodlist", list);
			obj.put("advancelist", list2);
			obj.put("admonishinglist", list3);
		    JSONObject rootObj = JSONObject.fromObject(obj);
			out.print(rootObj);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取超市满意度调查问卷信息
	 * 
	 * URL : app/SuperMarket!getQuestionnaire.action?surveyId=1
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  [ {id:1, question:” 请问您在上个月喝过几瓶啤酒？”, chooseList:[ {
	 * answerId:1,”content”:”1瓶”}, { answerId:2,”content”:”2瓶”}, {
	 * answerId:3,”content”:”3瓶”}, { answerId:4,”content”:”4瓶”} ] },
	 *  {id:2,question:” 请问您在上个月喝过几瓶啤酒？”, chooseList:[ 
	 *  { answerId:1,”content”:”1瓶”}, {
	 * answerId:2,”content”:”2瓶”}, { answerId:3,”content”:”3瓶”}, {
	 * answerId:4,”content”:”4瓶”} ] },
	 * {id:3, question:” 请问您在上个月喝过几瓶啤酒？”, chooseList:[
	 * {answerid:1,”content”:”1瓶”}, { answerId:2,”content”:”2瓶”}, {
	 * answerId:3,”content”:”3瓶”}, { answerId:4,”content”:”4瓶”} ] },
	 *  ]
	 * 
	 */
	public void getQuestionnaire(){
		setTextEncode();
		try {
			out=response.getWriter();
			long surveyId=Long.parseLong(request.getParameter("surveyId"));
			List<Map<String,Object>> list=dao.getQuestionnaire(surveyId);
			for(Map<String,Object> map:list){
				long id=Long.valueOf(map.get("id")+"");
				List<Map<String,Object>> chooseList=dao.getChooseList(id);
				map.put("chooseList", chooseList);
			}
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取行情速递列表信息
	 * 
	 * URL : app/SuperMarket!getHQList.action?type=4
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  [ {id:1,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”},
	 * {id:2,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”},
	 * {id:3,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”} ]
	 * 
	 */
	public void getHQList(){
		setTextEncode();
		try {
			out=response.getWriter();
			long typeId=Long.parseLong(request.getParameter("type"));
			List<Map<String,Object>> list=dao.getHQList(typeId);
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取温馨小贴士列表信息
	 * 
	 * URL : app/SuperMarket!getTipsList.action?type=5
	 * 支持格式 : JSON
	 * HTTP请求方式 : GET 
	 * 返回结果示例 :
	 *  [ {id:1,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”},
	 * {id:2,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”},
	 * {id:3,content_title:”xxxxx”,content:”xxxxxxxxxxxxxxxxxxx”} ]
	 * 
	 */
	public void getTipsList(){
		setTextEncode();
		try {
			out=response.getWriter();
			long typeId=Long.parseLong(request.getParameter("type"));
			List<Map<String,Object>> list=dao.getTipsList(typeId);
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取想说就说评论列表
	 * 
	 * URL : app/SuperMarket!getCommentListInfo.action
	 * 支持格式 : JSON
	 * HTTP请求方式 :GET 
	 * 返回结果示例 :
	 *  [ {userId:1,username:”xxx”,pic_url:”xxxxxx.jpg”,comment:”一楼叫隔壁老王”},
	 * {userId:2,username:”xxx”,pic_url:”xxxxxx.jpg”,comment:”一楼叫隔壁老王”},
	 * {userId:3,username:”xxx”,pic_url:”xxxxxx.jpg”,comment:”一楼叫隔壁老王”},
	 * {userId:4,username:”xxx”,pic_url:”xxxxxx.jpg”,comment:”一楼叫隔壁老王”}, ]
	 * 
	 */
	public void getCommentListInfo(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.getCommentListInfo();
			out.print(JSONArray.fromObject(list));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交用户评论
	 * 
	 * URL : app/SuperMarket!submitComment.action?userId=1&comment=XXXXXXXXXXXXX
	 * 支持格式 : JSON
	 * HTTP请求方式 : POST 
	 * 返回结果示例 :
	 *  { flag:true }
	 * 
	 */
	public void submitComment(){
		setTextEncode();
		try {
			out=response.getWriter();
			//long userId=Long.valueOf(request.getParameter("userId"));
			String comment=request.getParameter("comment");
			String url = request.getParameter("headimgurl");
			String nickname = request.getParameter("nickname");
			long createTime=new Date().getTime()/1000;
			long sortId=dao.getMaxSortId();
			CommentsBean commentsbean = new CommentsBean();
			commentsbean.setContent(comment);
			commentsbean.setCreateTime(createTime);
			commentsbean.setWeight(sortId);
			CommentsDAO dao = new CommentsDAO();
			boolean result=dao.insert(commentsbean);
			JSONObject json=new JSONObject();
			json.put("flag", result);
			out.print(json);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getInstruction(){
		setTextEncode();
		try {
			out=response.getWriter();
			List<Map<String,Object>> list=dao.getTipsList(6);
		    JSONArray rootObj = JSONArray.fromObject(list);
			out.print(rootObj);
			out.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取content的详情
	 * URL: app/SuperMarket!getContentInfo.action?contentId=xxx
	 * 支持格式 : JSON
	 * HTTP请求方式 : POST 
	 * 返回结果示例 :
	 *  {"id":1,
	 *  "title":"监管",
	 *  "pic_url":"1441933602158_200.png",
	 *  "digest":"test","create_time":1441933605,
	 *  "type_id":3,
	 *  "content":"123"
	 *  "detial_pic_uri":"test"
	 *  }
	 */
	public void getContentInfo(){
		setTextEncode();
		try {
			out=response.getWriter();
			long contentId = Long.parseLong(request.getParameter("contentId"));
			String userId = request.getParameter("uId");
			 Map<String, Object> content = dao.getContentById(contentId,userId);
			JSONObject rootObj = JSONObject.fromObject(content);
			out.print(rootObj);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void submitSurveyResult(){
		setTextEncode();
		try {
			out=response.getWriter();
		    final long surveyId = Long.parseLong(request.getParameter("survey_id"));
		    final String jsonstr = request.getParameter("survey_result");
		    final String imei = request.getParameter("imei");
		    final String user_id = request.getParameter("user_id");
		    final JSONArray objarray = JSONArray.fromObject(jsonstr);		    
			boolean result = new Transaction(){

				@Override
				public void run() throws Exception {
					// TODO Auto-generated method stub
					for(int i=0;i<objarray.size();i++)
					{
						JSONArray arr = objarray.getJSONObject(i).getJSONArray("answer_array");
						for(int j=0;j<arr.size();j++)
						{
							dao.insertToSelectedSurveyResult(objarray.getJSONObject(i).getLong("question_id")
					                ,arr.getJSONObject(j).getLong("answer_id")
					                ,surveyId,imei,user_id,arr.getJSONObject(j).getLong("answer_of_storeid"));
						}


					}
				}
				
			}.start();
			JSONObject json=new JSONObject();
			json.put("flag", result);
			out.print(json);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	
	private void setTextEncode(){
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
