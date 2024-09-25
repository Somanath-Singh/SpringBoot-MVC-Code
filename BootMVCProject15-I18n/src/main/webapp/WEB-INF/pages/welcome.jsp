<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:blue;text-align:center;"><sp:message code="home.title" /></h1>
<br><br>

<a href="register"><h1 style="color:blue;text-align:center;"><sp:message code="home.link" /></h1></a>

<h1>Current active Locale is:${pageContext.response.locale} </h1>
<fmt:setLocale value="${pageContext.response.locale}" />


<jsp:useBean id="dt" class="java.util.Date" />
<fmt:formatDate var="fdt" value="${dt }" type="date" dateStyle="FULL" />
<b>formatted date ::${fdt }</b>
<br>
<fmt:formatDate var="ftime" value="${dt }" type="time" timeStyle="FULL" />
<b>formatted time ::${ftime }</b>
<br>
<fmt:formatNumber var="fnumber" value="1000000" type="number" />
<b>formatted Number :: ${fnumber }</b>
<br>
<fmt:formatNumber var="fcurrency" value="1000000" type="currency" />
<b>formatted Currency :: ${fcurrency }</b>
<br>
<fmt:formatNumber var="fpercentage" value=".2" type="percent" />
<b>formatted Number :: ${fpercentage }</b>
<br>

<p align="center">

<a href="?lang=fr_FR">French</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=de_DE">German</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=hi_IN">हिंदी</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

</p>