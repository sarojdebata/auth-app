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

<title>School</title>
<script type="text/javascript">
</script>
</head>

<body>

<div>
  <form:form id="contact" action="/auth-app/addSchool" method="post">
  		<div class="form-group">
  			<span style="vertical-align: middle;font-weight: bold;">Enter School Details</span>
  		</div>
  	     <div class="form-group">
            <input type="text"  name="schoolName" class="form-control" id="inputName" placeholder="School Name" required>
        </div>
        <div class="form-group">
            <input type="text" name="schoolAddrs" class="form-control" id="schoolAddress" placeholder="School Address" required>
        </div>
        
         <div class="form-group">
            <input type="date" name="createdDate"  class="form-control" id="createdDate" placeholder="Created Date" required>
        </div> 
        
         <div class="form-group">
            <input type="email" name="email" class="form-control" id="email" placeholder="Email Address" required>
        </div>
        
       <div class="form-group">
            <input type="text" name="fax" class="form-control" id="fax" placeholder="Fax" required>
        </div>
        <div class="form-group">
            <input type="textarea" name="comment" class="form-control" id="comment" placeholder="Comment" required>
        </div> 
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <!-- <button type="button" onclick="javascript:cancel();" class="btn btn-primary">Cancel</button> -->
        <span style="font-weight: bold;"><a href="/auth-app/cancel">Cancel</a></span>
  </form:form>
</div>

</body>
</html>

