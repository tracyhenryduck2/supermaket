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
	function search(){                          
			Dialog.opener().document.getElementById("username").value = $("#username").val()||"";    
			Dialog.opener().document.getElementById("password").value = $("#password").val()||"";    
			Dialog.opener().document.getElementById("nickname").value = $("#nickname").val()||"";    
			Dialog.opener().document.getElementById("tel").value = $("#tel").val()||"";    
			Dialog.opener().document.getElementById("email").value = $("#email").val()||"";    
			Dialog.opener().document.getElementById("state").value = $("#state").val()||"";    
			Dialog.opener().document.getElementById("comments").value = $("#comments").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "sUserBean.username":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sUserBean.password":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sUserBean.nickname":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sUserBean.tel":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sUserBean.email":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sUserBean.state":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "sUserBean.comments":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "sUserBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="#" method="post" target="fram" >   
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            用户名<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.username" id="username"  value="${sUserBean.username}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            密码<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.password" id="password"  value="${sUserBean.password}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            昵称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.nickname" id="nickname"  value="${sUserBean.nickname}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            电话<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.tel" id="tel"  value="${sUserBean.tel}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            邮箱<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.email" id="email"  value="${sUserBean.email}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            状态<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.state" id="state"  value="${sUserBean.state}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            备注<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.comments" id="comments"  value="${sUserBean.comments}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="button" name="查询" value="查询" onclick="search();" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
