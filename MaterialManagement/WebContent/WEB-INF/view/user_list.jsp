<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p></p><div>
<table class="hover fullwidth leftaligntext" id="dtable">
<thead>
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Address</th>
	<th>Phone</th>
	<th>Amount</th>
	<th>Balance</th>
	<th>Incentive</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">
<tr>
	<td><c:out value="${user.id}"/></td>
	<td><c:out value="${user.name}"/></td>
	<td><c:out value="${user.address}"/></td>
	<td><c:out value="${user.phone}"/></td>
	<td><c:out value="${user.amount}"/></td>
	<td><c:out value="${user.balance}"/></td>
	<td><c:out value="${user.commission}"/></td>
</tr>
</c:forEach>
</tbody>
</table>
</div></div>