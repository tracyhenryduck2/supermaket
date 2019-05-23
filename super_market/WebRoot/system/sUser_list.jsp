<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %>  
<% 
String path = request.getContextPath();      
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>    
  <head>  
   
    <title>系统用户表</title> 
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0"> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
	<meta http-equiv="description" content="This is my page">    
	<script type="text/javascript">    
		function add(){      
			Dialog.open({Title:"新增", Width:600, Height:360, URL:"<%=path%>/system/SUser!toAddSUser.action"});   
		}      
		function mod(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑", Width:600, Height:360, URL:"<%=path%>/system/SUser!toAddSUser.action?oper=1&sUserBean.id="+id});
		}      
		function detail(){   
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"详情", Width:500, Height:360, URL:"<%=path%>/system/SUser!toAddSUser.action?read=1&oper=1&sUserBean.id="+id});    
		}      
		function del(){      
			if(!isCheckAny("idArr")){      
				Dialog.alert("请至少勾选一个！");   
				return;   
			}    
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/system/SUser!delSUsers.action";
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
			Dialog.open({Title:"查询", Width:650, Height:220, URL:"<%=path%>/system/SUser!search.action",OnLoad:function(){
			     this.innerDoc.getElementById("username").value = $("#username").val();
			     this.innerDoc.getElementById("password").value = $("#password").val();
			     this.innerDoc.getElementById("nickname").value = $("#nickname").val();
			     this.innerDoc.getElementById("tel").value = $("#tel").val();
			     this.innerDoc.getElementById("email").value = $("#email").val();
			     this.innerDoc.getElementById("state").value = $("#state").val();
			     this.innerDoc.getElementById("comments").value = $("#comments").val();
           }
			});    
		}      
		
	</script>
  </head> 
  <body>  
  <GF:BodyCaption label="系统用户表" ico="images/ico/user.gif"> 
  	<GF:ToolBar id="123">     
	  	<GF:ToolBarItem id="search" label="查询" ico="images/ico/search.gif" onclick="search();" />    
	  	<GF:ToolBarItem id="add" label="添加" ico="images/ico/add.gif" 		onclick="add();" />   
	  	<GF:ToolBarItem id="edit" label="编辑" ico="images/ico/edit.gif" 	onclick="mod();" />   
	  	<GF:ToolBarItem id="delete" label="删除" ico="images/ico/delete.gif" onclick="del();"/> 
	  	<GF:ToolBarItem id="detail" label="详情" ico="images/ico/detail.gif" onclick="detail();"/>     
	  	<GF:ToolBarItem id="export" label="导出" ico="images/ico/export.gif" onclick="exportExcel();"/>
	  	<GF:ToolBarItem id="refresh" label="刷新" ico="images/ico/refresh.gif" onclick="refresh();"/>  
	</GF:ToolBar>   
    <form action="<%=path%>/system/SUser!list.action" name="form1" id="form1" method="get">  
   
			<input type="hidden" name="sUserBean.username" id="username" value="${sUserBean.username}"/> 
			<input type="hidden" name="sUserBean.password" id="password" value="${sUserBean.password}"/> 
			<input type="hidden" name="sUserBean.nickname" id="nickname" value="${sUserBean.nickname}"/> 
			<input type="hidden" name="sUserBean.tel" id="tel" value="${sUserBean.tel}"/> 
			<input type="hidden" name="sUserBean.email" id="email" value="${sUserBean.email}"/> 
			<input type="hidden" name="sUserBean.state" id="state" value="${sUserBean.state}"/> 
			<input type="hidden" name="sUserBean.comments" id="comments" value="${sUserBean.comments}"/> 
		   	<input type="hidden" name="sortname" value="${page.sortname}"/>    
		   	<input type="hidden" name="sortorder"  value="${page.sortorder }"/>
		   	<input type="hidden" name="pageSize" value="${page.pageSize}"/>    
		   	<input type="hidden" name="pageNo"  value="${page.pageNo }"/>      
			<table id="table1" width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0"> 
			   	 <thead>
			   		<tr>  
			   			<th><span><input type="checkbox" onClick="checkAll(this,'idArr')"  width="20"/></span></th>     
			   			<th sortname="username" width="10%">用户名</th>	   
			   			<th sortname="password" width="10%">密码</th>	   
			   			<th sortname="nickname" width="10%">昵称</th>	   
			   			<th sortname="tel" width="10%">电话</th>	   
			   			<th sortname="email" width="10%">邮箱</th>	   
			   			<th sortname="state" width="10%">状态</th>
			   			<th sortname="state" width="10%">权限</th>	   
			   			<th sortname="comments" width="30%">备注</th>	   
			   		</tr> 
			   	</thead>
			   	<tbody> 
			   		<s:iterator value="#request.list" id="map"> 
		   			 <tr> 
		   			 	 <td align="left"><input type="checkbox" name="idArr"  value="${map.id}"/></td> 
		   			 	 <td>${map.username}</td>    
		   			 	 <td>${map.password}</td>    
		   			 	 <td>${map.nickname}</td>    
		   			 	 <td>${map.tel}</td>    
		   			 	 <td>${map.email}</td>    
		   			 	 <td><s:if test="#map.state==1">启用</s:if><s:else>禁用</s:else></td>
		   			 	 <td><s:if test="#map.role==1">超市管理员</s:if><s:else>工商管理员</s:else></td>    
		   			 	 <td>${map.comments}</td>    
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
