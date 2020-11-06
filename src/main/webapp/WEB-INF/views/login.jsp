<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><spring:message code="title.login.page" /></title>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA==" crossorigin="anonymous" />
		<link rel="stylesheet" href="${path }/webjars/bootstrap/4.1.3/css/bootstrap.min.css">
		<style type="text/css">
			body {
				background: url("https://www.hubmaldives.com/wp-content/uploads/2019/11/simple-background-color-has-web-page-background-color.jpg") no-repeat center center fixed;
				background-size:cover;
				display: flex;
				align-items: center;
				height: 100vh;
			}
		</style>
	</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 offset-4">
				<div class="card">
					<div class="card-header">
						<strong><spring:message code="label.login.header" /></strong>
					</div>
					<div class="card-body">
						<form action="${path }/user/login" method="post" class="form-signin form-horizantal">
							<c:if test="${error != null}">
								<div class="alert alert-danger">
									<strong>${error}</strong>
								</div>
							</c:if>
							<c:if test="${message != null}">
								<div class="alert alert-success">
									<strong>${message }</strong>
								</div>
							</c:if>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fas fa-user"></i>
											</div>
										</div>
										<spring:message code="placeholder.username" var="usernamePlaceholder" />
										<input type="text" class="form-control" name="username" placeholder="${usernamePlaceholder }">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fas fa-lock"></i>
											</div>
										</div>
										<spring:message code="placeholder.password" var="passwordPlaceholder" />
										<input type="password" class="form-control" name="password" placeholder="${passwordPlaceholder }">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="checkbox">
										<label> <input type="checkbox" name="remember-me" id="remember-me"> <spring:message code="label.remember.me" />
										</label>
									</div>
								</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token }">
							<div class="form-group">
								<div class="col-md-12">
									<button type="submit" class="btn btn-default btn-block">
										<i class="fas fa-sign-in-alt"></i> <spring:message code="label.button.login" />
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>