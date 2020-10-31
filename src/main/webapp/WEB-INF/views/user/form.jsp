<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${path}/js/jquery.save.js"></script>
<div class="card">
	<div class="card-header">
		<strong>
			<i class="fas fa-user"></i>New User
		</strong>	
	</div>
	<form:form action="${path}/user/add" class="form-horizontal" method="post" modelAttribute="userForm" id="submitUserForm">
		<div class="card-body">
			<form:hidden path="id"/>
			<div class="input-group my-1">
				<label class="col-md-2 control-label">User Id :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="userId" placeholder="Enter User Id" required="true"/>
				</div>
			</div>
			<div class="input-group my-1">
				<label class="col-md-2 control-label">Full Name :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="fullName" placeholder="Enter User fullName" required="true"/>
				</div>
				<label class="col-md-2 control-label">User Name :</label>
				<div class="col-md-4">
					 <form:input class="form-control" path="userName" placeholder="Enter User Name" required="true"/>
				</div>
			</div>
			<div class="input-group my-1">
				<label class="col-md-2 control-label">Email :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="email" placeholder="Enter User email" required="true"/>
				</div>
				<label class="col-md-2 control-label">Mobile :</label>
				<div class="col-md-4">
					 <form:input class="form-control" path="mobile" placeholder="Enter User mobile number" required="true"/>
				</div>
			</div>
			<div class="input-group">
				<label class="col-md-2 control-label">Password :</label>
				<div class="col-md-4">
					<form:input class="form-control" path="password" placeholder="Enter User password" required="true"/>
				</div>
				<label class="col-md-2 control-label">Role : </label>
				<div class="col-md-4">
					<form:select class="form-control" path="roleId">
						<c:forEach var="role" items="${roles}">
							<form:option value="${role.id }">${role.name }</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
		</div>
		<div class="card-footer">
			<form:button class="btn btn-xs btn-default" value="Save">
				<i class="far fa-save"></i>Save
			</form:button>
		</div>
	</form:form>
</div>

	<%-- <form:form action="${path}/user/add" method="post" modelAttribute="userForm">
		<form:hidden path="id"/>
		<p>User Id : <form:input path="userId" placeholder="Enter User Id"/></p>
		<p>User Name : <form:input path="userName" placeholder="Enter User Name"/></p>
		<p>Password : <form:input path="password" placeholder="Enter User password"/></p>
		<p>
			Role : 
			<form:select path="role.id">
				<c:forEach var="role" items="${roles}">
					<form:option value="${role.id }">${role.name }</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:button value="Save">Save</form:button>
			<a href="${path}/user/list">User List</a>
		</p>
	</form:form> --%>
