<%@page isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<h1 style="color:red;text-align:center;">Result Page</h1>

<b>sys date and time :: ${sysDate}</b>
<br>
<b>Wish Messege :: ${wMsg }</b>
<br>
<b>Wish Messege ::<c:out value=" ${wMsg }" /></b>

<br>
<br>

<a href="./">home</a>