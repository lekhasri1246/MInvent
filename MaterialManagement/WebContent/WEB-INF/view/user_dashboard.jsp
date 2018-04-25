<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="container"><p style="text-align:left;">Weavers</p><div>
<div id="id_users">
  <input class="search" placeholder="Search" />			<!-- "search" is an auto-magic class of List.js -->
  <br><br>
  <table border="1" class="center">
  <thead>
  <tr>
  	<th class="sort" data-sort="class_userId"><a>Id</a></th>
  	<th class="sort" data-sort="class_userName"><a>Weaver Name</a></th>
  	<th class="sort" data-sort="class_address"><a>Address</a></th>
  	<th class="sort" data-sort="class_phone"><a>Phone Number</a></th>
  </tr>
  </thead>
  <tbody class="list">									<!-- "list" is an auto-magic class of List.js -->
  <c:forEach var="user" items="${users}">
    <tr>
      <td class="class_userId" width="50">
      <c:out value="${user.id}"/>
      </td>
      <td class="class_userName" width="250">
      <a href="manage_user?userId=<c:out value="${user.id}"/>"><c:out value="${user.name}"/></a>
      </td>
      <td class="class_address" width="250">
	  <c:out value="${user.address}"/>
	  </td>
	  <td class="class_phone" width="150">
	  <c:out value="${user.phone}"/>
	  </td>
    </tr>
  </c:forEach>
  </tbody>
  </table>
</div>

<br>
<a class="btn" href="home">Back</a>
<a class="btn" href="add_user">New User</a>
<br><br><br>
</div></div>

<head>
<script>
var options =
{
	  valueNames: [ 'class_userId' , 'class_userName' , 'class_address' , 'class_phone' ]
};
var userList = new List('id_users', options);
</script>		
</head>