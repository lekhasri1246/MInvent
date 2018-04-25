<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Add Account </p><div>
<form:form method="post" action="add_Account" id="vform">
Welcome
<fieldset>
<legend>General Info</legend>
<table class="left">

<tr>
	<td><form:label path="AName">Name</form:label></td>
	<td width="400"><form:input path="AName" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>
<tr>
<td><form:label path="GId">Type </form:label></td>
<td width="400"><form:select path="GId" cssStyle="width:300px" items="${accountGroupMap}" /></td>

</tr>

<tr>
	<td><form:label path="openBalance">Open Balance</form:label></td>
	<td width="400"><form:input path="openBalance" cssStyle="width:300px" rangeLength="[3,100]"/></td>
</tr>

<tr>
	<td><form:label path="phone">Phone</form:label></td>
	<td width="400"><form:input path="phone" cssStyle="width:300px" rangeLength="[3,100]"/></td>
</tr>


</table>
</fieldset>
<div >
<fieldset>
<legend>Address Info</legend>
<table >
<tr>
	<td><form:label path="address">Address</form:label></td>
	<td width="400"><form:textarea path="address" cssStyle="width:300px" rangeLength="[3,100]"/></td>
	
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Add Account"/></td>
	<td/>
</tr>

</table>
</fieldset>
</div>
</form:form>
</div></div>