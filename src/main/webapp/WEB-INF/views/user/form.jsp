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
				<c:if test="${userForm.id ne null }">
					<label class="col-md-2 control-label">Profile Picture :</label>
					<div class="col-md-4">
						<button type="button" class="btn btn-default" data-toggle="modal" data-target="#uploadModal">
							<i class="fas fa-arrow-circle-up"></i>Upload
						</button>
					</div>
				</c:if>
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
<c:if test="${userForm.id ne null }">
	<div id="uploadModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="uploadImage" class="form-horizontal" action="" method="post" enctype="multipart/form-data">
					<div class="modal-header">
						<h4 class="modal-title">Upload User Profile for ${userForm.fullName}</h4>
						<button type="button" class="close" data-dismiss="modal"><i class="fas fa-window-close"></i></button>
					</div>
					<div class="modal-body">
						<div class="input-group">
							<input type="hidden" name="editUserId" value="${userForm.id }">
							<label class="col-md-3 control-label">Upload File :</label>
							<div class="col-md-6">
								<input type="file" name="file" class="form-control">
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">Upload</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>