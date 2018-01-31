<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Customer Confirmation Page</title>
</head>
<body>

	The customer : ${customer.firstName} ${customer.lastName} is confirmed
	<br>
	The passed he got : ${customer.freePasses}
	<br>
	The postal code is : ${customer.postalCode}
	<br>
	The course code is : ${customer.courseCode}
</body>
</html>