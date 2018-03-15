<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>List Items</title>
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
			<a href="showFormForAdd"><input type="button" value="Add Item"
				class="add-button"/>
			</a>	
				
			<!-- add our html table here -->
				<table>
					<tr>
						<th>ItemId</th>
						<th>ItemName</th>
						<th>ItemDescription</th>
						<th>Quantity Available</th>
						<th>Action</th>
					</tr>
					
					<!-- Loop over and print our customers -->
					<c:forEach var="tempItem" items="${items}">
					
					<!-- construct an "update" link with customerId -->
					<c:url var="updateLink" value="/item/showFormForUpdate">
						<c:param name="itemId" value="${tempItem.itemId}"/>
					</c:url>
					
						<tr>
							<td>${tempItem.itemId} </td>
							<td>${tempItem.itemName} </td>
							<td>${tempItem.itemDesc} </td>
							<td>${tempItem.quantity} </td>
							
							<!-- Display the update Link -->
							<td>
								<a href="${updateLink}">Update</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				
			</div>
		</div>
	</body>
</html>