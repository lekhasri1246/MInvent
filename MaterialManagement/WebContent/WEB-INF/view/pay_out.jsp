<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Payment</p><div>
<form:form method="post" action="pay_out" id="vform">
<table class="center">
<tr>
	<td><form:label path="user_id">Weaver Name</form:label></td>
	<td width="400"><form:select path="user_id" cssStyle="width:300px" items="${tradersMap}"/></td>
	<td><c:out value="${user_id_error}"/></td>
</tr>

<tr>
	<td><form:label path="add_date">Date</form:label></td>
	<td width="400"><form:input path="add_date" cssStyle="width:300px" class="required dateITA" id="datepicker" placeholder="dd/mm/yyyy"/></td>
	<td><c:out value="${date_error}"/></td>
</tr>
<tr>	
	<td><form:label path="amount">Amount</form:label></td>
	<td width="400"><form:input path="amount" cssStyle="width:300px" class="required digits" min="1"/></td>
	<td><c:out value="${challanNo_error}"/></td>
</tr>
<tr>
	<td><form:label path="comment_a">Comment</form:label></td>
	<td width="400"><form:input path="comment_a" cssStyle="width:300px" /></td>
	<td><c:out value="${comment_error}"/></td>
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Confirm Payment"/></td>
	<td/>
</tr>
</table>
</form:form>
</div></div>