<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/reviewstyle.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/giveinstructorreview.js"></script>
<title>Instructor Review</title>
</head>

<body>

<div id="container">
<div id="header">
<h1>Choose<span class="off">Wisely</span></h1>
<h2>Do you really want to take this course</h2>
</div>

<div id="menu">
<ul>
	<li class="menuitem"><a href="#">Home</a></li>
	<li class="menuitem"><a href="reviews.htm">Instructor Reviews</a></li>
	<li class="menuitem"><a href="coursereviews.htm">Course Reviews</a></li>
	<li class="menuitem"><a href="#">About</a></li>
</ul>
</div>

<div id="leftmenu">

<div id="leftmenu_top"></div>

<div id="leftmenu_main">

<h3>Links</h3>

<ul>
	<li><a href="profile.htm">Profile</a></li>
	<li><a href="reviewscourse.htm">Write a Course Review</a></li>
	<li><a href="reviews.htm">Write a Instructor Review</a></li>
</ul>
</div>


<div id="leftmenu_bottom"></div>
</div>


<div id="content">

<div id="deptnamediv">
<table border="0" style="width: 630px">
	<tr>
		<th class="header">Department Name</th>
		<th class="header">Instructor Name</th>
		<th class="header">Course Name</th>
	</tr>
	<tr>
		<td><form:select path="reviewData" id="deptnameselect">
		<form:option value="NONE" label="--- Select ---"/>
		<form:options items="${reviewData.deptNames}" />
		</form:select></td>
		<td><select id="instructornameselect">
		<option value="NONE">Select</option>
		</select></td>
		<td><select id="courseselect">
		<option value="NONE">Select</option>
		</select>
		</td>
	</tr>
</table>
</div>



</div>
<div id="content2" class="hidden">
<div id="reviewdiv" class="hidden">
<div class="data">
<form:form id="review" method="post" action="giveinstructorreviews.htm" >
<table>
<tr>
<td><div class="reviewheader1">Knowledge</div></td>
<td><div class="reviewheader1"><form:input path="knowledge" maxlength="4" size="4"></form:input></div></td>
<td><div class="reviewheader1">Teaching Aptitude</div></td>
<td><div class="reviewheader1"><form:input path="teaching" maxlength="4" size="4"></form:input></div></td>
<td><div class="reviewheader1">Interaction With Students</div></td>
<td><div class="reviewheader1"><form:input path="interaction" maxlength="4" size="4"></form:input></div></td>
</tr>
</table>
<div class="reviewheader1">Describe your view in words</div>
<form:textarea path ="comment" rows="5" cols="84" id="reviewcomment"></form:textarea>
<form:hidden id = "offeringid" path="offeringId" />
<input id="submit" class="submitbutton" type="submit" value="Submit Review"/>
 </form:form>
</div>
</div>
</div>
</div>
</body>
</html>
