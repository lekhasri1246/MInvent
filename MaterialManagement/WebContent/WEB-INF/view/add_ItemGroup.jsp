<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Add Item Group</p><div>
<form:form method="post" action="add_ItemGroup" id="vform">
Welcome
<table class="left">
<tr>
	<td><form:label path="IGName">Name</form:label></td>
	<td width="400"><form:input path="IGName" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>

<tr>	
	<td/>
	<td><br><input type="submit" value="Add Item Group"/></td>
	<td/>
</tr>
</table>
</form:form>
</div></div>