<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Modify Account Group</p><div>
<form:form method="post" action="modify_accountgroup?accntgrpId=${accntgrpId}" id="vform">
Welcome
<table class="left">
<tr>
	<td><form:label path="GName">Name</form:label></td>
	<td width="400"><form:input path="GName" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>
<tr>
<td><form:label path="GType">Type </form:label></td>
<td><form:input path="GType"/></td>
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Save"/></td>
	<td/>
</tr>
</table>
</form:form>
</div></div>