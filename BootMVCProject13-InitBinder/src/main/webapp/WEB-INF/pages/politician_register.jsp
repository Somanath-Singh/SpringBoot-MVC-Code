<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:red;text-align:center;">Politician registration</h1>


<form:form method="POST" modelAttribute="pp">

<table align="center" border="1" bgcolor="cyan">

<tr>
<td>Politician name :</td>
<td><form:input path="pname" /></td>
</tr>

<tr>
<td>Politician party :</td>
<td><form:input path="party" /></td>
</tr>

<tr>
<td>Politician BOB:</td>
<td><form:input path="dob" type="date" /></td>
</tr>

<tr>
<td>Politician DOJ:</td>
<td><form:input path="doj" type="date" /></td>
</tr>

<tr>
<td>Has Constitution post ?:</td>
<td><form:radiobutton path="HavingConsPost"  value="true"/>yes &nbsp;&nbsp;&nbsp;&nbsp;
		<form:radiobutton path="HavingConsPost"  value="false"/>no
</td>
</tr>


<tr>
<td colspan="2"><input  type="submit"  value="Register"/></td>
</tr>


</table>

</form:form>