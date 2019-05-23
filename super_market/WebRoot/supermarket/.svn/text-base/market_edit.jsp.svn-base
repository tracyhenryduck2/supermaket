<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ include file="/common/taglibs.jsp" %>  
<%                                       
String path = request.getContextPath();  
%>                                       
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>                                   
<title></title>  
<link rel="stylesheet" href="<%=path %>/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="<%=path %>/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="<%=path %>/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="<%=path %>/kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="<%=path %>/kindeditor/plugins/code/prettify.js"></script>                                             
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
				Dialog.opener().location.reload(); //;= "<%=path%>/supermarket/MarketNews!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){ 
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="marketBean.info"]', {
				allowUpload : true,
				cssPath : '<%=path%>/kindeditor/plugins/code/prettify.css',
				uploadJson : "<%=path%>/kindeditor/jsp/upload_json.jsp?dirName=article",
				fileManagerJson : '<%=path%>/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				allowImageUpload : true,
				urlType:'relative',
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						if($("#fileUrl").val()==null || $("#fileUrl").val()=="") {
							Dialog.alert("请上传简介图片");
							return;
						}
						if($("#form1").valid()) {
							document.forms['form1'].submit();
						}
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						if($("#fileUrl").val()==null || $("#fileUrl").val()=="") {
							Dialog.alert("请上传简介图片");
							return;
						}
						if($("#form1").valid()) {
							document.forms['form1'].submit();
						}
					});
				}
			});
			prettyPrint();
			
			
		});                          
		/* form1表单进行验证 */               
		$("#form1").validate({              
			rules:{                             
			                                 
			    "marketBean.name":{            
			        CNRangeLength:[0,255]
			    }                              
			},                                  
			messages:{                          
//			    "marketNewsBean.code":{          
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
				'uploader' : '<%=request.getContextPath()%>/supermarket/Market!importFile.action',
				'onUploadSuccess' : function(file, data, response) {
					$("#pic").html("<img src='/supermarket_images/market/"+data+"' style='width:100px;height:100px;'/>");
					$("#fileUrl").val(data);
			    }
			});
		},10);


	});                                    
	
	function removeFile() {
	 	Dialog.confirm("确定删除附件吗？", function(){     
		$.ajax({
		 type :"post",
		 url : '<%=request.getContextPath()%>/supermarket/Market!removeFile.action',
				data : {
					"fileName" : $("#fileUrl").val()
				},
				success : function(data) {
					if (data) {
						$("#pic").html("");
						Dialog.alert("删除成功！");
						$("#fileUrl").val("");
					} else {
						Dialog.alert("删除失败！");
					}
				}
			});
}, function() {
	//否      
});                                        
}

                                   
</script>                                
</head>                                  
<body>                                   
<form name="form1" id="form1" action="<%=path %>/supermarket/Market!addMarket.action" method="post" target="fram" >   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="marketBean.id" id="id" value="${marketBean.id }"/>
<span style="display:none;"><input type="hidden" name="marketBean.headPic" id="fileUrl" value="${marketBean.headPic }"/></span>  
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="30%" > 
                            名称<span class="mark">*</span>   
        </td>                            
        <td> 
            <s:if test="#session.user.getRole()==1">${marketBean.name}</s:if>                         
            <input <s:if test="#session.user.getRole()==1">hidden</s:if> type="text" name="marketBean.name" id="name"  value="${marketBean.name}" class="GF-field" style="width:800px"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            排名<span class="mark"></span>   
        </td>                            
        <td>             
        	<s:if test="#session.user.getRole()==1">${marketBean.rank}</s:if>                 
            <input <s:if test="#session.user.getRole()==1">hidden</s:if> type="text" name="marketBean.rank" id="rank"  value="${marketBean.rank}" class="GF-field"/>   
        </td>                            
  </tr>
    <tr>                                    
    	<td align="right" > 
                          备注<span class="mark">*</span>   
        </td>                            
        <td>     
        	<s:if test="#session.user.getRole()==1">${marketBean.type}</s:if>                        
            <input <s:if test="#session.user.getRole()==1">hidden</s:if> type="text" name="marketBean.type" id="chaotype"  value="${marketBean.type}" class="GF-field" />
            &nbsp;&nbsp;&nbsp;&nbsp;<span>(填1:先进单位;填2:进步单位;填3:诫勉单位)</span>   
        </td>                            
  </tr>                                
  <tr>  <tr id="upload_pic">  
  		<td align="right">上传简介图片</td>                                     
    	<td><input type="file" name="file" id="file" /><br/>建议图片大小200*200</td>                     
  </tr>  
  <tr>                                    
    	<td align="right">预览简介图片</td>   
    	<td>
    	<div id="pic">
    		<s:if test="#request.marketBean.headPic!=null && #request.marketBean.headPic!=''">
	    		<img src='/supermarket_images/market/${marketBean.headPic }' style='width:100px;height:100px;'/>
	    	</s:if>
	    </div>
    	<input type="button" value="删除" onclick="removeFile()" class="GF-btn" /></td>                     
  </tr>                        
  <tr>                                    
    	<td align="right" > 
                            文本详情<span class="mark">*</span>   
        </td>                            
        <td>                             
        	<textarea cols="120" rows="16" style="width:800px;height:400px;visibility:hidden;" name="marketBean.info" id="content" >${marketBean.info}</textarea>
        </td>                            
  </tr>                                  
  <tr>                                
      <td>&nbsp;</td>		
      <td><input type="submit" name="提交" value="提交" class="GF-btn"/></td>		
  </tr>                                
</table>                                 
<iframe name="fram" id="fram" style="display:none"></iframe>   
</form>                                  
</body>                                  
</html>                                  
