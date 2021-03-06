<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>List Customers</title>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CUSTOMER RELATIONSHIP MANAGER</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				
				<!-- put new Button : Add Customer -->
			<a href="showFormForAdd"><input type="button" value="Add Customer"
				class="add-button"/>
			</a>	

			<!-- add our html table here -->
				<table>
					<tr>
						<th>FirstName</th>
						<th>LastName</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<!-- Loop over and print our customers -->
					<c:forEach var="tempCustomer" items="${customers}">
					
					<!-- construct an "update" link with customerId -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<!-- construct an "delete" link with customerId -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"/>
					</c:url>
					
					<!-- construct an "Orders" link with customerId -->
					<c:url var="orderLink" value="/customer/orders">
						<c:param name="customerId" value="${tempCustomer.id}"/>					
					</c:url>
					
						<tr>
							<td>${tempCustomer.firstName} </td>
							<td>${tempCustomer.lastName} </td>
							<td>${tempCustomer.email} </td>
							
							<!-- Display the update Link -->
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
								|
								<a href="${orderLink}">Orders</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
	</body>
</html>