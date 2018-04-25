<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Add Material Centre </p><div>
<form:form method="post" action="add_materialcentre" id="vform">
Welcome
<fieldset>
<legend>General Info</legend>
<table class="left">

<tr>
	<td><form:label path="name">Name</form:label></td>
	<td width="400"><form:input path="name" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>

<tr>
	<td><form:label path="stock_Account">Stock Account</form:label></td>
	<td width="400"><form:input path="stock_Account" cssStyle="width:300px"/></td>
</tr>

<tr>
	<td><form:label path="transfered">Transferred(Y/N)</form:label></td>
	<td width="400"><form:input path="transfered" /></td>
</tr>


</table>
</fieldset>
<div >
<fieldset>
<legend>Address Info</legend>
<table >
<tr>
	<td><form:label path="address">Address</form:label></td>
	<td width="400"><form:textarea path="address" cssStyle="width:300px" rangeLength="[10,100]"/></td>
	
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Add Material Centre"/></td>
	<td/>
</tr>

</table>
</fieldset>
</div>
</form:form>
</div></div>