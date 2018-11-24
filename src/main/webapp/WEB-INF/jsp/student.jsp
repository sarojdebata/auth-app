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
<link href="css/school.css" rel="stylesheet" type="text/css"/>
<!-- End External Style Sheet -->

<!-- Start Custom Style Sheet -->
<link href="mainCss/style.css" rel="stylesheet" type="text/css">
<!-- End Custom Style Sheet -->

<!-- Start External JS -->
 <script src="jquery/jquery-1.12.0.min.js" type="text/javascript"></script> 
 <script src="jquery/jquery-ui.min.js" type="text/javascript"></script>
 <script src="jquery/ui-jqueryui.js" type="text/javascript"></script> 
<script src="bootstrap/bootstrap.js" type="text/javascript"></script>
<script src="bootstrap/bootstrap.min.js" type="text/javascript"></script>
<!-- End External JS -->

<!-- Start Custom JS -->
<script src="js/myApp.js" type="text/javascript"></script>
<!-- End Custom JS -->
<script type="text/javascript">
$(document).ready(function()
		{ 
			getSchoolIdAndName();
		});
</script>
<title>Student</title>
<script type="text/javascript">
</script>
</head>
<body>

<div>
  <form:form id="contact" action="/auth-app/addStudent" method="post">
  		<div class="form-group">
  			<span style="vertical-align: middle;font-weight: bold;">Enter Student Details</span>
  		</div>
  	     <div class="form-group">
            <input type="text"  name="firstName" class="form-control" id="firstName" placeholder="First Name" required>
        </div>
        <div class="form-group">
            <input type="text" name="lastName" class="form-control" id="lastName" placeholder="last Name" required>
        </div>
        <div class="form-group">
            <input type="text" name="studentAddrs" class="form-control" id="studentAddrs" placeholder="Address" required>
        </div>
        <div class="form-group">
        	<select class="form-control" id="schlIdAndName" name="schlIdAndName" placeholder="SchoolName">
        	</select>
        </div>
         <div class="form-group">
            <input type="date" name="cretdDate"  class="form-control" id="cretdDate" placeholder="Created Date" required>
        </div> 
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <span style="font-weight: bold;"><a href="/auth-app/cancel">Cancel</a></span>
  </form:form>
</div>

</body>
</html>

