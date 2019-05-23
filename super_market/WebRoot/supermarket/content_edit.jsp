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
			<link rel="stylesheet" href="<%=path %>/zyupload/skins/zyupload-1.0.0.css " type="text/css">
	<script type="text/javascript" src="<%=path %>/zyupload/zyupload-1.0.0.js"></script>   
		<style>
				.uploadify-button {
			    width: 12%;
			    height: 31px;
			    line-height: 31px;
			}
	</style>                      
<script type="text/javascript">  

	function result(messageType, message){  
		if(messageType=="error"){           
			Dialog.error(message);				      
		} else if (messageType == "reload_success") {   
			Dialog.alert(message,function(){    
				Dialog.opener().location.reload(); //;= "<%=path%>/system/News!list.action";   
				parentDialog.close();             
			});                                 
		} else if(messageType == "exception") { 
			                                    
		}                                     
	}                                       
	                                        
	$(function(){   
		
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="contentBean.content"]', {
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
						if($("#picUrl").val()==null || $("#picUrl").val()=="") {
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
			    "contentBean.typeId":{            
			        required : true,number:true,range:[0,9999999999]
			    },                              
			    "contentBean.title":{            
			        required : true,CNRangeLength:[0,600]
			    },                              
			    "contentBean.digest":{            
			        required : true,CNRangeLength:[0,600]
			    },                                                          
			    "contentBean.content":{ //CNRangeLength:[0,65535]            
			         
			    }                              
			},                                  
			messages:{                          
//			    "newsBean.code":{          
//				    required : "",CNRangeLength:""  
//			    },                            
			}                                   
		}); 
		
		setTimeout(function(){


   if(myBrowser()=="IE"){
   		$("#zyupload").css("display","none");
			$('#file').uploadify({
				'fileObjName':'file',
				'buttonText':'选择文件',
				'method'   :'post',
				'multi'    :false,
				'queueSizeLimit' : 1,
				'auto'     :true,  
				'swf'      : '<%=path%>/js/uploadify/uploadify.swf?pp=1',
				'uploader' : '<%=request.getContextPath()%>/supermarket/Content!importFile.action',
				'onUploadSuccess' : function(file, data, response) {
					$("#pic").html("<img src='/supermarket_images/news/"+data+"' style='width:100px;height:100px;'/>");
					$("#picUrl").val(data);
			    }
			});
   }else{
               				// 初始化插件
				//"js","exe","txt","xls","rar","zip","ppt","pdf","psd" 文件种类
				$("#no-ie").css("display","none");
				$("#file").css("display","none");
				$("#zyupload").zyUpload({
					width            :   "650px",                 // 宽度
					height           :   "200px",                 // 宽度
					itemWidth        :   "140px",                 // 文件项的宽度
					itemHeight       :   "115px",                 // 文件项的高度
					url              :   "<%=request.getContextPath()%>/supermarket/Content!importFile.action",  // 上传文件的路径
					fileType         :   ["jpg","png"],// 上传文件的类型
					fileSize         :   51200000,                // 上传文件的大小
					multiple         :   false,                    // 是否可以多个文件上传
					dragDrop         :   false,                   // 是否可以拖动上传文件
					tailor           :   false,                   // 是否可以裁剪图片
					del              :   true,                    // 是否可以删除文件
					finishDel        :   false,  				  // 是否在上传文件完成后删除预览
					max              :   1,

        <s:if test="#request.oper==1">
                     first           :   [{name:"/supermarket_images/news/${contentBean.picUrl }",type:"image/jpeg"}],</s:if>  
					 // first            :   "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515734134110&di=26d22186391706a2a5ff397d538d2851&imgtype=0&src=http%3A%2F%2Fpic4.nipic.com%2F20091217%2F3885730_124701000519_2.jpg",
					/* 外部获得的回调接口 */
					onSelect: function(selectFiles, allFiles){    // 选择文件的回调方法  selectFile:当前选中的文件  allFiles:还没上传的全部文件
						console.log("当前选择了以下文件：");
						console.log(selectFiles);
					},
					onDelete: function(file, files){              // 删除一个文件的回调方法 file:当前删除的文件  files:删除之后的文件
						console.log("当前删除了此文件：");
						console.log(file.name);
						$.ajax({
						 type :"post",
						 url : '<%=request.getContextPath()%>/supermarket/Content!removeFile.action',
								data : {
									"fileName" :   (file.name.lastIndexOf("/")!=-1?file.name.substring(file.name.lastIndexOf("/")):file.name)
								},
								success : function(data) {
									if (data) {
										$("#picUrl").val("");
										Dialog.alert("删除成功！");
									} else {
										Dialog.alert("删除失败！");
									}
								}
							});



					},
					onSuccess: function(file, response){          // 文件上传成功的回调方法
						Dialog.alert("上传成功！");
					$("#picUrl").val(response);
						// console.info("此文件上传成功：");
						// console.info(file.name);
						// console.info("此文件上传到服务器地址：");
						// console.info(response);
						// $("#uploadInf").append("<p>上传成功，文件地址是：" + response + "</p>");
					},
					onFailure: function(file, response){          // 文件上传失败的回调方法
						console.log("此文件上传失败：");
						console.log(file.name);
					},
					onComplete: function(response){           	  // 上传完成的回调方法
						console.log("文件上传完成");
						console.log(response);
					},
					onBeyondMax:function(max){
						Dialog.alert("文件只能上传"+max+"张！");
					}
				}); 
   }

			
							var up = $('#upload').Huploadify({
						auto:true,
						fileTypeExts:'*.*',
						multi:true,
						fileSizeLimit:99999999999,
						showUploadedPercent:true,
						showUploadedSize:true,
						removeTimeout:9999999,
						uploader : '<%=request.getContextPath()%>/supermarket/Content!importFile1.action',
						onUploadSuccess : function(file, data, response) {
							if(data!=null){
								$("#msg").html(data);
								}
									$("#fileUrl").val(data);
									Dialog.alert("上传成功！");
									$("#_del").hide();
									$("#_del1").show();
									
						    },
						    'onSWFReady': function() {
						    	if($("#baikeId").val()==""){
									$('#file').uploadify('disable',true);
								}
							}
						});
		},10);
	});                                    
	
	function removeFile() {
	 	Dialog.confirm("确定删除附件吗？", function(){     
		$.ajax({
		 type :"post",
		 url : '<%=request.getContextPath()%>/supermarket/Content!removeFile.action',
				data : {
					"fileName" : $("#picUrl").val()
				},
				success : function(data) {
					if (data) {
						$("#pic").html("");
						Dialog.alert("删除成功！");
						$("#picUrl").val("");
					} else {
						Dialog.alert("删除失败！");
					}
				}
			});
}, function() {
	//否      
});

	}
	
function removeFile1() {
	 	Dialog.confirm("确定删除附件吗？", function(){     
		$.ajax({
		 type :"post",
		 url : '<%=request.getContextPath()%>/supermarket/Content!removeFile.action',
				data : {
					"fileName" : $("#fileUrl").val()
				},
				success : function(data) {
                         $("#fileUrl").val("");

						if(data)
						{
							
							Dialog.alert("删除成功！");
							$("#_del1").hide();
							$("#_del").show();
						}
						else
						{
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
<form name="form1" id="form1" action="<%=path %>/supermarket/Content!addContent.action" method="post" target="fram">   
<input type="hidden" name="oper" value="${oper}" />
<input type="hidden" name="contentBean.id" id="id" value="${contentBean.id }"/>  
<span style="display:none;">
<input type="hidden" name="contentBean.picUrl" id="picUrl" value="${contentBean.picUrl }"/>
<input type="hidden" name="contentBean.fileUrl" id="fileUrl" value="${contentBean.fileUrl }"/>
</span>
<table cellpadding="0" cellspacing="0" width="100%" class="GF-grid"> 
  <tr>                                    
    	<td align="right" width="10%" > 
                            类型<span class="mark">*</span>   
        </td>                            
        <td>                             
            <s:select list="#request.typeList"  cssClass="GF-field" name="contentBean.typeId" id="typeId"   theme="simple" listKey="id" listValue="name"  value="#request.contentBean.typeId" ></s:select>
        </td>                            
  </tr>                                
  <tr id="upload_pic">  
  		<td align="right">上传简介图片</td>                                     
    	<td><div id="zyupload" class="zyupload"></div><input type="file" name="file" id="file" /><br/>建议图片大小200*200</td>                     
  </tr>  
  <tr id="no-ie">                                    
    	<td align="right">预览简介图片</td>   
    	<td>
    	<div id="pic">
    		<s:if test="#request.contentBean.picUrl!=null && #request.contentBean.picUrl!=''">
	    		<img src='/supermarket_images/news/${contentBean.picUrl }' style='width:100px;height:100px;'/>
	    	</s:if>
	    </div>
    	<input type="button" value="删除" onclick="removeFile()" class="GF-btn" /></td>                     
  </tr> 

  <tr>
    <td align="right">
						附件
						<span class="mark"></span>
					</td>
					<s:if test="#request.oper==1">
						<s:if test="#request.contentBean.fileUrl!=''">
							<td id="_del" style="display: none">
								<div id="upload"></div>
							</td>
							<td id="_del1">
								<span id="msg">${contentBean.fileUrl}</span>
								<input type="button" value="删除" onclick="removeFile1()"
									class="GF-btn" />
							</td>
						</s:if>
						<s:else>
							<td id="_del">
								<div id="upload"></div>
							</td>
							<td id="_del1" style="display: none">
								<span id="msg"></span>
								<input type="button" value="删除" onclick="removeFile1()"
									class="GF-btn" />
							</td>
						</s:else>
					</s:if>
					<s:else>
						<td id="_del">
							<div id="upload"></div>
						</td>
						<td id="_del1" style="display: none">
							<span id="msg"></span>
							<input type="button" value="删除" onclick="removeFile1()"
								class="GF-btn" />
						</td>
					</s:else>                         
  </tr>
                                        
  <tr>                                    
    	<td align="right" > 
                            标题<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.title" id="title"  value="${contentBean.title}" class="GF-field" style="width:800px"/>   
        </td>                            
  </tr>
  <tr>                                    
    	<td align="right" > 
                            简介<span class="mark">*</span>   
        </td>                            
        <td>                             
            <input type="text" name="contentBean.digest" id="digest"  value="${contentBean.digest}" class="GF-field" style="width:800px"/>   
        </td>                            
  </tr>                                
  <tr>                                    
    	<td align="right" > 
                            文本详情<span class="mark">*</span>   
        </td>                            
        <td>                             
        	<textarea cols="120" rows="16" style="width:800px;height:400px;visibility:hidden;" name="contentBean.content" id="content" >${contentBean.content}</textarea>
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
