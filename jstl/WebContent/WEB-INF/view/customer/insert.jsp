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

<form action="<%=root %>/customer/insert">
	고객명<input type="text" name="customerName"><br>
	도시<input type="text" name="city"><br>
	나라<input type="text" name="country"><br>	
	
<input type="submit" value="Register">
</form>

</body>
</html>