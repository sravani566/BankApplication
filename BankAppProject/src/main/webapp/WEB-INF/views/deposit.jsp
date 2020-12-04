<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.error{
	color:#EF1313;
	font-style: italic;
}</style>
</head>
<body>
<h3>Welcome</h3>
	<form:form action="deposit" method="post" modelAttribute="depositBean">
		<table>
			
			<tr>
				<td>Enter account number:</td>
				<td><form:input path="accountId"/><form:errors path="accountId" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td>Enter amount to be transferred:</td>
				<td><form:input path="amount"/><form:errors path="amount" class="error"></form:errors></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="submit"></td>
			</tr>
			
		
		</table>
	
	</form:form>

</body>
</html>