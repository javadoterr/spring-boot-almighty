<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css">
<link rel="stylesheet" href="${path }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">

<script type="text/javascript" src="${path }/webjars/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${path}/js/jquery.boot.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<title>welcome</title>
<style type="text/css">
	.sidebar {
		margin-top: 0px;
		height: 100%;
		width:200px;
		position: fixed;
		background-color: #f8f8f8;
		z-index: 1;
	}
	.sidebar a {
		padding: 10px 8px 10px 16px;
		width: 100%;
		display: block;
		border-bottom: 1px solid #e7e7e7;
	}
	.main {
		margin-left: 200px;
	}
	.footer {
		margin-left:200px;
		position: fixed;
		bottom: 0;
		width: 100%;
		height: 60px;
		line-height: 60px;
		background-color: #f8f8f8;
	}
</style>
</head>
<body>
	<c:if test="${pageContext.request.userPrincipal.name != null }">
		<form action="${path }/logout" id="logoutForm" method="post">
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
		</form>
	</c:if>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="javascript:void(0);">ABCTECH</a>
			<div class="collapse navbar-collapse">
				 <ul class="navbar-nav mr-auto">
				 	<li class="nav-item active">
        				<a class="nav-link" href="${path}"><i class="fas fa-home"></i>Home</a>
      				</li>
      				<li class="nav-item">
        				<a class="nav-link" href="javascript:void(0)"><i class="fas fa-info-circle"></i>About</a>
      				</li>
      				<li class="nav-item">
        				<a class="nav-link" href="javascript:void(0)"><i class="fas fa-phone-square-alt"></i>Contact</a>
      				</li>
				 </ul>
				 <ul class="navbar-nav ml-auto">
				 	<li class="nav-item">
        				<a class="nav-link" href="javascript:void(0)" onclick="document.forms['logoutForm'].submit()">Welcome ${pageContext.request.userPrincipal.name } | <i class="fas fa-sign-out-alt"></i>Logout</a>
      				</li>
				 </ul>
			</div>
		</div>
	</nav>
	<div class="sidebar">
		<a href="javascript:void(0);" id="userList"><i class="fas fa-user"></i>User List</a>
		<a href="javascript:void(0);" id="addressList"><i class="fas fa-address-card"></i>Address List</a>
	</div>
	<div class="main">
		<div class="card">
			<div class="inner-jsp card-body">
				<c:forEach begin="0" end="2" varStatus="loop">
					<h3>${heading}</h3>
					<p class="text-justify">${description }</p>
				</c:forEach>
			</div>
		</div>
	</div>
	<footer class="footer">
		<div class="container">
			<p>© 2020-2021, All Rights Reserved by lbs</p>
		</div>
	</footer>
	
	<%-- <p><a href="${path}/user/list">User List</a></p>
	<p><a href="${path}/user/form">Add User</a></p>
	<p><a href="${path}/address/list">Address List</a></p>
	<p><a href="${path}/address/form">Add Address</a></p> --%>
	
</body>
</html>