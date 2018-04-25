<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>

<!-- Setting root of web application so that we can reference URL's relatively -->
<spring:url value="/" var="root" />

<script>
function deleteItem()
{
	console.log("At deleteUser");
	var url = "http://localhost:8080<c:out value="${root}"/>deleteItem?itemId=${itemId}";
	var password = "<c:out value="${credentials.password}"/>";
	var x = prompt("Enter password: ","");
	if(x == null)
		return;
	if(x.toLowerCase() == password)
		window.open(url,"_self");
	else
		window.alert("Wrong password");
}
</script>
</head>

<div id="container">
<p style="text-align:left">Item Details</p>
<div>
<table class="center smalltext colored leftaligntext">
<tr>
	<td width="150">Item Name:</td>			
	<td width="150"><c:out value="${item.item_name}"/></td>
</tr>
<tr>
	<td width="150">Date Added:</td>
	<td width="150"><c:out value="${item.add_date}"/></td>
</tr>
<tr>
	<td width="150">Cost:</td>
	<td width="150"><c:out value="${item.cost}"/></td>
</tr>
<tr>
	<td width="150">Description:</td>
	<td width="750"><c:out value="${item.product_desc}"/></td>	
<tr>
</table>

<br>
<a class="btn" href="item_dashboard">Back</a>
<a class="btn" href="edit_item?itemId=${itemId}">Edit Item</a>
<a class="btn" onClick='deleteItem()'>Delete Item</a>
<br><br>

</div>
</div>