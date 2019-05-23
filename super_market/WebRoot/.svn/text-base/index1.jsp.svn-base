<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache"/> 
<meta http-equiv="Cache-Control" content="no-store, must-revalidate"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico" />
<script type="text/javascript">
$(document).ready(function(){
	$(window).resize(function() {
		var sHeight = $(window).height();
		$("#tfm_table").css("height",sHeight);
		$("#iframe_left").css("height",sHeight-106);
		$("#iframe_content").css("height",sHeight-106);
	});
});

function switchSysBar()
{
	if($("#tfm_left").is(":hidden")){
		$("#tfm_left").css("width",162);
		$("#tfm_left").show();
		$("#img1").attr("src","<%=path%>/images/style/toleft.png");
	} else {
		$("#tfm_left").css("width",0);
		$("#tfm_left").hide();
		$("#img1").attr("src","<%=path%>/images/style/toright.png");
	}
}
function getDate(){
	init();
	return new Date().getYear()+"年"+(new Date().getMonth()+1)+"月"+new Date().getDate()+"日 星期"+"日一二三四五六".charAt(new Date().getDay());
}
function s_getDate(){
	document.getElementById("s_date").innerHTML=getDate();
}
function changeUserPWD() {
	Dialog.open({Title:"修改个人密码", Width:400, Height:250, URL:"<%=path%>/system/SUser!toPwd.action"});
}

function myopen(url){
	$("#iframe_content").attr("src","<%=path%>/"+url);
}
function init() {
		var i=2;
		for(;i<16;i++)
		{
				if(document.getElementById("submenu" + i)!=null)
				document.getElementById("submenu" + i).style.display="none";
				if(document.getElementById("imgmenu" + i)!=null)
				document.getElementById("imgmenu" + i).background="<%=path%>/images/style/leftmenubg.png";
		}
}

function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="<%=path%>/images/style/leftmenubg.png";
		var i=1;
		for(;i<16;i++)
		{
			if(i!=sid)
			{
				if(document.getElementById("submenu" + i)!=null)
				document.getElementById("submenu" + i).style.display="none";
				if(document.getElementById("imgmenu" + i)!=null)
				document.getElementById("imgmenu" + i).background="<%=path%>/images/style/leftmenubg.png";
			}			
			
		}
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="<%=path%>/images/style/leftmenubg.png";
}
}
</script>
<title>透明商超后台管理系统</title>
<style>
table{border-collapse:collapse;border-spacing:0;}
#tfm_table{ width:100%; height:100%; border:none; padding:0px; margin:0px;}
#tfm_table td { border:0; padding:0px; margin:0px;}
#tfm_table .top {height:82px;background:url(<%=path%>/images/style/topbg.png) repeat-x;}
.half_top { color:#FFF;}
.role_name {color:#FFF;}
#tfm_header_menu {height:25px; width:100%;}
#tfm_header_menu .menu_left {background:url(<%=path%>/images/style/date.png) no-repeat center left;height:25px;float:left;width:255px; margin:0 0 0 10px; text-align:left;line-height:25px;padding-left:20px;}

.navPoint {cursor:hand;}
.STYLE2 {
	font-size: 12px;color: #FFFFFF;underline:none;
}

.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>

</head>
<body onload="s_getDate()">
<table id="tfm_table" cellpadding="0" cellspacing="0"  width="100%"  height="100%" >
    <tr>
        <td class="top" valign="middle">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				  <tr>
				    <td height="56" style="padding-left:20px;"></td>
				  </tr>
			</table>
          <div id="tfm_header_menu">
                    <div class="menu_left">
                    	<div id="s_date" class="half_top"></div>
                    </div>
                    <div align="right" style="height:25px;line-height:25px;margin-right:5px;">
                   		<span style="background:url(<%=path%>/images/style/user.png) no-repeat center left;height:25px;line-height:25px;margin-right:10px;color:#FFF;padding-left:20px;">欢迎您: ${session.user.nickname}</span>
                     	<a href="javascript:changeUserPWD()" style="background:url(<%=path%>/images/style/setting.png) no-repeat center left;color:#FFF;text-decoration:none;padding-left:20px;">修改密码</a>
                     	<a href="Index!logout.action" style="background:url(<%=path%>/images/style/exit.png) no-repeat center left;color:#FFF;text-decoration:none;padding-left:20px;">退出</a>
					</div>
          	</div>
      </td>
    </tr>
    <tr>
        <td  valign="top"  >
          <table  id="content" cellpadding="0" cellspacing="0" width="100%" height="100%" style="overflow:hidden;table-layout:fixed;">
          	<tr>
            	<td valign="top" width="162" nowrap="nowrap" id="tfm_left" style="overflow:hidden;padding-top:2px;">
       		 							<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
						  <tr>
						    <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
							<s:iterator value="#session.user.groupMenuList" id="group"> 
						      <tr>
						        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
						          <tr>
						            <td height="23" background="<%=path%>/images/style/leftmenubg.png" id="imgmenu${group.group_id}"
						             class="menu_title"  onClick="showsubmenu(${group.group_id})" 
						             style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
						              <tr>
						                <td class="STYLE2" align="center" >${group.group_name}</td>
						              </tr>
						            </table></td>
						          </tr>
						          <tr>
						            <td background="<%=path%>/images/main_51.gif" id="submenu${group.group_id}">
									 <div class="sec_menu" >  
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
						              <tr>
						                <td>
							                <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
												<s:iterator value="#group.funList" id="function"> 
									                  <tr>
									                    <td  height="25" align="left"  style="cursor:hand" onclick="myopen('${function.url}');" 
									                    		onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#8193A8';"
									                    		onmouseout="this.style.borderStyle='none'"
									                    	>
									                    		<span style="margin-left:10px;"><img src="<%=path%>/images/left.gif" width="10" height="10" /></span>
									                    		<span style="font-size:12px;color:#033d61;margin-left:10px;">${function.name}</span>
									                    </td>
									                  </tr>
												  </s:iterator> 
							                </table>
						                </td>
						              </tr>
						              <tr>
						                <td height="5"><img src="<%=path%>/images/main_52.gif" width="151" height="5" /></td>
						              </tr>
						            </table></div></td>
						          </tr>
						          
						        </table></td>
						      </tr>
							  </s:iterator> 
						    </table></td>
						  </tr>
						  
						</table>
                </td>
                <td class="middle_bar" width="8" valign="middle" align="center" bgcolor="687B91" onclick="switchSysBar()">
                	 <span class="navPoint" id=switchPoint title="打开/关闭左栏">
						<img src="<%=path %>/images/style/toleft.png" name="img1" width=4 height=46 id="img1"/>
					</span>
                </td>
                <td class="right-content" valign="top" align="left">
                    	<iframe src="<%=path %>/test.html" width="100%" height="100%" frameborder="0" id="iframe_content" name="iframe_content"></iframe>
                </td>
            </tr>
          </table>
        </td>
    </tr>
    <tr>
        <td  class="bottom"  style="height:20px;" bgcolor="687B91" >
        	<center>Copyright@2015</center>
        </td>
    </tr>
</table>
</body>
</html>