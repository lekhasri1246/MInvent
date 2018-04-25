<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Edit Item</p><div>
<form:form method="post" action="editItem?itemId=${itemId}" id="vform">
<table class="center">
<tr>
	<td><form:label path="item_name">Item Name</form:label></td>
	<td width="400"><form:input path="item_name" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${item_name_error}"/></td>
</tr>
<tr>
	<td><form:label path="add_date">Date</form:label></td>
	<td width="400"><form:input path="add_date" cssStyle="width:300px" id="datepicker" placeholder="dd/mm/yyyy" class="required dateITA"/></td>
	<td><c:out value="${add_date_error}"/></td>
</tr>
<tr>	
	<td><form:label path="cost">Cost</form:label></td>
	<td width="400"><form:input path="cost" cssStyle="width:300px" class="required number" range="[0,99999999]"/></td>
	<td><c:out value="${cost_error}"/></td>
</tr>
<tr>
	<td><form:label path="product_desc">Product Description</form:label></td>
	<td width="400"><form:input path="product_desc" cssStyle="width:300px" maxLength="2000"/></td>
	<td><c:out value="${product_desc_error}"/></td>
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Edit Item"/></td>
	<td/>
</tr>
</table>
</form:form>
</div></div>