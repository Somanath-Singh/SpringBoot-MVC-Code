<%-- <%@page isELIgnored="false"  %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="colre: blue; text-align: center">Employees Report</h1>

<br>
<br>

<c:choose>
	<c:when test="${!empty empsData }">
		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<th>Empno</th>
				<th>Ename</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="emp" items="${empsData}">
				<tr>
					<th>${emp.empno}</th>
					<th>${emp.ename}</th>
					<th>${emp.job }</th>
					<th>${emp.sal }</th>
					<th><a href="edit?no=${emp.empno}"><img
							src="images/edit.jpg" width="50px" height="50px" /></a>&nbsp;&nbsp;&nbsp;&nbsp;<a onclick="return confirm('Do you want to delete')"
						href="delete?no=${emp.empno}"><img src="images/delete.jpg"
							width="50px" height="50px" /></a></th>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: blue; text-align: center">Record not found</h1>
	</c:otherwise>
</c:choose>

<br>
<c:if test="${!empty resultMsg}">
	<h3 style="color: green; text-align: center">${resultMsg}</h3>
</c:if>

<br>
<br>

<h1 style="colre: blue; text-align: center">
	<a href="addEmp"><img src="images/add.jpg" width="60px" height="30px"  /></a>
</h1>
