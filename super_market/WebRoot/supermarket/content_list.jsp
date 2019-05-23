<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %>  
<% 
String path = request.getContextPath();      
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>    
  <head>  
   
    <title>新闻</title> 
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0"> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
	<meta http-equiv="description" content="This is my page">    
	<script type="text/javascript">    
		function add(){      
			Dialog.open({Title:"新增", Width:1000, Height:600, URL:"<%=path%>/supermarket/Content!toAddContent.action"});   
		}      
		function mod(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑", Width:1000, Height:600, URL:"<%=path%>/supermarket/Content!toAddContent.action?oper=1&contentBean.id="+id});
		}      
		function detail(){   
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"详情", Width:1000, Height:600, URL:"<%=path%>/supermarket/Content!toAddContent.action?read=1&oper=1&contentBean.id="+id});    
		}      
		function del(){      
			if(!isCheckAny("idArr")){      
				Dialog.alert("请至少勾选一个！");   
				return;   
			}    
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/supermarket/Content!delContents.action";
				form1.target = "fram";
				form1.submit();  
				form1.action = action_tmp;     
				form1.target = "";    
			}, function(){     
				//�?      
			});  
		}      
		
		function result(type, message) {   
			if("reload_success" == type) { 
				Dialog.alert(message,function(){      
					form1.submit();
				});
			} else if("error" == type) {   
				Dialog.error(message);  
			}    
		}      
		function search() {  
			Dialog.open({Title:"查询", Width:650, Height:220, URL:"<%=path%>/supermarket/Content!search.action",OnLoad:function(){
			     this.innerDoc.getElementById("typeId").value = $("#typeId").val();
			     this.innerDoc.getElementById("pic").value = $("#pic").val();
			     this.innerDoc.getElementById("title").value = $("#title").val();
			     this.innerDoc.getElementById("digest").value = $("#digest").val();
			     this.innerDoc.getElementById("createTime").value = $("#createTime").val();
			     this.innerDoc.getElementById("content").value = $("#content").val();
           }
			});    
		}      
		
	</script>
  </head> 
  <body>  
  <GF:BodyCaption label="内容维护" ico="images/ico/user.gif"> 
  	<GF:ToolBar id="123">     
	  	<GF:ToolBarItem id="add" label="添加" ico="images/ico/add.gif" 		onclick="add();" />   
	  	<GF:ToolBarItem id="edit" label="编辑" ico="images/ico/edit.gif" 	onclick="mod();" />   
	  	<GF:ToolBarItem id="delete" label="删除" ico="images/ico/delete.gif" onclick="del();"/> 
	  	<GF:ToolBarItem id="detail" label="详情" ico="images/ico/detail.gif" onclick="detail();"/>     
	  	<GF:ToolBarItem id="refresh" label="刷新" ico="images/ico/refresh.gif" onclick="refresh();"/>  
	</GF:ToolBar>   
    <form action="<%=path%>/supermarket/Content!list.action" name="form1" id="form1" method="get">  
   
			<input type="hidden" name="contentBean.typeId" id="typeId" value="${contentBean.typeId}"/> 
			<input type="hidden" name="contentBean.picUrl" id="pic" value="${contentBean.picUrl}"/> 
			<input type="hidden" name="contentBean.title" id="title" value="${contentBean.title}"/> 
			<input type="hidden" name="contentBean.digest" id="digest" value="${contentBean.digest}"/> 
			<input type="hidden" name="contentBean.createTime" id="createTime" value="${contentBean.createTime}"/> 
			<input type="hidden" name="contentBean.content" id="content" value="${contentBean.content}"/>
			<input type="hidden" name="contentBean.market" id="market" value="${contentBean.market}"/>  
		   	<input type="hidden" name="sortname" value="${page.sortname}"/>    
		   	<input type="hidden" name="sortorder"  value="${page.sortorder }"/>
		   	<input type="hidden" name="pageSize" value="${page.pageSize}"/>    
		   	<input type="hidden" name="pageNo"  value="${page.pageNo }"/>      
			<table id="table1" width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0"> 
			   	 <thead>
			   		<tr>  
			   			<th><span><input type="checkbox" onClick="checkAll(this,'idArr')"  width="20"/></span></th>
			   			<th sortname="id" width="10%">id</th>     
			   			<th sortname="type_id" width="10%">类型</th>	 
			   			<th sortname="pic_url" width="10%">图片</th>	  
			   			<th sortname="title" width="10%">标题</th>	   
			   			<th sortname="digest" width="40%">简介</th>	   
			   			<th sortname="create_time" width="10%">上传时间</th>
			   			<th sortname="market" width="10%">上传超市</th>	   
			   		</tr> 
			   	</thead>
			   	<tbody> 
			   		<s:iterator value="#request.list" id="map"> 
		   			 <tr> 
		   			 	 <td align="left"><input type="checkbox" name="idArr"  value="${map.id}"/></td> 
		   			 	 <td>${map.id}</td>    
		   			 	 <td>${map.type_name}</td>    
		   			 	 <s:if test="#request.map.pic_url!=''">
		   			 	 <td><img src="../../supermarket_images/news/${map.pic_url}" width="300px" height="50px"/></td>  
		   			 	 </s:if> 
		   			 	 <s:else>
		   			 	 <td><img src="../images/default.jpg" width="300px" height="100px"/></td>  
		   			 	 </s:else>
		   			 	 <td>${map.title}</td>    
		   			 	 <td>${map.digest}</td>    
		   			 	 <td><GF:ConvertTime value="${map.create_time}" format="yyyy-MM-dd HH:mm:ss"/></td>
		   			 	 <td>${map.market}</td>    
		   			 </tr>
		   			 </s:iterator> 	    
		   		</tbody>		    		  
   			</table>
   			<GF:Pagination formName="form1" pageNo="${page.pageNo }" pageSize="${page.pageSize }" totalRows="${page.totalRows }"/> 
   </form>
   </GF:BodyCaption>    
   <iframe name="fram" id="fram" style="display:none"></iframe>    
  </body> 
  <script type="text/javascript">   
   	$(function(){      
   		/* 渲染表格 DataGrid */      
   		$("#table1").render().sort("form1");     
   	});  
</script> 
</html>   
