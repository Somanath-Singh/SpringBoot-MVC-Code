<%@ page isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty jsList }">
		<table border="1" align="center" bgcolor="cyan">

			<tr>
				<th>JsId</th>
				<th>JsName</th>
				<th>JsAddrs</th>
				<th>Resume</th>
				<th>Photo</th>
			</tr>

			<tr>
				<c:forEach var="info" items="${jsList }">
					<tr>
						<td>${info.jsId}</td>
						<td>${info.jsName}</td>
						<td>${info.jsAddrs}</td>
						<td><a href="download?jsId=${info.jsId}&type=resume">download
								resume</a></td>
						<td><a href="download?jsId=${info.jsId}&type=photo">download
								photo</a></td>
					</tr>
				</c:forEach>
			</tr>

		</table>
	</c:when>

	<c:otherwise>
		<h1 style="text-align: center; color: red;">Record Not Found</h1>
	</c:otherwise>
	
</c:choose>