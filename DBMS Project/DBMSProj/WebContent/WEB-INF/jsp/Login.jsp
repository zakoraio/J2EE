<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>


  <title>Login</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link rel="stylesheet" type="text/css" href="css/LoginStyle.css" />

    <script src="js/prefixfree.min.js"></script>

</head>

<body>

  <div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div>Choose<span>Wisely</span></div>
		</div>
		<br>
		<div class="login">
		<form:form id ="loginform" method ="post" action="checkLogin.htm"> 
				<form:input type="text" placeholder="username" path="userName"></form:input><br>
				<form:input type="password" placeholder="password" path="passWord"></form:input><br>
				<input type="submit" value="Login"></input>
		</form:form>
		</div>

  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

</body>

</html>