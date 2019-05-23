<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
%>
<html>
<head>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<script type="text/javascript">

</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>
<body onLoad="init()">
<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="28" background="<%=path%>/images/list_top.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td></td>
      </tr>
    </table></td>

  </tr>
  <tr>
    <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
	<s:iterator value="#session.user.groupMenuList" id="group"> 
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="23" background="<%=path%>/images/main_47.gif" id="imgmenu${group.group_id}"
             class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(${group.group_id})" 
             onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="18%">&nbsp;</td>
                <td width="82%" class="STYLE1">${group.group_name}</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td background="<%=path%>/images/main_51.gif" id="submenu${group.group_id}">
			 <div class="sec_menu" >  
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
				<s:iterator value="#group.funList" id="function"> 
                  <tr>
                    <td width="16%" height="25"><div align="center"><img src="<%=path%>/images/left.gif" width="10" height="10" /></div></td>
                    <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td height="20" style="cursor:hand" onclick="myopen('${function.url}');" 
                          	 onmouseover ="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "
                          	onmouseout="this.style.borderStyle='none'"><span class="STYLE3">${function.name}</span></td>
                        </tr>
                    </table></td>
                  </tr>
				  </s:iterator> 
                </table></td>
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
</body>