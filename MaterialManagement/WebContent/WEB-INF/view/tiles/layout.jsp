<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  

<html>  

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Setting root of web application so that we can reference URL's relatively -->
<spring:url value="/" var="root" />

<!-- Styling for page elements -->
<spring:url value="/resources/layout.css" var="layoutCSS" />
<link href="${layoutCSS}" rel="stylesheet" />
<spring:url value="/resources/menu.css" var="menuCSS" />
<link href="${menuCSS}" rel="stylesheet" />
<spring:url value="/resources/tables.css" var="contentCSS" />
<link href="${contentCSS}" rel="stylesheet" />

<!-- Customised CSS Button -->
<spring:url value="/resources/button.css" var="buttonCSS" />
<link href="${buttonCSS}" rel="stylesheet" />

<!-- jQuery Base, UI and Validation -->
<spring:url value="/resources/jquery-1.8.2.min.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/resources/jquery.validate.min.js" var="jQueryValidation" />
<script src="${jQueryValidation}"></script>
<spring:url value="/resources/additional-methods.js" var="jQueryValidationAdditional" />
<script src="${jQueryValidationAdditional}"></script>
<spring:url value="/resources/jquery-ui.min.js" var="jQueryUI" />
<script src="${jQueryUI}"></script>
<spring:url value="/resources/jquery-ui.min.css" var="jQueryUICSS" />
<link href="${jQueryUICSS}" rel="stylesheet" />

<spring:url value="/resources/bootstrap.min.css" var="BootstrapCSS" />
<link href="${BootstrapCSS}" rel="stylesheet" />
<spring:url value="/resources/jquery.min.js" var="jQueryM" />
<script src="${jQueryM}"></script>
<spring:url value="/resources/bootstrap.min.js" var="BootstrapM" />
<script src="${BootstrapM}"></script>

<!-- jQuery Data tables-->
<spring:url value="/resources/js/jquery.dataTables.min.js" var="jQueryDatatables" />
<script src="${jQueryDatatables}"></script>
<spring:url value="/resources/js/dataTables.jqueryui.min.js" var="jQueryDatatablesStyling" />
<script src="${jQueryDatatablesStyling}"></script>
<spring:url value="/resources/js/scrolling.js" var="jQueryDatatablesPluginScrolling" />
<script src="${jQueryDatatablesPluginScrolling}"></script>
<spring:url value="/resources/css/dataTables.jqueryui.min.css" var="jQueryDatatablesStylingCSS" />
<link href="${jQueryDatatablesStylingCSS}"></link>

<!-- MomentJS : Library containing useful date functions  -->
<spring:url value="/resources/moment.min.js" var="momentJS" />
<script src="${momentJS}"></script>

<!-- List.js : Library containing useful DOM manipulations on lists  -->
<spring:url value="/resources/list.min.js" var="listJS" />
<script src="${listJS}"></script>

<!-- Images -->
<spring:url value="/resources/background2.jpg" var="bgimg" />



<style type="text/css">
/* Setting style for jQuery Validation error messages */
label.error{float:none; color:red; padding-left:0.5em; vertical-align:top;}

/* Customizing global jQueryUI tabs looks */
.ui-tabs .ui-tabs-nav
{font-size:80%;}
.ui-tabs .ui-tabs-panel
{font-size:80%; background: lightgrey;}

/* Customizing global jQueryUI accordion looks */
.ui-accordion .ui-accordion-header 
{font-size:80%;}
.ui-accordion-content 
{background: lightblue;}

/* Customizing accordian looks */
#accordion
{font-size:100%;}

/* Customizing container looks */
#container
{font-size:100%;}
</style>

<!-- Scripts that are used by the pages -->
<script>
//<!-- Tabs -->
$(document).ready(function() {
$("#tabs").tabs();
});

//<!-- Accordion -->
$(document).ready(function() {
	$( "#accordion" ).accordion({
		collapsible: true
		//,active: true
	});
});

//<!-- Container : A jQueryUI accordion that servers as a simple container -->
$(document).ready(function() {
	$( "#container" ).accordion({
		collapsible: false
		,active: false
	});
});

//<!-- Date-picker -->
$(document).ready(function() {
    $( "#datepicker" ).datepicker({
       dateFormat:"dd/mm/yy"
    });
 });
$(document).ready(function() {
    $( "#datepicker1" ).datepicker({
       dateFormat:"dd/mm/yy"
    });
 });
$(document).ready(function() {
    $( "#datepicker2" ).datepicker({
       dateFormat:"dd/mm/yy"
    });
 });
 
//<!-- Form-Validation -->
$(document).ready(function() {
	$("#vform").validate({
	});
});

//<!-- Data-Table -->
$(document).ready(function() {
    $('#dtable').DataTable({
    	"paging":   true
    	,"pagingType": "scrolling"
        //,"pagingType": "simple"
         
    });
});
$(document).ready(function() {
    $('#dtable1').DataTable({
    	"paging":   true
    	,"pagingType": "scrolling"
        //,"pagingType": "simple"
        ,"order": [[ 5, "asc" ]]
               
    });
});
$(document).ready(function() {
    $('#dtable2').DataTable({
    	"paging":   true
    	,"pagingType": "scrolling"
        //,"pagingType": "simple"
    });
});
$(document).ready(function() {
    $('#dtable3').DataTable({
    	"paging":   true
    	,"pagingType": "scrolling"
        //,"pagingType": "simple"
    });
});
$(document).ready(function() {
    $('#dtable4').DataTable({
    	"paging":   true
    	,"pagingType": "scrolling"
        //,"pagingType": "simple"
    });
});
$(document).ready(function() {
    $('#dtable5').DataTable({
    	"paging":   true
    	,"pagingType": "scrolling"
        //,"pagingType": "simple"
    });
});
$( "#button" ).button();
$( "#spinner" ).spinner();
$( "#selectmenu" ).selectmenu();
$( "#tooltip" ).tooltip();

//Hides the autoHidesIn3s div after 3 seconds of page load
$(document).ready(function()
{
	setTimeout(function(){document.getElementById("autoHidesIn3s").style.display = "none";}, 3000);
});

$(document).ready(function(){
    $.fn.dataTable.ext.search.push(
    function (settings, data, dataIndex) {
        var min = $('#min').datepicker("getDate");
        var max = $('#max').datepicker("getDate");
        //var startDate = new Date(data[4]);
        var startDate = '<c:out value="${sentdate}"/>';
        if (min == null && max == null) { return true; }
        if (min == null && startDate <= max) { return true;}
        if(max == null && startDate >= min) {return true;}
        if (startDate <= max && startDate >= min) { return true; }
        return false;
    }
    );

   
        $("#min").datepicker({ onSelect: function () { table.draw(); }, changeMonth: true, changeYear: true });
        $("#max").datepicker({ onSelect: function () { table.draw(); }, changeMonth: true, changeYear: true });
        var table = $('#dtable1').DataTable();

        // Event listener to the two range filtering inputs to redraw on input
        $('#min, #max').change(function () {
            table.draw();
        });
    });

</script>

<title>
<tiles:insertAttribute name="title" ignore="true" />
</title>  

</head>  


<body background=<c:out value="${bgimg}"/>>  
        <div class="header">
        <tiles:insertAttribute name="header" />
        </div>  
        
     
        
    <div>
        <!-- Print success message from previous operation -->
        <div id="autoHidesIn3s">
		<c:if test="${success_message != null}">
			<div class="ui-widget">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
			<p><strong><c:out value="${success_message}"/></strong></p>
			</div>		
			<br>
			</div>
		</c:if>
		</div>
		
        <tiles:insertAttribute name="body" />
        </div>
        
        
</body>  
</html>  