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

<form action="<%=root %>/user/insert">
	이름<input type="text" name=uiName><br>
	나이<input type="text" name=uiAge><br>
	아이디<input type="text" name=uiId><br>
	비밀번호<input type="text" name=uiPwd><br>
	주소<input type="text" name=address><br>
	반<select name="ciNo">
		<c:forEach items="${classList }" var="ci">
			<option value="${ci.ciNo }">${ci.ciName }</option>
		</c:forEach>	
	</select><br>
<input type="submit" value="Sign-up">

</form>

</body>
</html>