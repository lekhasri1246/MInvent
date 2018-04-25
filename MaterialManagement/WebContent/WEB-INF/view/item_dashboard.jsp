<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Items</p><div>
<div id="id_items">
  <input class="search" placeholder="Search" />			<!-- "search" is an auto-magic class of List.js -->
  <br><br>
  <h3><input type="button" OnClick='PrintItem()' value="Print Items"></h3>
  <table border="1"  class="center">
  <thead>
  <tr>
    <th width="100">ID</th>
    <th width="200">NAME</th>
    <th width="100">ADD DATE</th>
    <th width="100">COST</th>
    <th width="450">DESCRIPTION</th>
  </tr>
  </thead>
  <tbody class="list">
  <c:forEach var="item" items="${items}">
	<tr>
	  <td class="class_itemId">
	  <c:out value="${item.id}"/>
	  </td>
	  <td class="class_itemName">
	  <a href="manage_item?itemId=<c:out value="${item.id}"/>">	<c:out value="${item.item_name}"/></a>
	  </td>
	  <td class="class_addDate">
	  <c:out value="${item.add_date}"/>
	  </td>
	  <td class="class_cost">
	  <c:out value="${item.cost}"/>
	  </td>
	  <td class="class_prodDesc">
	  <c:out value="${item.product_desc}"/>
	  </td>
	  </tr>
  </c:forEach>
  </tbody>
  </table>
</div>

<br>
<a class="btn" href="home">Back</a>
<a class="btn" href="add_item">New Item</a>
<br><br><br>

</div></div>


<head>
<spring:url value="/" var="root" />
<script>
var options =
{
	  valueNames: [ 'class_itemId' , 'class_itemName' , 'class_addDate' , 'class_cost' , 'class_prodDesc' ]
};
var userList = new List('id_items', options);

function PrintItem()
{
	window.alert("at print item");
	console.log("At printItem");
	
	var url = "http://localhost:8080<c:out value="${root}"/>downloadPDF";
		window.open(url,"_self");
	}
</script>		
</head>