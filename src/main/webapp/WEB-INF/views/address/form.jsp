<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<script type="text/javascript" src="${path}/js/jquery.save.js"></script>
<div class="card">
	<div class="card-header">
		<strong>
			<i class="fas fa-address-card"></i>New Address
		</strong>
	</div>
<form:form action="${path}/address/add" class="form-horizontal" method="post" modelAttribute="addressForm" id="submitAddressForm">
	<form:hidden path="id"/>
	<div class="card-body">
		<div class="input-group my-1">
			<label class="col-md-2 control-label">AddressLine :</label>
			<div class="col-md-10">
				<form:textarea class="form-control" path="addressLine" placeholder="Enter street, landmark and other details" required="true"/>
			</div>
		</div>
		<div class="input-group my-1">
			<label class="col-md-2 control-label">Country :</label>
			<div class="col-md-4">
				<form:input class="form-control" path="country" placeholder="Enter country" required="true"/>
			</div>
			<label class="col-md-2 control-label">State :</label>
			<div class="col-md-4">
				<form:input class="form-control" path="state" placeholder="Enter state" required="true"/>
			</div>
		</div>
		<div class="input-group">
			<label class="col-md-2 control-label">City :</label>
			<div class="col-md-4">
				<form:input class="form-control" path="city" placeholder="Enter city" required="true"/>
			</div>
			<label class="col-md-2 control-label">User :</label>
			<div class="col-md-4">
				<form:select class="form-control" path="userId">
					<c:forEach var="user" items="${users}">
						<form:option value="${user.id }">${user.userName }</form:option>
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
	<%-- <form:form action="${path}/address/add" method="post" modelAttribute="addressForm">
		<form:hidden path="id"/>
		<p>Country : <form:input path="country" placeholder="Enter country"/></p>
		<p>State : <form:input path="state" placeholder="Enter state"/></p>
		<p>City : <form:input path="city" placeholder="Enter city"/></p>
		<p>
			User :
			<form:select path="userId">
				<c:forEach var="user" items="${users}">
					<form:option value="${user.id }">${user.userName }</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:button value="Save">Save</form:button>
			<a href="${path}/address/list">List Address</a>
		</p>
	</form:form> --%>