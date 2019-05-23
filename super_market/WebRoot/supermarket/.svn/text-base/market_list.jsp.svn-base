<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %>  
<% 
String path = request.getContextPath();      
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>    
  <head>  
   
    <title>超市</title> 
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0"> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
	<meta http-equiv="description" content="This is my page">    
	<script type="text/javascript">    
		function add(){      
			Dialog.open({Title:"新增", Width:1000, Height:600, URL:"<%=path%>/supermarket/Market!toAddMarket.action"});   
		}      
		function mod(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑", Width:1000, Height:600, URL:"<%=path%>/supermarket/Market!toAddMarket.action?oper=1&marketBean.id="+id});
		}      
		function detail(){   
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"详情", Width:1000, Height:600, URL:"<%=path%>/supermarket/Market!toAddMarket.action?read=1&oper=1&marketBean.id="+id});    
		}      
		function del(){      
			if(!isCheckAny("idArr")){      
				Dialog.alert("请至少勾选一个！");   
				return;   
			}    
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/supermarket/Market!delMarkets.action";
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
			Dialog.open({Title:"查询", Width:650, Height:220, URL:"<%=path%>/supermarket/Market!search.action",OnLoad:function(){
			     this.innerDoc.getElementById("name").value = $("#name").val();
			     this.innerDoc.getElementById("rank").value = $("#rank").val();
			     this.innerDoc.getElementById("head_pic").value = $("#head_pic").val();
			     this.innerDoc.getElementById("info").value = $("#info").val();
           }
			});    
		}      
		function add_pic(){
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"图片列表", Width:650, Height:600, URL:"<%=path%>/supermarket/MarketPic!list.action?oper=1&marketBean.id="+id});
		}
		function add_vedio(){
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"视频列表", Width:650, Height:600, URL:"<%=path%>/supermarket/MarketVedio!list.action?oper=1&marketBean.id="+id});
		}
	</script>
  </head> 
  <body>  
  <GF:BodyCaption label="超市" ico="images/ico/user.gif"> 
  	<GF:ToolBar id="123">     
	  	<GF:ToolBarItem id="search" label="查询" ico="images/ico/search.gif" onclick="search();" />    
	  	<s:if test="#session.user.role==0"><GF:ToolBarItem id="add" label="添加" ico="images/ico/add.gif" 		onclick="add();" />   </s:if>
	  	<GF:ToolBarItem id="edit" label="编辑" ico="images/ico/edit.gif" 	onclick="mod();" />   
	  	<s:if test="#session.user.getRole()==0"><GF:ToolBarItem id="delete" label="删除" ico="images/ico/delete.gif" onclick="del();"/> </s:if>
	  	<GF:ToolBarItem id="detail" label="详情" ico="images/ico/detail.gif" onclick="detail();"/>     
	  	<GF:ToolBarItem id="export" label="导出" ico="images/ico/export.gif" onclick="exportExcel();"/>
	  	<GF:ToolBarItem id="refresh" label="刷新" ico="images/ico/refresh.gif" onclick="refresh();"/>
	  	<GF:ToolBarItem id="add_pic" label="编辑图片" ico="images/ico/edit.gif" 	onclick="add_pic();" />   
	  	<GF:ToolBarItem id="add_vedio" label="编辑视频" ico="images/ico/edit.gif" 	onclick="add_vedio();" />     
	</GF:ToolBar>   
    <form action="<%=path%>/supermarket/Market!list.action" name="form1" id="form1" method="get">  
   
			<input type="hidden" name="marketBean.name" id="name" value="${marketBean.name}"/> 
			<input type="hidden" name="marketBean.rank" id="rank" value="${marketBean.rank}"/> 
			<input type="hidden" name="marketBean.headPic" id="headPic" value="${marketBean.headPic}"/> 
			<input type="hidden" name="marketBean.info" id="info" value="${marketBean.info}"/> 
		   	<input type="hidden" name="sortname" value="${page.sortname}"/>    
		   	<input type="hidden" name="sortorder"  value="${page.sortorder }"/>
		   	<input type="hidden" name="pageSize" value="${page.pageSize}"/>    
		   	<input type="hidden" name="pageNo"  value="${page.pageNo }"/>      
			<table id="table1" width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0"> 
			   	 <thead>
			   		<tr>  
			   			<th><span><input type="checkbox" onClick="checkAll(this,'idArr')"  width="20"/></span></th>     
			   			<th sortname="name" width="25%">名称</th>	   
			   			<th sortname="rank" width="5%">排名</th>
			   			<th sortname="type" width="5%">备注</th>	   
			   			<th sortname="head_pic" width="10%">图片</th>	   
			   			<th sortname="info" width="55%">描述</th>	   
			   		</tr> 
			   	</thead>
			   	<tbody> 
			   		<s:iterator value="#request.list" id="map"> 
		   			 <tr> 
		   			 	 <td align="left"><input type="checkbox" name="idArr"  value="${map.id}"/></td> 
		   			 	 <td>${map.name}</td>    
		   			 	 <td>${map.rank}</td>
		   			 	 <td><s:if test="#map.type==1">先进超市</s:if><s:elseif test="#map.type==2">进步超市</s:elseif><s:elseif test="#map.type==3">诫勉超市</s:elseif></td>    
		   			 	 <s:if test="#request.map.head_pic!=''">
		   			 	 <td><img src="../../supermarket_images/market/${map.head_pic}" width="300px" height="50px"/></td>  
		   			 	 </s:if> 
		   			 	 <s:else>
		   			 	 <td><img src="../images/default.jpg" width="300px" height="100px"/></td>  
		   			 	 </s:else>    
		   			 	 <td>${map.info}</td>    
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
