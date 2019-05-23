<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>问卷管理系统</title>
		<link type="text/css" rel="stylesheet" href="../css/question.css">
<script type="text/javascript">
var textNumber = 1;
$(function(){
	var myTable = document.getElementById("myTable");
	var rowCnt = myTable.rows.length;
	textNumber=rowCnt-4;
	changeQuestion();
});
function addTextBox() {
	textNumber++;
	var str="<tr>"
			+"	<td valign=\"top\">"
			+"		<label>"
			+"			选项"+textNumber+"："
			+"		</label>"
			+"	</td>"
			+"	<td>"
			+"		<input type=\"text\" name=\"txt\" id=\"txt"+textNumber+"\" style=\"width: 260px;\">"
			+"	</td>"
			+"</tr>"
	$("#btn").before(str);		
}
function removeTextBox() {
	if(textNumber>1){
	$("#txt"+textNumber).parent().parent().remove();
	textNumber--;
	}
}
function save() {
    if($.trim($("#content").val()) == "") {
        Dialog.alert("请填写题目");
        return;
    }
    if($("#type").val()==0 && $.trim($("#txt1").val())==""){
    	Dialog.alert("请填写选 ‘择项1’");
    	return ;
    }
    form1.submit();
}
function changeQuestion() {
	if($("#type").val()==0)
	{
		$(".selectQuestion").css("display","");
	}
	else
	{
		$(".selectQuestion").css("display","none");
	}
}
function result(messageType, message) {
    if (messageType == "error") {
        Dialog.error(message);
    } else if (messageType == "reload_success") {
        Dialog.alert(message,
        function() {
            Dialog.opener().location.reload();
            parentDialog.close();
        });
    } else if (messageType == "exception") {

}
}
	
</script>
	</head>
	<body>
		<form name="form1" id="form1" action="<%=path%>/supermarket/Survey!newQues.action" method="post" target="fram" >   
			<input type="hidden" name="surveyBean.id" value="${surveyBean.id }"/>
			<input type="hidden" name="questionId" id="questionId" value="${questionId }"/>
			<input type="hidden" name="oper" value="${oper}"/>
			<table width="500" border="0" align="center" cellpadding="2"
				cellspacing="1" id="myTable" class="tab">
				<tbody>
					<tr>
						<td width="60px">
							题目类型：
						</td>
						<td>
							 <s:select list="#{0:'选择题',1:'问答题'}" onchange="changeQuestion();"  cssClass="GF-field" name="type" id="type"   theme="simple" listKey="key" listValue="value"  value="#request.type" ></s:select>
						</td>
					</tr>
					<tr>
						<td width="60px">
							题目内容：
						</td>
						<td>
							<input type="text" id="content" name="content" value="${content }" style="width: 400px;">
						</td>
					</tr>
					<s:if test="#request.oper==1&&#request.type==0">
					<s:iterator value="#request.answerList" id="map">
					<tr  class="selectQuestion">
						<td valign="top">
							<label>
								选项${map.sort_id }：
							</label>
						</td>
						<td>
							<input type="text" name="txt" id="txt${map.sort_id}" value="${map.content }" style="width: 260px;">
						</td>
					</tr>
					</s:iterator>
					</s:if>
					<s:else>
					<tr class="selectQuestion">
						<td valign="top">
							<label>
								选项1：
							</label>
						</td>
						<td>
							<input type="text" name="txt" id="txt1" style="width: 260px;">
						</td>
					</tr>
					</s:else>
					<tr id="btn" class="selectQuestion">
						<td></td>
						<td>
						<input type="button" value="添加选项 " name="add"
								onclick="addTextBox()" class="btn">
						<input type="button" value="删除选项 "
								onclick="removeTextBox()" class="btn">
						</td>
					</tr>
					<tr> 
						<td></td>                               
  					</tr>
					<tr> 
						<td></td>                               
     					<td><input type="button" name="提交" value="提交" onclick="save();" class="GF-btn"/></td>		
  					</tr>
				</tbody>
			</table>
			<iframe name="fram" id="fram" style="display:none"></iframe>
		</form>

	</body>
</html>