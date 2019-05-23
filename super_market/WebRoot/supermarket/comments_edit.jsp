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
				Dialog.opener().location.reload(); //;= "<%=path%>/supermarket/Comments!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "commentsBean.memberId":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentsBean.createTime":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "commentsBean.content":{            
			        CNRangeLength:[0,255]
			    },                              
			    "commentsBean.weight":{            
			        number:true,range:[0,9999999999]
			    },"commentsBean.feedback_content":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "commentsBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/supermarket/Comments!addComments.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="commentsBean.id" id="id" value="${commentsBean.id }"/>
<input type="hidden" name="commentsBean.memberId" id="memberId" value="${commentsBean.memberId }"/>   
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" > 
                            内容<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.content" id="content"  value="${commentsBean.content}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            权重<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.weight" id="weight"  value="${commentsBean.weight}" class="GF-field"/>   
        </td>                            
  </tr>
    <tr>                                    
    	<td align="right" > 
                            反馈<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.feedbackContent" id="feedbackContent"  value="${commentsBean.feedbackContent}" class="GF-field"/>   
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
