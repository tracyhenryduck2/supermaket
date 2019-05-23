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
			Dialog.opener().document.getElementById("marketId").value = $("#marketId").val()||"";    
			Dialog.opener().document.getElementById("title").value = $("#title").val()||"";    
			Dialog.opener().document.getElementById("picUrl").value = $("#picUrl").val()||"";    
			Dialog.opener().document.getElementById("digest").value = $("#digest").val()||"";    
			Dialog.opener().document.getElementById("content").value = $("#content").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "marketNewsBean.marketId":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "marketNewsBean.title":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketNewsBean.picUrl":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketNewsBean.digest":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketNewsBean.content":{            
			        CNRangeLength:[0,65535]
			    }                              
			},                                  
			messages:{                          
//			    "marketNewsBean.code":{          
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
                            marketId<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketNewsBean.marketId" id="marketId"  value="${marketNewsBean.marketId}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            标题<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketNewsBean.title" id="title"  value="${marketNewsBean.title}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            图片地址<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketNewsBean.picUrl" id="picUrl"  value="${marketNewsBean.picUrl}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            摘要<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketNewsBean.digest" id="digest"  value="${marketNewsBean.digest}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            内容<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketNewsBean.content" id="content"  value="${marketNewsBean.content}" class="GF-field"/>   
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
