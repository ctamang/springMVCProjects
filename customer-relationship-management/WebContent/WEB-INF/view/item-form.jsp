<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title></title>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CUSTOMER RELATIONSHIP MANAGER</h2>
			</div>
		</div>
		
		<div id="container">
			<h3>Save Customer</h3>
			
			<form:form action="saveItem" modelAttribute="item" method="POST">
			
			<!-- need to associate this data with itemId -->
			<form:hidden path="itemId"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>Item Name:</label></td>
						<td><form:input path="itemName" /></td>
					</tr>
					<tr>
						<td><label>Item Description:</label></td>
						<td><form:input path="itemDesc" /></td>
					</tr>
					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="quantity" /></td>
					</tr>
					<tr>
						<td><label>Rate:</label></td>
						<td><form:input path="rate" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"></td>
					</tr>
				</tbody>
			</table>
			</form:form>	
			<div style="clear; both;"> </div>
			
			<p>	
				<a href="${pageContext.request.contextPath}/item/list">Back to List</a>
			</p>
		</div>	
	</body>
</html>