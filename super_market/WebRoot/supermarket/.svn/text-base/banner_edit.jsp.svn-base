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
	function save(){   
		if($("#filename").val()==null || $.trim($("#filename").val())=="") {
			Dialog.alert("请选择上传图片");	
			return;
		}
		if($("#form1").valid()) {
			form1.submit();                     
		}
	}                                       
	                                        
	function result(messageType, message){  
		if(messageType=="error"){           
			Dialog.error(message);				      
		} else if (messageType == "reload_success") {   
			Dialog.alert(message,function(){    
				Dialog.opener().location.reload(); 
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){ 
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			    "bannerBean.filename":{            
			        required : true,CNRangeLength:[0,45]
			    },                              
			    "bannerBean.url":{            
			        required : true,CNRangeLength:[0,200]
			    }                              
			},                                  
			messages:{                          
//			    "bannerBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		});
		setTimeout(function(){
			$('#file').uploadify({
				'fileObjName':'file',
				'buttonText':'选择文件',
				'method'   :'post',
				'multi'    :false,
				'queueSizeLimit' : 1,
				'auto'     :true,  
				'swf'      : '<%=path%>/js/uploadify/uploadify.swf?pp=1',
				'uploader' : '<%=request.getContextPath()%>/supermarket/Banner!importFile.action',
				'onUploadSuccess' : function(file, data, response) {
					$("#pic").html("<img src='/supermarket_images/banner/"+data+"' style='width:300px;height:100px;'/>");
					$("#filename").val(data);
			    }
			});
		},10);
		
	});                                     
	                                               
	function removeFile() {
	 	Dialog.confirm("确定删除附件吗？", function(){     
			$.ajax({
			 type :"post",
			 url : '<%=request.getContextPath()%>/supermarket/Banner!removeFile.action',
			 data : {"fileName":$("#filename").val()},
			success : function(data) {
				if(data)
				{
					$("#pic").html("");
					Dialog.alert("删除成功！");
					$("#filename").val("");
				}
				else
				{
					Dialog.alert("删除失败！");
				}				
			}
			});   
		}, function(){     
					//否      
		});  
 	}  
	
</script>                               
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path%>/supermarket/Banner!addBanner.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="bannerBean.id" id="id" value="${bannerBean.id }"/>  
<span style="display:none;">
<input type="hidden" name="bannerBean.filename" id="filename" value="${bannerBean.filename }"/>  
</span>
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr id="upload_pic" >
  		<td align="right"  width="20%" >上传图片</td>                                 
    	<td><input type="file" name="file" id="file" /></td>                     
  </tr>  
  <tr> 
  		<td align="right"  height="120" style="height:120px;">图片预览</td>                                     
    	<td valign="bottom">
    	<div id="pic">
	    	<s:if test="#request.bannerBean.filename!=null && #request.bannerBean.filename!=''">
	    		<img src='/supermarket_images/banner/${bannerBean.filename }' style="width:300px;height:100px;" />
	    	</s:if>
    	</div>
    	<input type="button" value="删除" onclick="removeFile()" class="GF-btn" />
    	</td>                     
  </tr>    
   <tr>                                    
    	<td align="right"> 
                            超链接<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="bannerBean.url" id="url"  value="${bannerBean.url}" class="GF-field" style="width:400px;"/>   
        </td>                            
  </tr>
  <tr>
  		<td align="right"> 
              	显示顺序<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="bannerBean.seqNo" id="seqNo"  value="${bannerBean.seqNo}" class="GF-field" style="width:400px;"/>   
        </td> 
  </tr> 
  <tr>
  	<td align="right">备注</td>
  	<td>图片大小建议为1920*500</td>
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
