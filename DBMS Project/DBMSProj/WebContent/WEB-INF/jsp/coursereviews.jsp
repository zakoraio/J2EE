<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/coursereviewstyle.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/coursereview.js"></script>
<title>Instructor Review</title>
</head>

<body>
${message}
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
	<li><a href="reviewsinstructor.htm">Write a Instructor Review</a></li>
</ul>
</div>


<div id="leftmenu_bottom"></div>
</div>


<div id="content">

<div id="deptnamediv">
<table border="0" style="width: 630px">
	<tr>
		<th class="header">Department Name</th>
		<th class="header">Course Name</th>
		<th class="header">Instructor Name</th>
	</tr>
	<tr>
		<td><form:select path="reviewData" id="deptnameselect">
		<form:option value="NONE" label="--- Select ---"/>
		<form:options items="${reviewData.deptNames}" />
		</form:select></td>
		<td><select id="courseselect">
		<option value="NONE">Select</option>
		</select></td>
		<td><select id="instructornameselect">
		<option value="NONE">Select</option>
		</select>
		</td>
	</tr>
</table>
</div>



</div>
<div id="content2" class="hidden">
<div id="reviewdiv" class="hidden">
<div class="user" class="hidden">
					<div class="userdata hidden">
					<p id="name">Saurabh Rai</p> <br></br>
					
					<p id="address">Art and Architectural History and department of neurological sciences</p>
					</div>
					
		    </div>
		    <div class="review hidden">
					<div class="saperator1-y">
		    		</div> 
		    		<div class="saperator2-y">
					</div>
					<p id="reviewtext">Workload</p>
					<p id="workload">32</p>
					</div>
					
	
		    
      </div>

<table id= "cumulativeData" class="tablestyle hidden" border="0">

	<tr>	
		<td><div class="cellbackground"><p class="reviewheader1">#Exams</p></div></td>
		<td id="ExamsAvg" class="reviewvalues">2</td>
	</tr>
	<tr>	
		<td><div class="cellbackground"><p class="reviewheader1">#Quiz</p></div></td>
		<td id="commandAvg" class="reviewvalues">1</td>
	</tr>
	<tr>	
		<td><div class="cellbackground"><p class="reviewheader1">#Projects</p></div></td>
		<td id="InteractionAvg" class="reviewvalues">5</td>
    </tr>
    <tr>	
		<td><div class="cellbackground"><p class="reviewheader1">#Assignements</p></div></td>
		<td id="assignAvg" class="reviewvalues">1</td>
	</tr>
	
</table>
</div>
</div>

<div id="content3">
<div id="reviewcommentsdiv" class="hidden">
<table id="reviewsData" border="0" class="hidden">
	<tr>
		<th class="reviewheader">Student Name</th>
		<th class="reviewheader">Comment</th>	
		<th class="reviewheader">#Exams</th>
		<th class="reviewheader">#Quizes</th>
		<th class="reviewheader">#Projects</th>
		<th class="reviewheader">#Assignements</th>
	</tr>

</table>

</div>
</div>
<div id="content4"></div>
</body>
</html>
