<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css">

<title>I'm hungry</title>

<!--  <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.10/css/jquery.dataTables.css">   -->

<script type="text/javascript" src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="//cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>

<script type="text/javascript">

//Plug-in to fetch page data 
jQuery.fn.dataTableExt.oApi.fnPagingInfo = function ( oSettings )
{
	return {
		"iStart":         oSettings._iDisplayStart,
		"iEnd":           oSettings.fnDisplayEnd(),
		"iLength":        oSettings._iDisplayLength,
		"iTotal":         oSettings.fnRecordsTotal(),
		"iFilteredTotal": oSettings.fnRecordsDisplay(),
		"iPage":          oSettings._iDisplayLength === -1 ?
			0 : Math.ceil( oSettings._iDisplayStart / oSettings._iDisplayLength ),
		"iTotalPages":    oSettings._iDisplayLength === -1 ?
			0 : Math.ceil( oSettings.fnRecordsDisplay() / oSettings._iDisplayLength )
	};
};

$(document).ready(function(){
    $('#myTable').DataTable({        
        "bProcessing": true,
        "bServerSide": true,
        "sort": "position",
        "fnDrawCallback": function () {
            //Get page numer on client. Please note: number start from 0 So
            //for the first page you will see 0 second page 1 third page 2...
            //Un-comment below alert to see page number
        	//alert("Current page number: "+this.fnPagingInfo().iPage);    
        },         
        "sAjaxSource": "cooksList",
        "aoColumns": [
            { "mData": "id" },
            { "mData": "name" },
            { "mData": "email" },
            { //"mData": "action",
                "defaultContent": "-",
                "targets": "_all",
                "bSortable": false,
                "sClass": "text-center",
            	"fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                    $(nTd).html(               
                    		"<a href='/imhungry/edit/" + oData.id + "' class='btn btn-info btn-sm glyphicon glyphicon-info-sign'></a>&nbsp;" +
                    		"<a href='/imhungry/edit/" + oData.id + "' class='btn btn-success btn-sm glyphicon glyphicon-pencil'></a>&nbsp;" +
                            "<a href='/imhungry/remove/" + oData.id + "' class='btn btn-warning btn-sm glyphicon glyphicon-trash'></a>"                    	
                    );
                }	
            },
        ],    	
    	//bStateSave variable you can use to save state on client cookies: set value "true" 
        "bStateSave": true,
        //Default: Page display length
        "iDisplayLength": 5,
        //We will use below variable to track page number on server side(For more information visit: http://legacy.datatables.net/usage/options#iDisplayStart)
        "iDisplayStart": 0,
    //    "info": false,
        "processing": true,
    //    "scrollCollapse": false,
         searching: false,
        "bLengthChange": false,
        "bAutoWidth": false ,
        "bDeferRender": true,    
        "sPaginationType": "full_numbers",              
        "oLanguage": {
            "oPaginate": {
                "sFirst": "&laquo;", // This is the link to the first page
                "sPrevious": "&lsaquo;", // This is the link to the previous page
                "sNext": "&rsaquo;", // This is the link to the next page
                "sLast": "&raquo;", // This is the link to the last page
                "sInfoFiltered": " of _MAX_ entries",
            }
        }
    });
});


</script>
</head>
<body>

<div class="container">
  <div class="page-header">
    <h1>I'm hungry</h1>      
  </div>
  <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">I'm hungry</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Orders</a></li>
        <li><a href="<c:url value='/cooks'/>">Cooks</a></li>
        <li><a href="#">Users</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span>&nbsp;Sign Up</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span>&nbsp;Login</a></li>
      </ul>
    </div>
  </div>
    
</nav>     
</div>
     <div class="container">
         <a href="<c:url value='/cooks'/>" class="btn btn-lg btn-primary glyphicon glyphicon-cutlery"></a> 
         
        <br>	
        <br>
            	
    <table id="myTable" class="table table-striped table-condensed" cellspacing="0" width="100%">
    <!-- class="row-border">  --> 
    <thead>
    <tr>
        <th width="10%">id</th>
        <th width="35%">name</th>
        <th width="35%">email</th>
        <th width="20%">action</th>
    </tr>
    </thead>
    <tbody>
    </tbody>     

    </table>
</div>
   		
         	
</body>
</html>


       