<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title>Student Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		FirstName : <form:input path="firstName"/>
		
		<br><br>
		LaseName : <form:input path="lastName"/>
		
		<br><br>
		
		Country : 
		
		<!-- using properties file -->
		<form:select path="country">
			<form:options items="${theCountryOptions}"/>		
		</form:select>
			
		<%-- <form:select path="country">
			<form:options items="${student.countryOptions}"/>		
		</form:select> --%>
		
		
		<%-- <form:select path="country" >
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />
		</form:select> --%>
		
		<br><br>
		
		Favourite Language : 
		
		Java <form:radiobutton path="favouriteLanguage" value="Java"/>
		Python <form:radiobutton path="favouriteLanguage" value="Python"/>
		Groovy <form:radiobutton path="favouriteLanguage" value="Groovy"/>
		Swift <form:radiobutton path="favouriteLanguage" value="Swift"/>
		
		<br><br>
		
		Operating Systems : 
		
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		
		<input type="submit" value="submit">
	</form:form>
</body>
</html>