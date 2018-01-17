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
<script>


</script>






<body>
<%
//String root = request.getContextPath();
List<UserInfo> userList = (List<UserInfo>) request.getAttribute("userList");
String str = (String) request.getAttribute("String");
if(str == null){
	str = "";	
}
%>

<br>유저리스트<br>


<table border='1'>
	<tr>
		<th>이름</th>
		<th>나이</th>
		<th>ID</th>
		<th>주소</th>
	</tr>
	<c:forEach items="${userList}" var="ui">	
	<tr>
		<td>${ui.uiName }</td>
		<td>${ui.uiAge }</td>
		<td>${ui.uiId }</td>
		<td>${ui.address }</td>			
	</tr>
	</c:forEach>
</table>

<form action="<%=root %>/view/user/search" onsubmit="return checkValue()">
	<select name="searchType">
		<option value="">선택</option>
		<option value="uiName">이름</option>
		<option value="uiAge">나이</option>
		<option value="uiId">아이디</option>
		<option value="address">주소</option>
	</select>
	<input type="text" name="searchStr" value="<%=str%>"><input type="submit" value="검색">
</form>




</body>
</html>