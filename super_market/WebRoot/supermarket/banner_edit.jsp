<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<%@ include file="/common/taglibs.jsp" %>  
<%
  	String path = request.getContextPath();
  %>                                       
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>                                   
<title></title> 
	<link rel="stylesheet" href="<%=path %>/zyupload/skins/zyupload-1.0.0.css " type="text/css">
	<script type="text/javascript" src="<%=path %>/zyupload/zyupload-1.0.0.js"></script>           
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
				'uploader' : '<%=request.getContextPath()%>/supermarket/Banner!importFile.action',
				'onUploadSuccess' : function(file, data, response) {
					$("#pic").html("<img src='/supermarket_images/banner/"+data+"' style='width:300px;height:100px;'/>");
					$("#filename").val(data);
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
					url              :   "<%=request.getContextPath()%>/supermarket/Banner!importFile.action",  // 上传文件的路径
					fileType         :   ["jpg","png"],// 上传文件的类型
					fileSize         :   51200000,                // 上传文件的大小
					multiple         :   false,                    // 是否可以多个文件上传
					dragDrop         :   false,                   // 是否可以拖动上传文件
					tailor           :   false,                   // 是否可以裁剪图片
					del              :   true,                    // 是否可以删除文件
					finishDel        :   false,  				  // 是否在上传文件完成后删除预览
					max              :   1,

        <s:if test="#request.oper==1">
                     first           :   [{name:"/supermarket_images/banner/${bannerBean.filename }",type:"image/jpeg"}],</s:if>  
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
						 url : '<%=request.getContextPath()%>/supermarket/Banner!removeFile.action',
								data : {
									"fileName" :   (file.name.lastIndexOf("/")!=-1?file.name.substring(file.name.lastIndexOf("/")):file.name)
								},
								success : function(data) {
									if (data) {
										$("#filename").val("");
										Dialog.alert("删除成功！");
									} else {
										Dialog.alert("删除失败！");
									}
								}
							});
					},
					onSuccess: function(file, response){          // 文件上传成功的回调方法
						Dialog.alert("上传成功！");
					$("#filename").val(response);
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
    	<td><div id="zyupload" class="zyupload"></div><input type="file" name="file" id="file" /></td>                     
  </tr>  
  <tr id= "no-ie"> 
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
