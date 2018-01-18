<%@page import="java.util.List"%>
<%@page import="com.iot.test.vo.Customer"%>
<%@page import="java.util.ArrayList"%>
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


%>
<br>고객리스트<br>
<table border="1" cellspacing="0" cellpadding="0">
	<tr>
		<th><a href="${root}/view/customer/list?target=customerid&orderStr=${orderStr}">CustomerID</a></th>
		<th><a href="${root}/view/customer/list?target=customername&orderStr=${orderStr}">CustomerName</a></th>
		<th><a href="${root}/view/customer/list?target=city&orderStr=${orderStr}">City</a></th>
		<th><a href="${root}/view/customer/list?target=country&orderStr=${orderStr}">Country</a></th>		
	</tr>
	<c:if test="${customerList eq null }">
		<tr>
			<td colspan="4" align="center">고객리스트가 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach items="${customerList}" var="customer">
		<tr>
			<td>${customer.customerId }</td>
			<td>${customer.customerName}</td>
			<td>${customer.city }</td>
			<td>${customer.country }</td>
		</tr>	
	</c:forEach>	
</table>
<form action="<%=root %>/view/customer/search" onsubmit="return checkValue()">
	<select name="searchType" id="searchType">
		<option value="">선택</option>
		<option value="customerId"${param.searchType eq 'customerId' ? 'selected' : "" }>번호</option>
		<option value="customerName"${param.searchType eq 'customerName' ? 'selected' : "" }>이름</option>
		<option value="city"${param.searchType eq 'city' ? 'selected' : "" }>도시</option>
		<option value="country"${param.searchType eq 'country' ? 'selected' : "" }>나라</option>
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