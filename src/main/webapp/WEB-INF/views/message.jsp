<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
	<!-- to check the user is loging or who is this user type -->
	<c:if test="${pageContext.request.userPrincipal.name != null }">
		<form action="${path }/logout" id="logoutForm" method="post">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		</form>
	</c:if>
	<p>Welcome ${pageContext.request.userPrincipal.name != null } | <a onclick="document.forms['logoutForm'].submit()"></a></p>
	<p>${message }</p>
	<p><a href="${path}/user/list">User List</a></p>
	<p><a href="${path}/user/form">Add User</a></p>
	<p><a href="${path}/address/list">Address List</a></p>
	<p><a href="${path}/address/form">Add Address</a></p>
</body>
</html>