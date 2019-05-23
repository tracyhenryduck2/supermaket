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
			Dialog.opener().document.getElementById("memberId").value = $("#memberId").val()||"";    
			Dialog.opener().document.getElementById("createTime").value = $("#createTime").val()||"";    
			Dialog.opener().document.getElementById("content").value = $("#content").val()||"";    
			Dialog.opener().document.getElementById("weight").value = $("#weight").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
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
<form name="form1" id="form1" action="#" method="post" target="fram" >   
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            会员  （没用到）<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.memberId" id="memberId"  value="${commentsBean.memberId}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            创建时间<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.createTime" id="createTime"  value="${commentsBean.createTime}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            内容<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.content" id="content"  value="${commentsBean.content}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            权重<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="commentsBean.weight" id="weight"  value="${commentsBean.weight}" class="GF-field"/>   
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
