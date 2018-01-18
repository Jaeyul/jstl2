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
/* String str = (String) request.getAttribute("String");
if(str == null){
	str = "";	
} */

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

<form action="<%=root %>/view/class/search" onsubmit="return checkValue()">
	<select name="searchType" id="searchType">
		<option value="">선택</option>
		<option value="ciName"${param.searchType eq 'ciName' ? 'selected' : "" }>반이름</option>
		<option value="ciDesc"${param.searchType eq 'ciDesc' ? 'selected' : "" }>상세정보</option>	
	</select>
	<input type="text" id=searchStr  name="searchStr" value="${String }"><input type="submit" value="검색" >	
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