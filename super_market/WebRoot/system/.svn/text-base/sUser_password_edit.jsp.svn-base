<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@ include file="/common/taglibs.jsp" %> 
<% 
String path = request.getContextPath(); 
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<title></title> 
<script type="text/javascript"> 
	function save(){ 
		if($("#form1").valid()) { 
			if($("#passwd2").val()!=$("#passwd").val()) {
				Dialog.alert("两次输入新密码不一致"); 
				return; 
			}
			//if(!(/([0-9]+)/.test($("#passwd2").val()) && /([a-z|A-Z]+)/.test($("#passwd2").val()))) {
			//	Dialog.alert("新密码必须同时包含字母和数字"); 
			//	return;
			//}
			//验证密码是否错误
			var html = $.ajax({
			  data: "sUserBean.id="+$("#id").val()+"&sUserBean.password="+$("#old_passwd").val(),
			  url: g_Path+"/system/SUser!checkPwd.action",
			  type: 'POST',
			  async: false
			 }).responseText;
			 if(html==true || html=="true") {
				 //return true;
			 } else {
				 Dialog.alert("原密码输入错误"); 
				 return; 
			 }
			form1.submit(); 
		} 
	} 
	 
	function result(messageType, message){ 
		if(messageType=="error"){ 
			message = "修改失败";
			Dialog.error(message);				 
		} else if (messageType == "reload_success") { 
			Dialog.alert(message,function(){ 
				parentDialog.close(); 
			}); 
		} else if(messageType == "href_success") { 
			message = "修改成功";
			Dialog.alert(message,function(){ 
				parentDialog.close(); 
			}); 
		} else if(messageType == "exception") { 
			 
		} 
	} 
	 
	$(function(){ 
		/* form1表单进行验证 */ 
		$("#form1").validate({ 
			rules:{ 
			    "sUserBean.password":{ 
			        required : true,
			        minlength:2,
			        maxlength:20
			    }, 
			    "passwd2":{ 
			        required : true,CNRangeLength:[0,20]
			    }, 
			    "old_passwd":{ 
			        required : true,CNRangeLength:[0,20]
			    } 
			}, 
			messages:{ 
				"sUserBean.passwd":{ 
			        required : '请输入新密码',
			        minlength :'密码最小长度为6',
			        maxlength : '密码最大长度为20'
			    }, 
			    "passwd2":{ 
			    	required : '请输入新密码确认'
			    }, 
			    "old_passwd":{ 
			    	required : '请输入原密码'
			    }
			} 
		}); 
	}); 
</script> 
</head> 
<body> 
<form name="form1" id="form1" action="<%=path %>/system/SUser!updateUserPwd.action" method="post" target="fram" > 
<input type="hidden" name="oper" value="${oper}" /> 
<input type="hidden" name="sUserBean.id" id="id" value="${sUserBean.id }"/> 
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid">  
	<tr> 
    	<td align="right" > 
        	用户姓名<span class="mark"></span>
        </td> 
        <td> 
            ${sUserBean.nickname}
        </td> 
    </tr>
     <tr> 
    	<td align="right" > 
        	登录名称<span class="mark"></span>
        </td> 
        <td> 
            ${sUserBean.username}
        </td> 
    </tr> 
	<tr> 
    	<td align="right" > 
        	原密码<span class="mark">*</span>
        </td> 
        <td> 
            <input type="password" name="old_passwd" id="old_passwd"  value="" class="GF-field"/> 
        </td> 
    </tr>
    <tr> 
    	<td align="right" > 
        	新密码<span class="mark">*</span>
        </td> 
        <td> 
            <input type="password" name="sUserBean.password" id="passwd"  value="" class="GF-field"/> 
        </td> 
    </tr>
    <tr> 
    	<td align="right" > 
        	新密码确认<span class="mark">*</span>
        </td> 
        <td> 
            <input type="password" name="passwd2" id="passwd2"  value="" class="GF-field"/> 
        </td> 
    </tr>
     <tr> 
    	<td></td> 
    	<td><input type="button" name="保存" value="保存" onclick="save();" class="GF-btn"/></td> 
    </tr> 
</table> 
<iframe name="fram" id="fram" style="display:none"></iframe> 
</form> 
</body> 
</html>




