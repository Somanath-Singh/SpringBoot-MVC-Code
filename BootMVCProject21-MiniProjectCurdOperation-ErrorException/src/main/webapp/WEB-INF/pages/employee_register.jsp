<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 style="colre:blue;text-align:center">Register Employee</h1>
<br><br>

<form:form modelAttribute="emp" method="POST">

<table border="1" align="center" bgcolor="cyan">
			<tr>
				<td>Employee Name ::</td>
				<td><form:input path="ename"/></td>
			</tr>
			<tr>
				<td>Employee job ::</td>
				<td><form:input path="job"/></td>
			</tr>
			<tr>
				<td>Employee Salary ::</td>
				<td><form:input path="sal"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register Employee" /></td>
			</tr>
		</table>
</form:form>
