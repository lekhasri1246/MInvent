<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<style>
    option:not(:checked) { 
        background-color: #FFF; 
    }

</style>
<script>
//Hide warpInput on page load
$(document).ready(function(){
    $("#warpInput").hide();
	document.getElementById("warpNo").value = "-1";
	//Make sure that the tick box is unset on browser back(bugfix)
	document.getElementById("warpTickBox").checked = false;
	
	});


//warpInput is hidden by default
var warpDisabled = true;

function toggleWarpInput()
{
	if(warpDisabled == true)
	{
		document.getElementById("warpInput").style.display = "block";
		warpDisabled = false;
		return;
	}
	else
	{
		document.getElementById("warpNo").value = "-1";
		document.getElementById("warpInput").style.display = "none";
		warpDisabled = true;
		return;
	}
}


</script>
</head>


<div id="container" ><p style="text-align:left;">Send or Receive</p><div>
<form:form method="post" action="add_data" id="vform" >
<table class="center">
<tr>
	<td><form:label path="typeOfTransaction">Type of Transaction</form:label></td>
	<td width="400">
		<form:select id="typeOfTransaction" path="typeOfTransaction" cssStyle="width:300px;background:#3498db;color:#000;" items="${transactionTypeMap}" autofocus="autofocus" />
	 </td>
	<td><c:out value="${typeOfTransaction_error}"/></td>
</tr>

<tr>
	<td><form:label path="traderId">Weaver Name</form:label></td>
	<td width="400"><form:select path="traderId" cssStyle="width:300px" items="${tradersMap}" /></td>
	<td><c:out value="${traderId_error}"/></td>
</tr>

<tr>
	<td><form:label path="date">Date</form:label></td>
	<td width="400"><form:input path="date" cssStyle="width:300px" class="required dateITA" id="datepicker" placeholder="dd/mm/yyyy"/></td>
	<td><c:out value="${date_error}"/></td>
</tr>
<tr>	
	<td><form:label path="challanNo">Challan Number</form:label></td>
	<td width="400"><form:input path="challanNo" cssStyle="width:300px" class="required digits" min="1" default=""/></td>
	<td><c:out value="${challanNo_error}"/></td>
</tr>
<tr>	
	<td><form:label path="warpNo">Warp Number</form:label></td>
	<td width="400" id="warpInput"><form:input path="warpNo" cssStyle="width:300px" class="digits" min="0"/></td>
	<td><input type="checkbox" id="warpTickBox"  onClick="toggleWarpInput()"> <c:out value="${warpNo_error}"/></td>
</tr>

<tr>
	<td><form:label path="itemId">Item Name</form:label></td>
	<td width="400"><form:select path="itemId" cssStyle="width:300px" items="${itemsMap}"/></td>
	<td><c:out value="${itemId_error}"/></td>
</tr>
 
<tr>
	<td><form:label path="quantity">Quantity</form:label></td>
	<td width="400"><form:input path="quantity" cssStyle="width:300px" class="required digits" min="0" /></td>
	<td><c:out value="${quantity_error}"/></td>
</tr>
<tr>
	<td><form:label path="weight">Total Weight</form:label></td>
	<td width="400"><form:input path="weight" cssStyle="width:300px" class="number"/></td>
	<td><c:out value="${weight_error}"/></td>
</tr>
<tr>
	<td><form:label path="comment">Comment</form:label></td>
	<td width="400"><form:input path="comment" cssStyle="width:300px" /></td>
	<td><c:out value="${comment_error}"/></td>
</tr>
<tr>	
	<td/>
	<td><br><input type="submit" value="Add Data" /></td>
	<td/>
</tr>
</table>
</form:form>
</div></div>



