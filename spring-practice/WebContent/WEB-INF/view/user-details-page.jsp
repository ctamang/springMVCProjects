<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Customer Confirmation Page</title>
</head>
<body>

	User Name : ${user.title} ${user.name}
	<br>
	Age : ${user.age}
	<br>
	Email Id : ${user.emailId}
	<br>
	Phone Number : ${user.phoneNumber}
	<br>
	Country : ${user.country}
	<br>
	Hobbies :
	<ul>
		<c:forEach var="hobby" items="${user.hobbies}">
			<li>${hobby}</li>
		</c:forEach>
	</ul>
</body>
</html>