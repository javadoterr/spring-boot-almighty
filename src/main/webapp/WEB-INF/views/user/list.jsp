<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="card">
	<div class="card-header">
		<strong>
			<i class="fas fa-user"></i>User List
		</strong>
		<div class="text-right">
			<a href="javascript:void(0);" onclick="addForm('user')">
				<i class="fas fa-user"></i>New User
			</a>
		</div>
	</div>
	<div class="card-body">
		<table
			class="table table-border table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>User Id</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${users}">
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.password }</td>
						<td>${user.role.name }</td>
						<td>
							<a href="javascript:void(0);" onclick="editForm('user', '${user.id}')">
								<i class="fas fa-edit"></i>
							</a>
						</td>
						<td>
							<a href="javascript:void(0);" onclick="deleteData('user', '${user.id}')">
								<i class="fas fa-trash-alt"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

