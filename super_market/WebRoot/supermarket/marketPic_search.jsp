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
			Dialog.opener().document.getElementById("filename").value = $("#filename").val()||"";    
			Dialog.opener().document.getElementById("picUrl").value = $("#picUrl").val()||"";    
			Dialog.opener().document.getElementById("url").value = $("#url").val()||"";    
			Dialog.opener().document.getElementById("seqNo").value = $("#seqNo").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "marketPicBean.marketId":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "marketPicBean.filename":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketPicBean.picUrl":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketPicBean.url":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketPicBean.seqNo":{            
			        number:true,range:[0,9999999999]
			    }                              
			},                                  
			messages:{                          
//			    "marketPicBean.code":{          
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
            <input type="text" name="marketPicBean.marketId" id="marketId"  value="${marketPicBean.marketId}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            名称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketPicBean.filename" id="filename"  value="${marketPicBean.filename}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            图片地址<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketPicBean.picUrl" id="picUrl"  value="${marketPicBean.picUrl}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            链接地址<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketPicBean.url" id="url"  value="${marketPicBean.url}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            排序<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketPicBean.seqNo" id="seqNo"  value="${marketPicBean.seqNo}" class="GF-field"/>   
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
