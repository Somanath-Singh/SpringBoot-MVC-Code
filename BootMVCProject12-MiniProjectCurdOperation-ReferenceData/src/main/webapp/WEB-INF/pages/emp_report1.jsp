<%-- <%@page isELIgnored="false"  %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >

<h1 style="colre: blue; text-align: center">Employees Report</h1>

<br>
<br>
<div class="container">
<div class="row">
<div class="col-lg-12">
<c:choose>
	<c:when test="${!empty empsData }">
		<table  class="table table-light table-hover" border="1">
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

</div>
</div>
</div>

<br>
<c:if test="${!empty resultMsg}">
	<h3 style="color: green; text-align: center">${resultMsg}</h3>
</c:if>

<br>
<br>

<h1 style="colre: blue; text-align: center">
	<a href="addEmp"><img src="images/add.jpg" width="60px" height="30px"  /></a>
</h1>
