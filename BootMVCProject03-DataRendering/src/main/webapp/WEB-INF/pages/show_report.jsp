<%@page isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 



<%-- <b>model data (Array,Collection)</b>
<br>
favorite colors(array)::

<c:if test="${!empty favColors }">
	<c:forEach var="color" items="${favColors }">
${color},
</c:forEach>

</c:if>

<br>
nickNames (List collections)::

<c:if test="${!empty nickNames }">
	<c:forEach var="name" items="${nickNames }}">
${name },
</c:forEach>

</c:if>

<br>
phoneNumbers (Set collections)::

<c:if test="${!empty phoneNumbers }">
	<c:forEach var="num" items="${phoneNumbers }">
${num},
</c:forEach>

</c:if>

<br>
idDetails (Map collections)::

<c:if test="${!empty idDetails }">
${idDetails.aadhar},<br>
${idDetails.panNo},<br>
${idDetails.voterid},<br>

</c:if> --%>




<br>
<br>
<%-- <b>Model data is</b>
<br>

<c:if test="${!empty prodData }">

product id::${prodData.pid }<br>
product pname::${prodData.pname }<br>
product price::${prodData.price }<br>
product qty::${prodData.qty }<br>
</c:if> --%>


<b>Collection of Model data is</b>
<br>

<%-- <c:choose>

	<c:when test="${!empty prodList }">

		<table border="1" align="center" bgcolor="cyan">
			<tr>
				<th>PID</th>
				<th>PNAME</th>
				<th>PRICE</th>
				<th>QTY</th>
			</tr>
			<c:forEach var="prod" items="${prodList }">
				<tr>
					<td>${prod.pid}</td>
					<td>${prod.pname}</td>
					<td>${prod.price}</td>
					<td>${prod.qty}</td>
				</tr>
			</c:forEach>
		</table>

	</c:when>

	<c:otherwise>
		<h1 style="color: red; text-align: center;">No record found</h1>
	</c:otherwise>

</c:choose> --%>


<b>name::${name }</b>
<b>age::${age }</b>
<b>addrs::${addrs }</b>

<br>
<br>