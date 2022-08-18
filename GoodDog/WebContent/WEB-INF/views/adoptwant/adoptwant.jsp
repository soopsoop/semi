<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>dog want</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  
</head>
<body class="hold-transition sidebar-mini">



<div>
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1></h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">보호견 관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
	<!-- Main content -->
	<section class="content register-page">
		<div class="register-box" style= "margin-top: -50px;">
			<div class="login-logo">
    			<a href=""><b>보호견 입양 신청</b></a>
  			</div>
			<!-- form start -->
			<div class="card" style="width: 600px; height:500px; position:relative;  justify-content: center;  margin-left:-90px; ">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist" method="post">						
						<div class="input-group mb-3">
							<div class="mailbox-attachments clearfix" style="text-align: center;">
								
									<div class="input-group input-group-sm">
									</div>
							</div> 
							<br />
						  </div>	
						  <div class="form-group row">
							 <label for="wantTitle" class="col-sm-3" style="font-size:1em; margin-top: -40px; margin-bottom: +50px; " >
							 	<span style="color:red;font-weight:bold;">&nbsp;*</span>&nbsp;&nbsp;입양 신청 제목</label>	
							<div class="col-sm-8 input-group input-group-sm"  style=" margin-top: -40px;">
								<input name="wantTitle" 
								type="text" class="form-control" id="wantTitle" >								
							</div>								
						</div>
						<div class="form-group row">
							<label for="memId" class="col-sm-3" style="font-size:1em; margin-bottom: +40px;">
								<span style="color:red;font-weight:bold; ">&nbsp;*</span>&nbsp;&nbsp;회&nbsp;원  &nbsp; 아&nbsp;이&nbsp;디</label>
							<div class="col-sm-8 input-group-sm">								
								<input class="form-control" name="memId" class="form-control" id="memId"/>
							</div>
							
						</div>
						<div class="form-group row">
							<label for="wantContent" class="col-sm-3" style="font-size:1em; margin-bottom: +30px;" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;입양 신청 이유</label>
							<div class="col-sm-7 ">
							</div>
							<input name="wantContent" style="margin-left: +30px; margin-right: +50px; height: 50px;"
								type="text" class="form-control" id="wantContent"  >	
						</div>	
						
						<div class="card-footer">
							<div class="row">								
								<div class="col-sm-6" style=" margin-top: +30px;">
									<button type="button"  id="registBtn" onclick="want_go();" class="btn btn-info ">등&emsp;&nbsp;&nbsp;록</button>
							 	</div>
							 	
							 	<div class="col-sm-6" >
									<button type="button" id="cancelBtn" onclick="window.close();"
										class="btn btn-default float-right" style=" margin-top: +30px;">취 &ensp;&nbsp;소&nbsp;&nbsp;</button>
								</div>
							
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>
		</div>
	</section>		<!-- /.content -->
</div>
<!-- /.content-wrapper -->	



<form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" 
		   style="display:none;" onchange="picture_go();" />
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>

<script>
	
	
	function want_go(){
		//alert("regist btn click");
		if(!$('input[name="wantTitle"]').val()){
		  alert("제목은 필수 기재사항입니다.");
		  return;
		}
	    if(!$('input[name="memId"]').val()){
		  alert("회원 아이디는 필수 기재사항입니다.");
		  return;
	    }
	    if(!$('input[name="wantContent"]').val()){
		  alert("입양 신청이유는 필수 선택사항입니다.");
		  return;
		}
	    var form = $('form[role="form"]');
		form.attr({"method":"post",
		     	   "action":"adoptwant.do"
		   		  });	   
		form.submit();
	}
</script>
  
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js" ></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>
</html>
    





