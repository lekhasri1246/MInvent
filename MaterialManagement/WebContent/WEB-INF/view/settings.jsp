<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<!-- Setting root of web application so that we can reference URL's relatively -->
<spring:url value="/" var="root" />

<script>
function validateAndFire()
{
	var oldPassword = document.getElementById("password_old").value;
	var newPassword = document.getElementById("password_new").value;
	var confirmPassword = document.getElementById("password_confirm").value;
	
	//Checking if any fields are left blank
	if(oldPassword=="" || newPassword=="" || confirmPassword=="")
	{
		window.alert("Do not leave any field blank");
		return;
	}
	
	//Checking if current password entered is incorrect
	if(oldPassword != "<c:out value="${credentials.password}"/>")
	{
		window.alert("The current password entered is incorrect");
		return;
	}
	else
	{
		//Check if new password and confirm password fields match
		if(newPassword != confirmPassword)
		{
			window.alert("The new password and confirm password should match");
			return;
		}
		else
		{
			//Every thing is fine, fire the change password url
			var url = "http://localhost:8080<c:out value="${root}"/>changePassword?p=" + newPassword;
			window.open(url,"_self");
		}
	}
}

//Function to change IP
function ChangeIP()
{
	var newIP=document.getElementById("new_ip").value;
	//Change IP
	var url = "http://localhost:8080<c:out value="${root}"/>changeIP?p=" + newIP;
	window.open(url,"_self");
	}
</script>
</head>

<!-- Tabs displaying various Settings tabs -->
<div id="tabs">
	<ul>
		<li><a href="#container">Password</a></li>
		<li><a href="#tabs-2">IP SetUp</a></li>
	</ul>


<div id="container"><p style='text-align : left;'>Change Password</p><div>
<table class="center leftaligntext">
<tr><td><br></td></tr>
<tr>
	<td>Enter current password:</td>
	<td></td>
	<td><input id="password_old" type="password"></td>
</tr>
<tr>
	<td>Enter new password:</td>
	<td></td>
	<td><input id="password_new" type="password"></td>
</tr>
<tr>
	<td>Confirm new password:</td>
	<td></td>
	<td><input id="password_confirm" type="password"></td>
</tr>
<tr><td><br></td></tr>
<tr>
	<td></td>
	<td><button onClick='validateAndFire()'>Confirm</button></td>
	<td></td>
</tr>
</table>
<br>
</div></div>

	<div id="tabs-2">
	<table class="center leftaligntext">
<tr><td><br></td></tr>
<tr>
	<td>IP SetUp</td>
	<td></td>
	<td><input id="new_ip" type="text" value="${userIP}" maxlength=50></td>
</tr>
<tr>
	<td></td>
	<td><button onClick='ChangeIP()'>Confirm</button></td>
	<td></td>
</tr>

	</table>	
	</div>
</div>