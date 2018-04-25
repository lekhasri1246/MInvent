<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<script>

//Hide the hidden_div element.
$(document).ready(function()
{
	$("#hidden_div").hide();
	
});

//Hide the date selection table by default.
$(document).ready(function()
{
	$("#periodSelectionTable").hide();
});

//Hides the date selection table when particular checkbox is clicked.
function hidePeriodSelectionTable(){
	 document.getElementById('periodSelectionTable').style.display = "none";
}

//Shows the date selection table when particular checkbox is clicked.
function showPeriodSelectionTable(){
	 document.getElementById('periodSelectionTable').style.display = "table";
}

//Validates the date selection if any, then builds the print query URL, the calls the built URL in a new window.
function doPrint()
{
	//Incase we are printing ALL records for given user.
	var allCheckedFlag = document.getElementById('all').checked;
	if(allCheckedFlag)
	{
		//alert("Printing ALL data for the given user");
		var url = buildURL(document.getElementById('userIp').innerHTML,document.getElementById('userId').innerHTML, "All", "All");
		window.open(url);
		return;
	}
	
	
	//Incase of a period between dates.
	var d1 = document.getElementById('datepicker1').value;
	var d1ValidFlag = moment(d1 , 'YYYY-MM-DD').isValid();
	var d2 = document.getElementById('datepicker2').value;
	var d2ValidFlag = moment(d2 , 'YYYY-MM-DD').isValid();
	
	if(!d1ValidFlag && !d2ValidFlag)
	{	alert("Both the selected dates are invalid");	return;		}
	if(!d1ValidFlag)
	{	alert("The start date is invalid");				return;		}
	if(!d2ValidFlag)
	{	alert("The end date is invalid");				return;		}
	
	var diff = Date.parse(d2) - Date.parse(d1);
	if(diff < 0)
	{
		alert("End date must be greater than or equal to the start date.");
		return;
	}
	else
	{
		//alert("Printing data for selected time period");
		var url = buildURL(document.getElementById('userIp').innerHTML,document.getElementById('userId').innerHTML, d1, d2);
		window.open(url);
		return;
	}
}

//Concatenates components and returns a new URL
function buildURL(i,u, s, e)
{
	
	//var url = "http://localhost:8080/PrintServlet/PrintPDF?u=" + u + "&s=" + s + "&e=" + e;
	var url = i +"/PrintServlet/PrintPDF?u=" + u + "&s=" + s + "&e=" + e;
	//console.log(url);
	window.alert(url);
	return url;
}
</script>
</head>


<div id="container"><p style="text-align:left;">Print Data</p><div>

<p>Select the dates for which you would like to print data</p>

<p>Print records for:</p>
<table class="center leftaligntext">
<tr>
<td><input type="radio" name="period" id="all" onClick="hidePeriodSelectionTable()" checked></td>
<td>All Time</td>
</tr>
<tr>
<td><input type="radio" name="period" id="selection" onClick="showPeriodSelectionTable()" ></td>
<td>Select Time Period</td>
</tr>
</table>

<br>

<table class="center leftaligntext" id="periodSelectionTable">
<tr>
<td>Start Date</td>
<td><input type="text" value="" class="required date" id="datepicker1" placeholder="dd/mm/yyyy"></td>
</tr>
<tr>
<td>End Date</td>
<td><input type="text" value="" class="required date" id="datepicker2" placeholder="dd/mm/yyyy"></td>
</tr>
</table>

<br>

<div id="hidden_div">
<p id=userId><c:out value="${userId}"/></p>
<p id=userIp><c:out value="${userIp}"/></p>
</div>


<input type="button" value="Print" onClick="doPrint()">

</div></div>