<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<!-- Font Awesome Icons -->
<link rel="stylesheet"	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
	
<!-- include summernote css/js -->
<link href="<%=request.getContextPath()%>/resources/bootstrap/plugins/summernote/summernote.min.css" rel="stylesheet">

<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

</head>
<body>
<div class="login-box">
	<form action="<%=request.getContextPath() %>/findId.do"	method="post" name="fid_frm">
				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="memEmail" placeholder="이메일 입력하세요." value="${memEmail}">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
					
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="memNmame" placeholder="이름을 입력하세요."  value="">
					  <span id="pw_check_msg" ></span> 
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<!-- /.col -->
					<div class="col-sm-4">
						<input type="button" onclick="infoConfirm()" class="btn btn-primary btn-block btn-flat" value="찾기"></button>
					</div>
					<!-- /.col -->
				</div>
			</form>
</div>
			
			<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>

<!-- summernote Editor -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/summernote/summernote.min.js"></script>

<!-- jquery cookie -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

<script>
function infoConfirm() {
	if(document.fid_frm.id.value.length == 0){
		document.getElementById('pw_check_msg').innerHTML = "이메일을 입력해주세요!";
		log_frm.id.focus();
		return;
	}
	if(document.fid_frm.pwd.value.length == 0){
		document.getElementById('pw_check_msg').innerHTML = "이름을 입력해주세요!";
		log_frm.pwd.focus();
		return;
	}
	document.fid_frm.submit();
	if (document.getElementById('pw_check_msg')==null) {
		window.close();	
	}
}
	document.getElementById('pw_check_msg').innerHTML = "${message}";
</script>

</body>
</html>