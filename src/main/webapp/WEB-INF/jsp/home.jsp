<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
        <meta charset="utf-8">
        <meta http-equiv='cache-control' content='no-cache'>
		<meta http-equiv='expires' content='0'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv='cache-control' content='no-cache'>

<!-- Grid Plugins -->
<link  href="css/jquery-ui.css" rel="stylesheet" type="text/css"/>
<link  href="css/ui.jqgrid.css" rel="stylesheet" type="text/css"/>

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="mainCss/style.css" rel="stylesheet" type="text/css"/>
<link href="css/appCss/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="css/simple-sidebar.css" rel="stylesheet" type="text/css"/>


<style>
		html {
			overflow : auto !important;
		}
	</style>
	

<script src="jquery/jquery-1.12.0.min.js" type="text/javascript"></script> 
 <script src="jquery/jquery-ui.min.js" type="text/javascript"></script>
 <!-- Grid Plugins -->

<script src="jquery/i18n/grid.locale-en.js" type="text/javascript"></script>
<script src="jquery/jquery.jqGrid.src.js" type="text/javascript"></script>
<script src="jquery/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="jquery/jquery-ui.js" type="text/javascript"></script>

<script src="bootstrap/bootstrap.min.js" type="text/javascript"></script>
<script src="js/myApp.js" type="text/javascript"></script> 



<script type="text/javascript">
$(document).ready(function()
		{ 
			$('#abtId').hide();
			$('#uId').hide();
		});
		
		
</script>

<title>Home</title>
 
</head>
   <%--  <c:set var="uName" value="${user.userName}" scope="application"/>
    <c:set var="pass" value="${user.password}" scope="application"/> --%>
    <%
    /* ServletContext context = request.getSession().getServletContext();
	    context.setAttribute("username",request.getAttribute("uName"));
	    context.setAttribute("password",request.getAttribute("pass")); */
    %>
<body>
<input type="hidden" id="userDtls" >
<input type="hidden" id="schlIdAndName" >
<div id="header">
    <%@ include file="/WEB-INF/jsp/header.jsp"%>
</div>

   <span style="float: right;"><a href="/auth-app/logOut"><i class="icon-signout"></i>SignOut</a></span>

          <div class="wrapper">
            <!-- Sidebar Holder -->
            <nav id="sidebar">
                <div class="sidebar-header">
                    <h3><i class="icon-dashboard"></i>DashBoard</h3>
                </div>
				
                <ul class="list-unstyled components">
                    <li class="active">
                       <%-- <a href="#" onclick="homeSubMenu('<%=context.getAttribute("username")%>','<%=context.getAttribute("password")%>');"> --%>
                       <a href="#" onclick="homeSubMenu('<%=session.getAttribute("username")%>','<%=session.getAttribute("password")%>');">
                            <i class="icon-home"></i>
                            Home
                        </a>
                    </li>
                    <li>
                        <a href='#' onclick="about();">
                            <i class="icon-info-sign"></i>
                            About
                        </a>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false">
                            <i class="icon-building"></i>
                            School
                        </a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li><a href="#" onclick="javascript:schoolDetails();">School Details</a></li>
                            <li><a href="#">Teacher Details</a></li>
                            <li><a href="#">Student Details</a></li>
                            
                        </ul>
                    </li>
                    <li>
                        <a href="#onboardSubmenu" data-toggle="collapse" aria-expanded="false">
                            <i class="icon-tasks"></i>
                            Onboard
                        </a>
                        <ul class="collapse list-unstyled" id="onboardSubmenu">
                            <li><a href="/MyPortal/onboardSchool">School</a></li>
                            <li><a href="/MyPortal/onboardTeacher">Teacher</a></li>
                            <li><a href="/MyPortal/onboardStudent">Student</a></li>
                            <li><a href="/MyPortal/onboardClass">Class</a></li>
                            <li><a href="/MyPortal/onboardSubject">Subject</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="/MyPortal/faQ">
                            <i class="icon-cloud"></i>
                            FAQ
                        </a>
                    </li>
                    <li>
                        <a href="/MyPortal/contact">
                            <i class="icon-pencil"></i>
                            Contact
                        </a>
                    </li>
                </ul>

            </nav>

            	<!-- Page Content Holder -->
                        <div id="content">
                        	<table id="welId">
                        	<tbody>
                        	  <tr>
                        	    <td>Welcome <%=session.getAttribute("username")%></td>
                        	    <td>
                        	    </tr>
                        	    <tr>
                        	    <td>
								<c:choose>
								    <c:when test="${add.constant == 1 }">
								        <p><c:out value="${add.constname}" /> School Details Saved Successfully</p>
								        <br />
								    </c:when>  
									<c:when test="${add.constant == 2 }">
								        <p><c:out value="${add.constname}" /> Teacher Details Saved Successfully</p>
								        <br />
								    </c:when>
								    <c:when test="${add.constant == 3 }">
								        <p><c:out value="${add.constname}" /> Student Details Saved Successfully</p>
								        <br />
								    </c:when>
								    <c:when test="${add.constant == 4 }">
								        <p><c:out value="${add.constname}" /> Class Details Saved Successfully</p>
								        <br />
								    </c:when>  
								    <c:when test="${add.constant == 5 }">
								        <p><c:out value="${add.constname}" /> Subject Details Saved Successfully</p>
								        <br />
								    </c:when>
								    <c:otherwise>
								        <br />
								    </c:otherwise>
								</c:choose>															
								</td>
                        	  </tr>
                        	</tbody>
                        	</table>
							
							<table id="uId" style="display: none;">
               			 	  <tbody>
               			 	     <tr>
               			 	     	<td>User Name:</td>
               			 	     	<td id="usrId"></td>
               			 	     </tr>
               			 	     <tr>
               			 	     	<td>Created Date:</td>
               			 	     	<td id="usrCrtDt"></td>
               			 	     </tr>
               			 	  </tbody>
               			 	</table>
							
							<div id="abtId">
							<p> School of Information we have faculty and students engaged in research and education around all aspects of the information sciences without regard for disciplinary boundaries. We do research in: artificial intelligence; data management and curation; computer vision; computer-mediated communication and learning; natural language processing; social networking; human computer interfaces; dark networks; computational art creation; eCommerce, eGovernment, and eHealth; computational music; library sciences; educational and entertainment technologies; and much more.</p>
							</div>

						<table id="schlDtlsId" style="display: none;">
						</table>
							<div id="jqGridPager"></div>
							
               			 </div>
                </div>

<div id="footer">
   <%@ include file="/WEB-INF/jsp/footer.jsp"%>
</div>
</body>
</html>