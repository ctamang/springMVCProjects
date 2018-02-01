<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<body>

<h2>Registration Page</h2>

<hr>

	<form:form action="submitRegistrationDeatails" modelAttribute="user">
		
		Name : <form:input path="name"/>
		
		<br><br>
		
		Age : <form:input path="age"/>
		
		<br><br>
		
		Email Id : <form:input path="emailId"/>
		
		<br><br>
		
		PhoneNumber : <form:input path="phoneNumber"/>
		
		<br><br>
		
		Country : 
		<form:select path="country">
			<form:options items="${theCountryOptions}"/>		
		</form:select>
				
		<br><br>
		
		<input type="submit" value="submit"/>
		
	
	</form:form>


<br><br>

</body>

</html>