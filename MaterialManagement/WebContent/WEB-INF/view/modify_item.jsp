<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Modify Item </p><div>
<form:form method="post" action="modify_item?itemId=${itemId}" id="vform">
Welcome
<fieldset>
<legend>General Info</legend>
<table class="left">

<tr>
	<td><form:label path="IName">Name</form:label></td>
	<td width="400"><form:input path="IName" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>

<tr>
	<td><form:label path="OpeningStock"> Opening Stock</form:label></td>
	<td width="400"><form:input path="OpeningStock" cssStyle="width:300px" rangeLength="[3,100]"/></td>
</tr>

<tr>
	<td><form:label path="unitsType">Units</form:label></td>
	<td width="400"><form:input path="unitsType" cssStyle="width:300px" rangeLength="[3,100]"/></td>
</tr>
<tr>
<td><form:label path="IGid">Type </form:label></td>
<td width="400"><form:select path="IGid" cssStyle="width:300px" items="${itemGroupMap}" /></td>

</tr>


</table>
</fieldset>
<div >
<fieldset>
<legend>Item Details</legend>
<table >
<tr>
	<td><form:label path="Itemdesc">Item Description</form:label></td>
	<td width="400"><form:textarea path="Itemdesc" cssStyle="width:300px" rangeLength="[3,100]"/></td>
	
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Save Item"/></td>
	<td/>
</tr>

</table>
</fieldset>
</div>
</form:form>
</div></div>