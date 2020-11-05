<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="card">
	<div class="card-header">
		<strong> <i class="fas fa-user"></i>User List
		</strong>
		<div class="text-right">
			<a href="javascript:void(0);" class="btn btn-default btn-sm"
				onclick="addForm('user')" title="Add New User"> <i
				class="fas fa-user"></i>New
			</a> <a href="javascript:void(0);" class="btn btn-default btn-sm"
				onclick="refresh('user')" title="Refresh User"> <i
				class="fas fa-user"></i>Refresh
			</a>
		</div>
	</div>
	<div class="card-body">
		<table
			class="table table-border table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>User Id</th>
					<th>Full Name</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Mobile</th>
					<th>Role</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${users.size() > 0 }">
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.userId }</td>
								<td>${user.fullName }</td>
								<td>${user.userName }</td>
								<td>${user.email }</td>
								<td>${user.mobile }</td>
								<td>${user.role.name }</td>
								<td><a href="javascript:void(0);" onclick="editForm('user', '${user.id}')"><i class="fas fa-edit"></i></a></td>
								<td><a href="javascript:void(0);" onclick="deleteData('user', '${user.id}')"><i class="fas fa-trash-alt"></i></a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr align="center">
							<td colspan="8">No Users available</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
	<c:if test="${users.size() > 0 }">
		<div class="card-footer">
			Showing ${number + 1 } to ${size } of ${totalElements }
			<ul class="pagination text-right" style="margin: -7px;">
				<c:choose>
					<c:when test="${current == 1 }">
						<li class="disabled"><a href="javascript:void(0);">First</a></li>
						<li class="disabled"><a href="javascript:void(0);">Prev</a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a href="javascript:void(0);" onclick="list('user', 1)">First</a></li>
						<li class="disabled"><a href="javascript:void(0);" onclick="list('user', '${current - 1}')">Prev</a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${begin }" end="${end }" var="i">
					<c:choose>
						<c:when test="${i == current }">
							<li class="active"><a href="javascript:void(0);" onclick="list('user', '${i}')">${i}</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="javascript:void(0);" onclick="list('user', '${i}')">${i}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${current == totalPages }">
						<li class="disabled"><a href="javascript:void(0);">Next</a></li>
						<li class="disabled"><a href="javascript:void(0);">Last</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="javascript:void(0);" onclick="list('user', '${current + 1}')">Next</a></li>
						<li><a href="javascript:void(0);" onclick="list('user', '${totalPages}')">Last</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</c:if>
</div>

