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
			Dialog.opener().document.getElementById("title").value = $("#title").val()||"";    
			Dialog.opener().document.getElementById("picUrl").value = $("#picUrl").val()||"";    
			Dialog.opener().document.getElementById("digest").value = $("#digest").val()||"";    
			Dialog.opener().document.getElementById("createTime").value = $("#createTime").val()||"";    
			Dialog.opener().document.getElementById("typeId").value = $("#typeId").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "contentBean.title":{            
			        CNRangeLength:[0,255]
			    },                              
			    "contentBean.picUrl":{            
			        CNRangeLength:[0,255]
			    },                              
			    "contentBean.digest":{            
			        CNRangeLength:[0,255]
			    },                              
			    "contentBean.createTime":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "contentBean.typeId":{            
			        number:true,range:[0,9999999999]
			    }                              
			},                                  
			messages:{                          
//			    "contentBean.code":{          
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
                            标题<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.title" id="title"  value="${contentBean.title}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            图片地址<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.picUrl" id="picUrl"  value="${contentBean.picUrl}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            摘要<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.digest" id="digest"  value="${contentBean.digest}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            创建时间<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.createTime" id="createTime"  value="${contentBean.createTime}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            类型<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.typeId" id="typeId"  value="${contentBean.typeId}" class="GF-field"/>   
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
