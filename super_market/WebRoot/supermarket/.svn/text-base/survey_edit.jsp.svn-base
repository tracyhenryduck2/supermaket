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
				Dialog.opener().location.reload(); //;= "<%=path%>/supermarket/Survey!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "surveyBean.name":{            
			        CNRangeLength:[0,255]
			    },                              
			    "surveyBean.createTime":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "surveyBean.number":{            
			        number:true,range:[0,9999999999]
			    }                              
			},                                  
			messages:{                          
//			    "surveyBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});                                   
	});                                     
	                                        
	                                        
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/supermarket/Survey!addSurvey.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="surveyBean.id" id="id" value="${surveyBean.id }"/>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            名称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="surveyBean.name" id="name"  value="${surveyBean.name}" class="GF-field" style="width:380px"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            题目数量<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="surveyBean.number" id="number"  value="${surveyBean.number}" class="GF-field"/>   
        </td>                            
  </tr>  
  <tr>                                    
    	<td align="right" > 
                            状态<span class="mark"></span>   
        </td>                            
        <td>                             
            <s:select list="#{2:'停用',1:'启用'}" name="surveyBean.state" id="state"
              value="#request.surveyBean.state" cssClass="GF-field" listKey="key" listValue="value" theme="simple"></s:select>   
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
