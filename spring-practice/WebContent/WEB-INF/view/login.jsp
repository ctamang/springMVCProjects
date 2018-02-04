<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>

<body>
	<form:form action="processLoginPage" modelAttribute="login">
		
		UserName : 
		<form:input path="userName" value="userName"/>
		
		<br><br>
		
		Password:	
		<form:input path="password" value="password"/>
		
		<br><br>
		
		<input type="submit" value="submit"/>
	
	</form:form>
</body>
</html>