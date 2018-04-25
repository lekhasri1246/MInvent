<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<!-- Images -->
<spring:url value="/resources/background1.jpg" var="headerbg" />
<style type="text/css">
.bg 
{
    background-image: url('<c:out value="${headerbg}"/>');
}
</style>
</head>

<div class=bg>
<table class="center fullwidth">
<tr>
<td width=1%>
<a class="btn" href="home">Home</a>
</td>
<td width=99%>
<h1 style="font-size:48px; color: #091466; font-family: Copperplate / Copperplate Gothic Light, sans-serif;">
<strong>Material Management</strong>
</h1>
</td>

<td width=1%>
<a class="btn" href="log_out">Logout</a>
</td>

</tr>
</table>

</div>