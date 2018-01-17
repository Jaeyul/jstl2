<%@page import="java.util.List"%>
<%@page import="com.iot.test.vo.ClassInfo"%>
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
// String root = request.getContextPath();
List<ClassInfo> classList = (List<ClassInfo>) request.getAttribute("classList");
String str = (String) request.getAttribute("String");
if(str == null){
	str = "";	
}

%>

<br>클래스리스트<br>


<table border='1'>
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<c:forEach items="${classList}" var="ci">	
	<tr>
		<td>${ci.ciName }</td>
		<td>${ci.ciDesc }</td>		
	</tr>
	</c:forEach>
</table>

<form action="<%=root %>/view/class/search">
	<input type="text" id=search  name="param" value="<%=str%>"><input type="submit" value="검색" >	
</form>
</body>




</html>