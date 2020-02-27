<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
<title>Employee | Management</title>
</head>

<body>
<h1>Add New Employee</h1>

	<form:form action="${pageContext.request.contextPath}/save" modelAttribute="employee" method="Post">
	
	FirstName:
	<form:input type="text" path="firstName"/>
	<br/>
	
	LastName:
	<form:input type="text" path="LastName"/>
	<br/>
	
	Email:
	<form:input type="email" path="Email"/>
	<br>
	
	
	Phone Number:
	<form:input type="text" path="phoneNumber"/>
	<br>
	
	<input type="submit" value="Save">
	
	</form:form>
	

	<br/>  <br/>

</body>

</html>