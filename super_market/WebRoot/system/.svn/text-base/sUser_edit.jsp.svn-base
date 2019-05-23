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
 var isCommit=false 
	function save(){                        
		if($("#form1").valid()) {           
        if(isCommit==false){   
         isCommit=true       
			form1.submit();                     
      }                 
		}                                     
	}                                       
	                                        
	function result(messageType, message){  
		if(messageType=="error"){           
			Dialog.error(message);				      
		} else if (messageType == "reload_success") {   
			Dialog.alert(message,function(){    
				Dialog.opener().location.reload(); //;= "<%=path%>/system/SUser!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	} 
	
	function changeRole(){
		var role=$("#role").val();
		if(role==1){
			$("#showmarket").css('display',"");
		}
		else {
			$("#showmarket").css('display',"none");
			$("#marketId").val('');
		}
	}                                      
	                                        
	$(function(){                           
		/* form1表单进行验证 */
		changeRole();               
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
<form name="form1" id="form1" action="<%=path %>/system/SUser!addSUser.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="sUserBean.id" id="id" value="${sUserBean.id }"/>  
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
    	<td align="right" > 
                            密码<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.password" id="password"  value="${sUserBean.password}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            昵称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.nickname" id="nickname"  value="${sUserBean.nickname}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            电话<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.tel" id="tel"  value="${sUserBean.tel}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            邮箱<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.email" id="email"  value="${sUserBean.email}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            状态<span class="mark"></span>   
        </td>                            
        <td>
        	<s:select list="#{1:'启用',2:'禁用'}" theme="simple" listKey="key" listValue="value"
        	 value="#request.sUserBean.state" name="sUserBean.state" cssClass="GF-field" id="state"></s:select>                             
        </td>                            
  </tr> 
   <tr>                                    
    	<td align="right" > 
                            权限<span class="mark"></span>   
        </td>                            
        <td>
        	<s:select onchange="changeRole()"  list="#{0:'工商管理员',1:'超市管理员'}" theme="simple" listKey="key" listValue="value"
        	 value="#request.sUserBean.role" name="sUserBean.role" cssClass="GF-field" id="role"></s:select>                             
        </td>                            
  </tr>
   <tr id="showmarket" style="display:none">                                    
    	<td align="right" > 
                            所属超市<span class="mark">*</span>   
        </td>                            
        <td>
        	<s:select list="#request.list" emptyOption="true" listKey="id" listValue="name" name="sUserBean.marketId" id="marketId" theme="simple"  value="#request.sUserBean.marketId" cssClass="GF-field"></s:select>                             
        </td>                            
  </tr>                                  
  <tr>                                    
    	<td align="right" > 
                            备注<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sUserBean.comments" id="comments"  value="${sUserBean.comments}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="button" name="提交" value="提交" onclick="save();" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
