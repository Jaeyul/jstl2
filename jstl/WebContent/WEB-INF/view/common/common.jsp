<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String root = request.getContextPath();
%>

<c:set var="root" value="<%=root%>" />
<c:forEach items="${menuList}" var="menu">
	<a href="${root }${menu.mUrl}">${menu.mName}</a>
</c:forEach>



