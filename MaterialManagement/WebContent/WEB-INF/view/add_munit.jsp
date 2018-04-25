<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Add Unit </p><div>
<form:form method="post" action="add_munit" id="vform">
Welcome
<fieldset>
<legend>General Info</legend>
<table class="left">

<tr>
	<td><form:label path="Name">Name</form:label></td>
	<td width="400"><form:input path="Name" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>
<tr>
	<td><form:label path="comments">Comments</form:label></td>
	<td width="400"><form:textarea path="comments" cssStyle="width:300px" /></td>
	
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Add Unit"/></td>
	<td/>
</tr>


</table>
</fieldset>

</form:form>
</div></div>