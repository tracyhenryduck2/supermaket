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
				Dialog.opener().location.reload(); //;= "<%=path%>/system/SFunction!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "sFunctionBean.name":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sFunctionBean.url":{            
			        CNRangeLength:[0,255]
			    },                              
			    "sFunctionBean.groupId":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "sFunctionBean.sortId":{            
			        number:true,range:[0,9999999999]
			    }                              
			},                                  
			messages:{                          
//			    "sFunctionBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/system/SFunction!addSFunction.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="sFunctionBean.id" id="id" value="${sFunctionBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            名称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sFunctionBean.name" id="name"  value="${sFunctionBean.name}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            功能<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sFunctionBean.url" id="url"  value="${sFunctionBean.url}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            组<span class="mark"></span>   
        </td>                            
        <td>
        	<s:select list="#request.groupList" name="sFunctionBean.groupId" id="groupId" theme="simple" 
        	cssClass="GF-field" emptyOption="true" listKey="id" listValue="name" value="#request.sFunctionBean.groupId"></s:select>                             
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            排序<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="sFunctionBean.sortId" id="sortId"  value="${sFunctionBean.sortId}" class="GF-field"/>   
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
