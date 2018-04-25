<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>
<!-- Setting root of web application so that we can reference URL's relatively -->
<spring:url value="/" var="root" />

<script>
function clickSave()
{
	var filename = document.getElementById('save_name').value;
	var url = "http://localhost:8080<c:out value="${root}"/>doBackup?fileName=" + filename;
	//alert("URL is: \n" + url);
	window.open(url,"_self");
}
</script>
</head>


<div id="container"><p style="text-align:left;">Backup</p><div>
<p>Please enter the name you would like to save your backup as.</p>
<p>Note: Backups will be saved in the C:\backup\ folder.</p>
<br>
<input type="text" placeholder="" value="" id="save_name" style="width: 30%;">
<button id="save_button" onClick='clickSave()'>Save</button>
<br>
</div>
<p style="text-align:left;">Restore</p><div>
<p>Select file containing backup.</p>

<form:form method="post" action="doRestore" modelAttribute="uploadForm" enctype="multipart/form-data">
<table class="center">
<tr>
	<td><input name="files[0]" type="file" required/></td>
	<td><input type="submit" value="Restore" /></td>
</tr>
</table>
</form:form>
</div></div>