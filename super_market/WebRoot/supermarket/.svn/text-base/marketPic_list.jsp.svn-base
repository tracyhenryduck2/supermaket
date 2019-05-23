<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %>  
<% 
String path = request.getContextPath();      
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html>    
  <head>  
   
    <title>环境图片</title> 
	<meta http-equiv="pragma" content="no-cache">  
	<meta http-equiv="cache-control" content="no-cache">  
	<meta http-equiv="expires" content="0"> 
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">   
	<meta http-equiv="description" content="This is my page">    
	<script type="text/javascript">    
		function add(){      
			Dialog.open({Title:"新增", Width:600, Height:360, URL:"<%=path%>/supermarket/MarketPic!toAddMarketPic.action?marketPicBean.marketId=${marketPicBean.marketId}"});   
		}      
		function mod(){      
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"编辑", Width:600, Height:360, URL:"<%=path%>/supermarket/MarketPic!toAddMarketPic.action?oper=1&marketPicBean.id="+id});
		}      
		function detail(){   
			var id = getCheckRowValue();     
			if(id==null) {     
				return;   
			}    
			Dialog.open({Title:"详情", Width:500, Height:360, URL:"<%=path%>/supermarket/MarketPic!toAddMarketPic.action?read=1&oper=1&marketPicBean.id="+id});    
		}      
		function del(){      
			if(!isCheckAny("idArr")){      
				Dialog.alert("请至少勾选一个！");   
				return;   
			}    
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/supermarket/MarketPic!delMarketPics.action";
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
			Dialog.open({Title:"查询", Width:650, Height:220, URL:"<%=path%>/supermarket/MarketPic!search.action",OnLoad:function(){
			     this.innerDoc.getElementById("market_id").value = $("#market_id").val();
			     this.innerDoc.getElementById("filename").value = $("#filename").val();
			     this.innerDoc.getElementById("pic_url").value = $("#pic_url").val();
			     this.innerDoc.getElementById("url").value = $("#url").val();
			     this.innerDoc.getElementById("seq_no").value = $("#seq_no").val();
           }
			});    
		}      
		
	</script>
  </head> 
  <body>  
  <GF:BodyCaption label="环境图片" ico="images/ico/user.gif"> 
  	<GF:ToolBar id="123">    
  		<!-- 
	  	<GF:ToolBarItem id="search" label="查询" ico="images/ico/search.gif" onclick="search();" />    
	  	 --> 
	  	<GF:ToolBarItem id="add" label="添加" ico="images/ico/add.gif" 		onclick="add();" />   
	  	<GF:ToolBarItem id="edit" label="编辑" ico="images/ico/edit.gif" 	onclick="mod();" />   
	  	<GF:ToolBarItem id="delete" label="删除" ico="images/ico/delete.gif" onclick="del();"/> 
	  	<GF:ToolBarItem id="detail" label="详情" ico="images/ico/detail.gif" onclick="detail();"/>     
	  	<GF:ToolBarItem id="export" label="导出" ico="images/ico/export.gif" onclick="exportExcel();"/>
	  	<GF:ToolBarItem id="refresh" label="刷新" ico="images/ico/refresh.gif" onclick="refresh();"/>  
	</GF:ToolBar>   
    <form action="<%=path%>/supermarket/MarketPic!list.action" name="form1" id="form1" method="get">  
   
			<input type="hidden" name="marketPicBean.marketId" id="marketId" value="${marketPicBean.marketId}"/> 
			<input type="hidden" name="marketPicBean.filename" id="filename" value="${marketPicBean.filename}"/> 
			<input type="hidden" name="marketPicBean.picUrl" id="picUrl" value="${marketPicBean.picUrl}"/> 
			<input type="hidden" name="marketPicBean.url" id="url" value="${marketPicBean.url}"/> 
			<input type="hidden" name="marketPicBean.seqNo" id="seqNo" value="${marketPicBean.seqNo}"/> 
		   	<input type="hidden" name="sortname" value="${page.sortname}"/>    
		   	<input type="hidden" name="sortorder"  value="${page.sortorder }"/>
		   	<input type="hidden" name="pageSize" value="${page.pageSize}"/>    
		   	<input type="hidden" name="pageNo"  value="${page.pageNo }"/>      
			<table id="table1" width="100%" height="100%"  border="0" cellspacing="0" cellpadding="0"> 
			   	 <thead>
			   		<tr>  
			   			<th><span><input type="checkbox" onClick="checkAll(this,'idArr')"  width="20"/></span></th>     
			   			<th sortname="market_id" width="20%">商超</th>	   
			   			<th sortname="filename" width="20%">名称</th>	   
			   			<th sortname="pic_url" width="30%">图片地址</th>	   
			   			<th sortname="url" width="30%">链接地址</th>	   
			   			<th sortname="seq_no" width="10%">排序</th>	   
			   		</tr> 
			   	</thead>
			   	<tbody> 
			   		<s:iterator value="#request.list" id="map"> 
		   			 <tr> 
		   			 	 <td align="left"><input type="checkbox" name="idArr"  value="${map.id}"/></td> 
		   			 	 <td>${map.market_name}</td>    
		   			 	 <td>${map.filename}</td>    
		   			 	 <s:if test="#request.map.pic_url!=''">
		   			 	 <td><img src="../../supermarket_images/market/${map.pic_url}" width="300px" height="50px"/></td>  
		   			 	 </s:if> 
		   			 	 <s:else>
		   			 	 <td><img src="../images/default.jpg" width="300px" height="100px"/></td>  
		   			 	 </s:else>  
		   			 	 <td>${map.url}</td>    
		   			 	 <td>${map.seq_no}</td>    
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
