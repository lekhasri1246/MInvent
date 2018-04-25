<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p></p><div>
<h4>User Login.</h4>
<p>Please Login to continue</p><br>

<form:form method="post" action="doLogin">
<table class="center">
<tr>
<td><form:label path="userName">User Name: </form:label></td>
<td><form:input path="userName"/></td>
</tr>
<tr>
<td><form:label path="password">Password: </form:label></td>
<td><form:input path="password" type="password"/></td></tr>
</table>

<br><input type="submit">

<div style="color:red">${error}</div>
</form:form>
</div></div>