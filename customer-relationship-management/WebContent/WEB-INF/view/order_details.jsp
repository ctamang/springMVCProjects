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
						<th>ItemId</th>
						<th>Item Description</th>
						<th>Quantity</th>
					</tr>
					
					<!-- Loop over and print our customers -->
					<c:forEach var="tempOrderDetail" items="${orderDetails}">
					
						<tr>
							<td>${tempOrderDetail.itemId} </td>
							<td>${tempOrderDetail.itemDesc} </td>
							<td>	${tempOrderDetail.quantity} </td>
						</tr>
					</c:forEach>
				</table>
			<p>	
				<a href="${pageContext.request.contextPath}/customer/orders">Back to Orders</a>
			</p>
			
			</div>
		</div>
	</body>
</html>