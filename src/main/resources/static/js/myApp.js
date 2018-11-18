var schooIdAndName = null;
var teacherIdAndName = null;
var classIdAndName = null;
var schoolDetailsVal = null;

function validateUser() {
	var uName = $('#uname').val();
	var pass = $('#pwd').val();
	console.log('uName ::' + uName);
	console.log('pass  ::' + pass);
	if (uName == null || uName == '' || uName == 'undefined') {
		$('loginId').html("Please enter name");
	}
	if (pass == null || pass == '' || pass == 'undefined') {
		$('loginId').html("Please enter Password");
	}

	action = '/MyPortal/login';
	/*if(uName !=null && uName!=='undefined' && uName !=''
	&& pass !=null && pass !=='undefined' && pass !=''){
	login(uName,pass);
	}*/
}

function homeSubMenu(username, password) {
	console.log("inside homeSubMenu ");
	getHomeSubMenu(username, password);
	$("#userDtls").data("userDetails", userDetails);

	$('#welId').hide();
	$('#abtId').hide();
	$('#schlDtlsId').hide();
	$('#gbox_schlDtlsId').hide();
	
	$('#uId').show();
	var userInfoDetails = $("#userDtls").data("userDetails");

	var obj = JSON.parse(userInfoDetails);
	console.log(obj);
	$('#usrId').html(obj.dtls.userName);
	$('#usrCrtDt').html(obj.dtls.createdDateTime);
}

function getHomeSubMenu(username, password) {
	console.log("inside getHomeSubMenu ");
	console.log('username ::' + username + 'password ::' + password);
	$.ajax({
		type: "GET",
		url: "/MyPortal/homeSubmenu?userName=" + username + "&password=" + password,
		async: false,
		cache: false,
		success: function (data) {
			userDetails = data;
			console.log(userDetails);
		},
		error: function () {
			console.log("Unable to invoke the service");
		}
	});
}

function about() {
	$('#welId').hide();
	$('#uId').hide();
	$('#gbox_schlDtlsId').hide();
	
	aboutCall();
	$('#abtId').show();
}

function aboutCall() {
	$.ajax({
		type: "GET",
		url: "/auth-app/about",
		async: false,
		cache: false,
		success: function () {
			return;
		},
		error: function () {
			console.log("Unable to invoke the service");
		}
	});
}

function schoolFormDataSubmit() {
	$('#welId').hide();
	$('#uId').hide();
	$('#abtId').hide();
	schoolFormDataSubmitCall();
}

function schoolFormDataSubmitCall() {
	console.log("inside schoolFormDataSubmitCall");
	$.ajax({
		type: "GET",
		url: "/MyPortal/onboardSchool",
		async: false,
		cache: false,
		success: function () {
			return;
		},
		error: function () {
			console.log("Unable to invoke the service");
		}
	});
}

function getSchoolIdAndName() {
	console.log("inside getSchoolIdAndName");
	var dropDownHtml = "";
	getSchoolIdAndNameDetails();
	//$( "#schlIdAndName").data( "schoolIdAndName", schooIdAndName );

	//var schoolIdAndNameDtls = $("#schoolIdAndName").data("schooIdAndName");
	console.log(schooIdAndName);
	var obj = JSON.parse(schooIdAndName);

	//var idAndName = obj.scIdNm;
	console.log(obj);

	if (obj != null && obj !== 'undefined') {
		for (var key in obj) {
			dropDownHtml += "<option value='" + key + "'>" + obj[key] + "</option>";
		}
	}

	$("#schlIdAndName").html(dropDownHtml);
	$("#schlIdAndName").prepend("<option disabled selected value=''>--Select SchoolName--</option>").val('');
	console.log("Exit getSchoolIdAndName");
}

function getSchoolIdAndNameDetails() {
	console.log("inside getSchoolIdAndNameDetails ");
	$.ajax({
		type: "GET",
		url: '/MyPortal/getSchoolIdAndName',
		async: false,
		cache: false,
		success: function (data) {
			schooIdAndName = data;
		},
		error: function () {
			console.log("Unable to invoke the service");
		}
	});
}

function getTeacherIdAndName() {
	console.log("inside getTeacherIdAndName");
	var teacherDownHtml = "";
	getTeacherIdAndNameDetails();
	console.log(teacherIdAndName);
	var obj = JSON.parse(teacherIdAndName);

	console.log(obj);

	if (obj != null && obj !== 'undefined') {
		for (var key in obj) {
			teacherDownHtml += "<option value='" + key + "'>" + obj[key] + "</option>";
		}
	}

	$("#teacherName").html(teacherDownHtml);
	$("#teacherName").prepend("<option disabled selected value=''>--Select TeacherName--</option>").val('');
	console.log("Exit getTeacherIdAndName");
}

function getTeacherIdAndNameDetails() {
	console.log("inside getTeacherIdAndNameDetails ");
	$.ajax({
		type: "GET",
		url: '/MyPortal/getTeacherIdAndName',
		async: false,
		cache: false,
		success: function (data) {
			teacherIdAndName = data;
		},
		error: function () {
			console.log("Unable to invoke the service");
		}
	});
}

function getClassIdAndName() {
	console.log("inside getClassIdAndName");
	var classDownHtml = "";
	getClassIdAndNameDetails();
	console.log(classIdAndName);
	var obj = JSON.parse(classIdAndName);

	console.log(obj);

	if (obj != null && obj !== 'undefined') {
		for (var key in obj) {
			classDownHtml += "<option value='" + key + "'>" + obj[key] + "</option>";
		}
	}

	$("#className").html(classDownHtml);
	$("#className").prepend("<option disabled selected  value=''>--Select ClassName--</option>").val('');
	console.log("Exit getTeacherIdAndName");
}

function getClassIdAndNameDetails() {
	console.log("inside getClassIdAndNameDetails ");
	$.ajax({
		type: "GET",
		url: '/MyPortal/getClassIdAndName',
		async: false,
		cache: false,
		success: function (data) {
			classIdAndName = data;
		},
		error: function () {
			console.log("Unable to invoke the service");
		}
	});
}

function schoolDetails() {
	console.log("inside schoolDetails");
	
	$('#abtId').hide();
	$('#uId').hide();
	
	$("#welId").css("display", "none");
	$('#gbox_schlDtlsId').show();
	$("#schlDtlsId").css("display", "block");
	

  /*  //Clear result div
    $("#schlDtlsId").html("");

    //Crate table html tag
    var table = $("<table id=schoolDetails border=2></table>").appendTo("#schlDtlsId");

    //Create table header row
    var rowHeader = $("<tr></tr>").appendTo(table);
    $("<td></td>").text("School Name").appendTo(rowHeader);
    $("<td></td").text("School Address").appendTo(rowHeader);
    $("<td></td>").text("Email Id").appendTo(rowHeader);
    $("<td></td>").text("Fax").appendTo(rowHeader);

    //Get JSON data by calling action method in controller
    if (obj != null && obj !== 'undefined') {
		for (var key in obj) {
            //Create new row for each record
            var row = $("<tr></tr>").appendTo(table);
            $("<td></td>").text(obj[key].schoolName).appendTo(row);
            $("<td></td>").text(obj[key].schoolAddrs).appendTo(row);
            $("<td></td>").text(obj[key].email).appendTo(row);
            $("<td></td>").text(obj[key].fax).appendTo(row);
		}
    }
*/    
	
	$("#schlDtlsId").jqGrid({
		
		colModel : [ {
			label: 'School Name',
			name : 'schoolId',
			index : 'schoolId',
			width : 100
		}, {
			label: 'School Address',
			name : 'schoolName',
			index : 'schoolName',
			width : 150,
			editable : true
		}, {
			label: 'Email Id',
			name : 'email',
			index : 'schoolAddrs',
			width : 150,
			editable : true
		}, {
			label: 'Fax',
			name : 'fax',
			index : 'fax',
			width : 150,
			editable : true
		} ],
		
		 width: 780,
         height: 200,
         rowNum: 15,
         viewrecords : true,
         pager : '#jqGridPager',
		gridview : true,
		datatype : "local",
		caption : 'School Details',
		jsonReader : {
			repeatitems : false,
		}
		//editurl : "GridServlet"
	});
	jQuery("#schlDtlsId").jqGrid('navGrid', '#jqGridPager', {
		edit : true,
		add : true,
		del : true,
		search : true
	});
	
	getSchoolDetails();
	
	function getSchoolDetails() {
		console.log("inside getSchoolDetails");
		var gridArrayData = [];
		$("#schlDtlsId")[0].grid.beginReq();
		
		$.ajax({
			type: "GET",
			url: '/MyPortal/schoolDetails',
			async: false,
			cache: false,
			success: function (result) {
				var obj = JSON.parse(result);
				 for (var i = 0; i < obj.length; i++) {
                     gridArrayData.push({
                    	 schoolId: obj[i].schoolId,
                    	 schoolName: obj[i].schoolName,
                    	 email: obj[i].email,
                    	 fax: obj[i].fax
                     });                            
                 }
				// set the new data
					$("#schlDtlsId").jqGrid('setGridParam', { data: gridArrayData});
					// hide the show message
					$("#schlDtlsId")[0].grid.endReq();
					// refresh the grid
					$("#schlDtlsId").trigger('reloadGrid');
			},
			error: function () {
				console.log("Unable to invoke the service");
			}
		});
	}
	
	console.log("Exit schoolDetails");
}


