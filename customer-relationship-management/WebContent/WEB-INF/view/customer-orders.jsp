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

			<!-- add our html table here -->
				<table>
					<tr>
						<th>OrderId</th>
						<th>OrderDate</th>
						<th>Action</th>
					</tr>
					
					<!-- Loop over and print our customers -->
					<c:forEach var="tempOrder" items="${orders}">
					
					<!-- construct an "display Order Details" link with orderId -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="tempOrder" value="${tempOrder.orderId}"/>
					</c:url>
					
					<!-- construct an "Delete" link with orderId -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="tempOrder" value="${tempOrder.orderId}"/>
					</c:url>
					
						<tr>
							<td>${tempOrder.orderId} </td>
							<td>${tempOrder.date} </td>
							
							<!-- Display the update Link -->
							<td>
								<a href="${updateLink}">Delete</a>
								|
								<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this Order?'))) return false">Delete</a>
			
							</td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
	</body>
</html>