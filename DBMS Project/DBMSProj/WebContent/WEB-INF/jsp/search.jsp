<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/coursereviewstyle.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/search.js"></script>
<title>Search</title>
</head>

<body>
${message}

<div id="container">

<div id="header">
<h1>Search<span class="off">It</span></h1>
<h2>Type your Query below</h2>
</div>
<div>
<input type="button" value="Search" id="search"  style="width:200px;padding-left:20px;padding-right:100px;height:48px;"></input>
<input type="text" name="query1" id="query" style="width:400px;height:48px;font-size:20px;font-weight:bold;"></input>
</br> <h1 id="querytext"></h1>
</div>
<div id ="content_main">
<div id="loadingImage" style="min-height:100%;display:none">
<img style="padding-top:100px;padding-left:250px" src="images/ajax-loader.gif"  height="120" width="120"></img>
</div>
</div>
</div>

</body>
</html>
