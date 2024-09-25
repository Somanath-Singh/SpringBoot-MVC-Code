<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<noscript>
<h1 style="color:red;text-align:center">Please enable javascript</h1>
</noscript>

<style>
body {
	background-color: pink;
}

span {
	color: red;
}
</style>

<script language="javascript" src="js/validation.js"></script>

<h1 style="color:blue;text-align:center">Register Employee</h1>
<br><br>

<form:form modelAttribute="emp" method="POST" onsubmit="return validation(this)" >

	<%-- <p style="color: red; text-align: center;">
	  	<form:errors path="*" />
	</p> --%>

	<table border="1" align="center" bgcolor="cyan">
			<tr>
				<td>Employee Name ::</td>
				<td><form:input path="ename"/><form:errors  cssStyle="color: red;" path="ename" /><span id="enameErr"></span></td>
			</tr>
			<tr>
				<td>Employee job ::</td>
				<td><form:input path="job"/><form:errors  path="job" /><span id="jobErr"></span></td>
			</tr>
			<tr>
				<td>Employee Salary ::</td>
				<td><form:input path="sal"/><form:errors  path="sal" /><span id="salErr"></span></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Register Employee" /></td>
			</tr>
		</table>
		<form:hidden path="vflag"/>
</form:form>
