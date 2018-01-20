<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String root = request.getContextPath();
%>
<script src="<%=root%>/ui/js/jquery-3.2.1.js"></script>

<c:set var="root" value="<%=root%>" />


<c:forEach items="${menuList}" var="menu">
	<c:choose>	         
		<c:when test = "${menu.mName eq 'MenuList'}">		
		</c:when>		
		<c:otherwise>
			<a href="${root}${menu.mUrl}">${menu.mName}</a> 
		</c:otherwise>
	</c:choose>
</c:forEach>



