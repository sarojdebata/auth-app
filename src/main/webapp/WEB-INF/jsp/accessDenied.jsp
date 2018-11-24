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
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="font-awesome-css/font-awesome.min.css" rel="stylesheet" type="text/css"/>

<title>Access Denied</title>

</head>

<body style="background-color:red;">
	<center>Access Denied! ....Try After Sometime</center>
	 <span style="float: right;"><a href="/auth-app/logOut"><i class="icon-signout"></i>SignOut</a></span>
</body>
</html>