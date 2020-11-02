<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<div class="card">
	<div class="card-header">
		<strong>
			<i class="fas fa-address-card"></i>Address List
		</strong>
		<div class="text-right">
			<a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="addForm('address')" title="Add New Address">
				<i class="fas fa-address-card"></i>New
			</a>
			<a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="refresh('address')" title="Refresh Address">
				<i class="fas fa-address-card"></i>Refresh
			</a>
		</div>
	</div>
	<div class="card-body">
		<table
			class="table table-border table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>Country</th>
					<th>State</th>
					<th>City</th>
					<th>Line</th>
					<th>PinCode</th>
					<th>User</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="address" items="${addresses }">
					<tr>
						<td>${address.country }</td>
						<td>${address.state }</td>
						<td>${address.city }</td>
						<td>${address.addressLine }</td>
						<td>${address.pinCode }</td>
						<td>${address.user.userName }</td>
						<td>
							<a href="javascript:void(0);" onclick="editForm('address', '${address.id}')">
								<i class="fas fa-edit"></i>
							</a>
						</td>
						<td>
							<a href="javascript:void(0);" onclick="deleteData('address', '${address.id}')">
							 	<i class="fas fa-trash-alt"></i>
							</a>
					    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

