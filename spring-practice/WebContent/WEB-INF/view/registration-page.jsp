<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
	<style type="text/css">
		.error
		{
			color:red
		}
	</style>
</head>
<body>

<h2>Registration Page</h2>

<hr>

	<form:form action="submitRegistrationDeatails" modelAttribute="user">
	
		Mr.<form:radiobutton path="title" value="Mr."/>
		Mrs. <form:radiobutton path="title" value="Mrs."/>
		
		<br><br>
		
		Name : 
			<form:input path="name"/>
			<form:errors path="name" cssClass="error"/>
		
		<br><br>
		
		Age : 
			<form:input path="age"/>
		 	<form:errors path="age" cssClass="error"/>
		
		<br><br>
		
		Email Id : 
			 <form:input path="emailId"/>
			 <form:errors path="emailId" cssClass="error"/>
		<br><br>
		
		PhoneNumber : 
			 <form:input path="phoneNumber"/>
			 <form:errors path="phoneNumber" cssClass="error"/>
		
		<br><br>
		
		Country : 
			<form:select path="country">
				<form:options items="${theCountryOptions}"/>		
			</form:select>
			<form:errors path="country" cssClass="error"/>
				
		<br><br>
		
		Hobbies :
		Cricket<form:checkbox path="hobbies" value="cricket"/>
		Football<form:checkbox path="hobbies" value="football"/>
		Basketball<form:checkbox path="hobbies" value="basketball"/>
		 		<form:errors path="hobbies" cssClass="error"/>
		
		<br><br>
		<input type="submit" value="submit"/>
		
	
	</form:form>


<br><br>

</body>

</html>