<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>问卷管理系统</title>
		<link type="text/css" rel="stylesheet" href="../css/question.css">
		<script type="text/javascript">
		function newQues(){
			Dialog.open({Title:"新增", Width:600, Height:360, URL:"<%=path%>/supermarket/Survey!toNewQues.action?surveyBean.id=${surveyBean.id}"});   
		}
		function delQues(questionId){
			$("#questionId").val(questionId)
			Dialog.confirm("确定删除吗", function(){     
				var action_tmp = form1.action; 
				form1.action = "<%=path%>/supermarket/Survey!delQuestion.action";
				form1.target = "fram";
				form1.submit();  
				form1.action = action_tmp;     
				form1.target = "";    
			}, function(){     
				//�?      
			});  
		}
		function editQues(questionId){
			Dialog.open({Title:"编辑", Width:600, Height:360, URL:"<%=path%>/supermarket/Survey!toNewQues.action?oper=1&surveyBean.id=${surveyBean.id}"+"&questionId="+questionId}); 
		}
		function result(type, message) {   
			if("reload_success" == type) { 
				Dialog.alert(message,function(){      
					form1.submit();
				});
			} else if("error" == type) {   
				Dialog.error(message);  
			}    
		}  
		</script>
	</head>
	<body>
		<form action="<%=path%>/supermarket/Survey!toAddSurveyQuestion.action" name="form1" id="form1" method="get">  
		<input type="hidden" name="questionId" id="questionId" value=""/>
		<input type="hidden" name="surveyBean.id"  value="${surveyBean.id}"/> 
		<table class="table">
			<tbody>
				<s:iterator value="#request.questionList" id="map">
					<tr>
						<td colspan="5">
							<table class="table2">
								<tbody>
									<tr>
										<td bgcolor="#CDE2FD" colspan="4">
											<span id="title2">${map.sort_id}.${map.content }</span>
											<br>
										</td>
									</tr>
									<tr>
										<td>
											<table class="table2">
												<tbody>
													<s:if test="#request.map.type==0">
														<s:iterator value="#map.answerList" id="m">
															<tr>
																<td width="25%" valign="top">
																	<input type="radio" name="radio">
																	${m.content }
																</td>
															</tr>
														</s:iterator>
													</s:if>
													<s:else>
														<tr>
																<td>
																	<textarea rows="5" style="background-color:#ddd;" cols="70"></textarea>
																</td>
														</tr>
													</s:else>
													<tr>
														<td>
															<br>
															<a href="#" onclick="editQues(${map.id })">编辑题目</a>
															<a href="#" onclick="delQues(${map.id })">删除题目</a>
															<br>
														</td>
													</tr>
												</tbody>
											</table>
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
				</s:iterator>
				<tr>
					<td height="10">
						<span> <input type="button" name="sbmQues"
								onclick="newQues();" value=" 新建题目 "> </span>
					</td>
				</tr>
			</tbody>
		</table>
		</form>
		<iframe name="fram" id="fram" style="display:none"></iframe> 
	</body>
</html>
