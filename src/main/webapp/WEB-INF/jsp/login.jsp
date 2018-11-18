<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv='cache-control' content='no-cache'>
<%
String path = request.getContextPath();
System.out.println("contextPath :: "+path);
%>
<!-- Start External Style Sheet -->
<link href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
	
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!-- End External Style Sheet

<!-- Start Custom Style Sheet -->
<link href="mainCss/style.css" rel="stylesheet" type="text/css">
<!-- End Custom Style Sheet -->

<!-- Start External JS -->
 <script src="jquery/jquery-1.12.0.min.js" type="text/javascript"></script> 
 <script src="jquery/jquery-ui.min.js" type="text/javascript"></script>
<script src="bootstrap/bootstrap.js" type="text/javascript"></script>
<script src="bootstrap/bootstrap.min.js" type="text/javascript"></script>
<!-- End External JS -->

<!-- Start Custom JS -->
<script src="js/myApp.js" type="text/javascript"></script>
<!-- End Custom JS -->

<title>Login</title>
<script type="text/javascript">


</script>

</head>

<body style="background-color: aqua;">
<form:form id="frmId" method="POST" action='/auth-app/login'>
	<div id="main" style="display: table;width: 100%" >
	<c:if test="${not empty error}">
		  <div id="errMsg" style="display: block;">
	  		<span style="color: red;">Please Enter Valid User Details</span>
	      </div> 
	</c:if>
		<div id="loginId" >
		 <table style="width: 100%;"> 
		 <tbody>
		 	<tr>
		 	  <td style="float: right;"><span style="font-weight:bold;">User Name:</span><input type="text" id="uname" name="username"  required style="border: solid 1px black;height: 20px"/></td>
		 	</tr>
		 	<tr>
		 	  <td style="float: right;"><span style="font-weight: bold;">Password :</span><input type="password" id="pwd" name="password" required style="border: solid 1px black;height: 20px"/></td>
		 	</tr>
		 	<tr>
		 	  <td><span style="float: right;margin-right: 20%;"><input type="submit" value="LogIn"></span></td>
		 	</tr>
		 </tbody>
		  </table>
		</div>
	</div>
	</form:form>
</body>
</html>