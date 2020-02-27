<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee | Management</title>
</head>
<body>
<h2>Update employee info</h2>


<form:form action="${pageContext.request.contextPath}/save" modelAttribute="employee" method="Post">

<form:hidden path="employeeId"/>

FirstName:
	<form:input type="text" path="firstName"/>
	<br></br>
	
	LastName:
	<form:input type="text" path="LastName"/>
	<br></br>
	
	Email:
	<form:input type="email" path="Email"/>
	<br></br>
	
	
	Phone Number:
	<form:input type="text" path="phoneNumber"/>
	<br></br>
	<input type="submit" value="save">

</form:form>

</body>
</html>