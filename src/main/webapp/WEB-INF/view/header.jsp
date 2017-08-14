
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>APMS</title>
	<link type="text/css" rel="stylesheet" href="/bootstrap-3.0.3/css/bootstrap.min.css"/>
	<link type="text/css" rel="stylesheet" href="/easypiechart/_styles/easypiechart.css"/>
	<link type="text/css" rel="stylesheet" href="/css/main.css"/>
	
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/easypiechart/_scripts/easypiechart.js"></script>
	<script type="text/javascript" src="/bootstrap-3.0.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/main.js"></script>	

</head>

<body>
	<div class="container-fluid">
		<div class="mainmenu-area">
			<nav class="navbar navbar-default">
			  <div class="container-fluid clearfix">
			    <div class="navbar-header logo">
			      <strong><a class="navbar-brand" href="#">APMS</a></strong>
			    </div>
			    <ul class="nav navbar-nav pull-right">
				    <li>
				    <form class="navbar-form search-form" role="search">
					    <div class="input-group add-on">
					      <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
					      <div class="input-group-btn">
					        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
					      </div>
					    </div>
					  </form>
					</li>
		            <li class="active"><a href="/projects"><span class="glyphicon glyphicon-home"></span> Home</a></li>
			      	<li><a href="#"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
		            <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			    </ul>
			  </div>
			</nav>
	    </div> <!-- End mainmenu area -->
	    <div class="container-fluid content">
		  <div class="row">
		    <div class="col-sm-3 col-lg-2">
		      <nav class="navbar navbar-default navbar-fixed-side side-bar">
		        <div class="container-fluid">
				    <div class="collapse navbar-collapse" id="myNavbar">
				      <ul class="nav navbar-nav navbar-left main-nav space-sm-bottom">
				        <li class="active"><a href="/projects">Projects</a></li>
				        <li><a href="#">Agile Board</a></li>
				        <li><a href="#">Releases</a></li>
				        <li><a href="#">All Issues</a></li>
				        <li><a href="#">Components</a></li>
				      </ul>
				      <ul class="list-unstyled">
				        <li><a href="#" class="green-txt">Users Management</a></li>
				        <li><a href="#" class="green-txt">Teams Management</a></li>
				        <li><a href="/projects/manage" class="green-txt">Projects Management</a></li>
				      </ul>
				    </div>
				  </div>
		      </nav>
		    </div>
		    <div class="col-sm-9 col-lg-10">