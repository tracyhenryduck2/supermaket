<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %>  
<% 
String path = request.getContextPath();      
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>    
  <head>  
   
    <title>调查</title> 
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0"> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
	<meta http-equiv="description" content="This is my page">    
	<script type="text/javascript">    
		function add(){      
			Dialog.open({Title:"新增", Width:600, Height:360, URL:"<%=path%>/supermarket/Survey!toAddSurvey.action"});   
		}      
		function mod(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑", Width:600, Height:360, URL:"<%=path%>/supermarket/Survey!toAddSurvey.action?oper=1&surveyBean.id="+id});
		} 
		function edit_question(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑问卷内容", Width:600, Height:600, URL:"<%=path%>/supermarket/Survey!toAddSurveyQuestion.action?surveyBean.id="+id});
		}      
		function detail(){   
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"详情", Width:500, Height:360, URL:"<%=path%>/supermarket/Survey!toAddSurvey.action?read=1&oper=1&surveyBean.id="+id});    
		}      
		function del(){      
			if(!isCheckAny("idArr")){      
				Dialog.alert("请至少勾选一个！");   
				return;   
			}    
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/supermarket/Survey!delSurveys.action";
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
			Dialog.open({Title:"查询", Width:650, Height:220, URL:"<%=path%>/supermarket/Survey!search.action",OnLoad:function(){
			     this.innerDoc.getElementById("name").value = $("#name").val();
			     this.innerDoc.getElementById("create_time").value = $("#create_time").val();
			     this.innerDoc.getElementById("number").value = $("#number").val();
           }
			});    
		}      
		
	</script>
  </head> 
  <body>  
  <GF:BodyCaption label="调查" ico="images/ico/user.gif"> 
  	<GF:ToolBar id="123">     
	  	<GF:ToolBarItem id="search" label="查询" ico="images/ico/search.gif" onclick="search();" />    
	  	<GF:ToolBarItem id="add" label="添加" ico="images/ico/add.gif" 		onclick="add();" />   
	  	<GF:ToolBarItem id="edit" label="编辑" ico="images/ico/edit.gif" 	onclick="mod();" />   
	  	<GF:ToolBarItem id="delete" label="删除" ico="images/ico/delete.gif" onclick="del();"/> 
	  	<GF:ToolBarItem id="detail" label="详情" ico="images/ico/detail.gif" onclick="detail();"/>     
	  	<GF:ToolBarItem id="export" label="导出" ico="images/ico/export.gif" onclick="exportExcel();"/>
	  	<GF:ToolBarItem id="refresh" label="刷新" ico="images/ico/refresh.gif" onclick="refresh();"/>  
	  	<GF:ToolBarItem id="edit" label="编辑问卷内容" ico="images/ico/edit.gif" onclick="edit_question();"/>  
	  	<!-- 
	  	<GF:ToolBarItem id="review" label="预览" ico="images/ico/edit.gif" onclick="review();"/>
	  	<GF:ToolBarItem id="edit" label="启用" ico="images/ico/edit.gif" onclick="edit_state();"/> 
	  	 -->   
	</GF:ToolBar>   
    <form action="<%=path%>/supermarket/Survey!list.action" name="form1" id="form1" method="get">  
   
			<input type="hidden" name="surveyBean.name" id="name" value="${surveyBean.name}"/> 
			<input type="hidden" name="surveyBean.createTime" id="createTime" value="${surveyBean.createTime}"/> 
			<input type="hidden" name="surveyBean.number" id="number" value="${surveyBean.number}"/> 
		   	<input type="hidden" name="sortname" value="${page.sortname}"/>    
		   	<input type="hidden" name="sortorder"  value="${page.sortorder }"/>
		   	<input type="hidden" name="pageSize" value="${page.pageSize}"/>    
		   	<input type="hidden" name="pageNo"  value="${page.pageNo }"/>      
			<table id="table1" width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0"> 
			   	 <thead>
			   		<tr>  
			   			<th><span><input type="checkbox" onClick="checkAll(this,'idArr')"  width="20"/></span></th>     
			   			<th sortname="name" width="60%">名称</th>	   
			   			<th sortname="create_time" width="20%">创建时间</th>	   
			   			<th sortname="number" width="10%">题目数量</th>	
			   			<th sortname="state" width="10%">状态</th>   
			   		</tr> 
			   	</thead>
			   	<tbody> 
			   		<s:iterator value="#request.list" id="map"> 
		   			 <tr> 
		   			 	 <td align="left"><input type="checkbox" name="idArr"  value="${map.id}"/></td> 
		   			 	 <td>${map.name}</td>    
		   			 	 <td><GF:ConvertTime value="${map.create_time}" format="yyyy-MM-dd HH:mm:ss"/></td>    
		   			 	 <td>${map.number}</td>   
		   			 	 <td><s:if test="#map.state==1">启用</s:if><s:else>停用</s:else></td> 
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
