<%@page import="com.iot.test.vo.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/view/common/common.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>



<body>
<%
/* String root = request.getContextPath();
List<UserInfo> userList = (List<UserInfo>) request.getAttribute("userList");
String str = (String) request.getAttribute("String");
if(str == null){
	str = "";	
} */
%>

<br>유저리스트<br>


  	
<table border='1'>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>ID</th>
		<th>주소</th>			
		<th>가입일시</th>
		<th>설정</th>
	</tr>		
	
	
	<c:forEach items="${userList}" var="ui">
	<form action="<%=root %>/user/revise">
	<tr>	
		<td><input type="text" value="${ui.uiNo }" id="uiNo" name="uiNo"></td>
		<td><input type="text" value="${ui.uiName }" id="uiName" name="uiName"></td>		
		<td><input type="text" value="${ui.uiAge }" id="uiAge" name="uiAge"></td>
		<td><input type="text" value="${ui.uiId }" id="uiId" name="uiId"></td>
		<td><input type="text" value="${ui.address }" id="address" name="address"></td>			
		<td>${ui.uiRegdate }</td>	
		<td><input type="submit" name="catch" value="update"><input type="submit" name="catch" value="delete"></td>	
	</tr>
	<input type="hidden" name="catchValue" value="${uiNo },${uiName},${uiAge},${uiId},${address}">
	<input type="hidden" name="catchType" value="uiNo,uiName,uiAge,uiId,address">
	</form>	
	</c:forEach>	
	
	
</table>

 	





<form action="<%=root %>/view/user/search" onsubmit="return checkValue()">
	<select name="searchType" id="searchType">
		<option value="">선택</option>
		<option value="uiName"${param.searchType eq 'uiName' ? 'selected' : "" }>이름</option>
		<option value="uiAge"${param.searchType eq 'uiAge' ? 'selected' : "" }>나이</option>
		<option value="uiId"${param.searchType eq 'uiId' ? 'selected' : "" }>아이디</option>
		<option value="address"${param.searchType eq 'address' ? 'selected' : "" }>주소</option>
	</select>
	<input type="text" id="searchStr" name="searchStr" value="${String}"><input type="submit" value="검색">
</form>




</body>

<script>
function checkValue(){
	var sBox = document.getElementById("searchType").value;
	if(sBox.length == 0){
		alert("체크박스를 선택해주세요!");		
		return false;		
	}	
	return true;	
}
</script>


</html>