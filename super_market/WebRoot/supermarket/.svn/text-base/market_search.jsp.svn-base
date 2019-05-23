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
			Dialog.opener().document.getElementById("name").value = $("#name").val()||"";    
			Dialog.opener().document.getElementById("rank").value = $("#rank").val()||"";    
			Dialog.opener().document.getElementById("headPic").value = $("#headPic").val()||"";    
			Dialog.opener().document.getElementById("info").value = $("#info").val()||"";    
			Dialog.opener().document.form1.submit();                     
			ownerDialog.close();
	}                                       
	                                        
	                                        
	$(function(){                           
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "marketBean.name":{            
			        CNRangeLength:[0,255]
			    },                              
			    "marketBean.rank":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "marketBean.headPic":{            
			        number:true,range:[0,9999999999]
			    },                              
			    "marketBean.info":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "marketBean.code":{          
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
                            名称<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketBean.name" id="name"  value="${marketBean.name}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            排名<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketBean.rank" id="rank"  value="${marketBean.rank}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            图片<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketBean.headPic" id="headPic"  value="${marketBean.headPic}" class="GF-field"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" width="30%" > 
                            描述<span class="mark"></span>   
        </td>                            
        <td>                             
            <input type="text" name="marketBean.info" id="info"  value="${marketBean.info}" class="GF-field"/>   
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
