<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Edit User</p><div>
<form:form method="post" action="edit_user?userId=${userId}" id="vform">
<table class="left">
<tr>
	<td><form:label path="username">Name</form:label></td>
	<td width="400"><form:input path="username" cssStyle="width:300px" class="required" rangeLength="[3,100]"/></td>
	<td><c:out value="${name_error}"/></td>
</tr>
<tr>
<td><form:label path="password">Password: </form:label></td>
<td><form:input path="password" type="password"/></td>
</tr>

</table>
<fieldset>
<legend>Other Options</legend>
<table class="left">
<tr>
<td>Voucher Permission</td>
<td><form:checkbox path="voucherPermissionModify" name="voucherPermissionModify"/>
<form:label path="voucherPermissionModify">Modify </form:label></td>
<td><form:checkbox path="voucherPermissionDelete" name="voucherPermissionDelete"/>
<form:label path="voucherPermissionDelete">Delete </form:label></td>
</tr>

<tr>
<td>User Preferences</td>
<td><form:checkbox path="administrationPref" name="administrationPref"/>
<form:label path="administrationPref">Administration </form:label></td>
<td><form:checkbox path="tranasctionPref" name="tranasctionPref"/>
<form:label path="tranasctionPref">Transaction </form:label></td>
<td><form:checkbox path="displayPref" name="displayPref"/>
<form:label path="displayPref">Display </form:label></td>
</tr>

<tr>	
	<td/>
	<td><br><input type="submit" value="Add User"/></td>
	<td/>
</tr>
</table>
</fieldset>

<input type="submit" value="Save"/>
</form:form>
</div></div>