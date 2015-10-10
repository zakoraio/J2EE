<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/profilestyle.css" />
<!-- <link href="<c:url value="/css/style.css" />" rel="stylesheet"> -->
<title>Review</title>
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
                    <li><a href=reviewsinstructor.htm>Write a Instructor Review</a></li>
                </ul>
	</div>
                
                
              <div id="leftmenu_bottom"></div>
        </div>
        
        
        
        
		<div id="content">
        
        
       
        
        <div id="content_main">
        	<div class="pic">
					<a href="#"><img src="images/user_avatar.jpg" width="150" height="150" /></a>
					
		    </div>
		    <div class="user">
					<div class="userdata">
					<p id="name">${studentdetails.firstName} ${studentdetails.lastName}</p> <br></br>
					
					<p id="address">${studentdetails.apt} ${studentdetails.street} ${studentdetails.city} ${studentdetails.state} ${studentdetails.zip}</p>
					</div>
					
		    </div>
		    <div class="review">
					<div class="saperator1-y">
		    		</div> 
		    		<div class="saperator2-y">
					</div>
					<p id="reviewtext">Review Score</p>
					<p id="reviewnumber">${studentdetails.reviews}</p>
					</div>
					
	
		    <div class="aboutme">
		    
		    <div class="saperator1-x">
		    		</div> 
		    		<div class="saperator2-x">
		    		</div> 
		    		<p id="aboutmetext">About Me</p>
		    </div>
		    
      </div>
   </div>
     
	</div>
		</div>
	 <div id="content2">
    		<div id="content_main">
        		<div class="pic">
<table border="0" style="width:630px">
  <tr>
    <th border ="0" class="header">Course Name</th>
    <th border ="0" class="header">Department Name</th> 
  </tr>
  <c:forEach items="${coursestaken}" var="courses" varStatus="status">
  <tr>
    <td class="tabletext">${courses.courseName}</td>
    <td class="tabletext">${courses.deptName}</td> 
  </tr>
  </c:forEach>
</table>		
		    	</div>
			</div>	  
		</div>
</body>
</html>
