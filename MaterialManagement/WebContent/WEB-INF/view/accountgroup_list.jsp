<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">List of Account Groups </p>
<div>
<form:form method="get" action="modify_accountgroup" id="vform">

<table class="left">


<tr>
<td><form:label path="id">Select an Account Group </form:label></td>
<td width="400">
<form:select path="id" id="gId" cssStyle="width:400px height:600px" items="${accountgroupMap}" multiple="true"/></td>

</tr>


<tr>	
	<td/>
	<td><br>
 	<input type="submit" value="Modify Account Group"/></td>  
	<!-- <a class="btn" href="modify_account?accntId=<c:out value="${accntId}"/>">Modify Account</a>  -->
	
	<td/>
</tr>

</table>


</form:form>
</div>
</div>