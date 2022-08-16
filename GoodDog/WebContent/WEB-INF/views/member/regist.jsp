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
  <title>AdminLTE 3 | Starter</title>

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
	  				<h1>회원가입</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">회원관리</i>
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
		<div class="register-box">
			<div class="login-logo">
    			<a href=""><b>회원 가입</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist" method="post">						
						<!-- <input type="hidden" name="picture" />
						<div class="input-group mb-3">
							<div class="mailbox-attachments clearfix" style="text-align: center;">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
								<div class="mailbox-attachment-info">
									<div class="input-group input-group-sm">
										<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
										<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
										<span class="input-group-append-sm">											
											<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
										</span>
									</div>
								</div>
							</div>
							<br />
						  </div> -->	
						  <div class="form-group row">
							 <label for="memId" class="col-sm-3" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*</span>아이디</label>	
							<div class="col-sm-9 input-group input-group-sm">
								<input name="memId" 
									onkeyup="this.value=this.value.replace(/['~!@#$%^&*()_|+\-=?;:'<>\{\}\[\]\\\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);"
								type="text" class="form-control" id="memId" placeholder="13글자 영문자,숫자 조합">
								<span class="input-group-append-sm">	
									<button type="button" onclick="idCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
								</span>								
							</div>								
						</div>
						<div class="form-group row">
							<label for="memPw" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>패스워드</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="memPw" type="password" class="form-control" id="memPw"
										placeholder="20글자 영문자,숫자,특수문자 조합" />
							</div>
							
						</div>
						<div class="form-group row">
							<label for="memName" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>이 름</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="memName" type="text" class="form-control" id="memName"
										placeholder="이름을 입력하세요"
										onkeyup="this.value=this.value.trim();" />
							</div>
							
						</div>	
						<div class="form-group row">
							<label for="memGender" class="col-sm-3" style="font-size:0.9em;" >성 별</label>
							<div class="col-sm-9">
								<select name="memGender" class="form-control" style="font-size:0.9em;">
									<option value="MAN">남</option>
									<option value="WOMAN">여</option>
								</select>
							</div>
						</div>	
							
								
									
						<div class="form-group row">
							<label for="memMail" class="col-sm-3" style="font-size:0.9em;">이메일</label>
							<div class="col-sm-9 input-group-sm">
								<input name="memMail" type="text" class="form-control" id="memMail"
										placeholder="example@naver.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="memRegNo" class="col-sm-3" style="font-size:0.9em;">주민번호앞자리</label>
							<div class="col-sm-9 input-group-sm">
								<input name="memRegNo" type="text" class="form-control" id="memRegNo"
										placeholder="예)980102">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="memAddr" class="col-sm-3" style="font-size:0.9em;">주소</label>
							<div class="col-sm-9 input-group-sm">
								<input name="memAddr" type="text" class="form-control" id="memAddr"
										placeholder="예)주소">
							</div>
						</div>
						<div class="form-group row">
							<label for="memPhone" class="col-sm-3 control-label">전화번호</label>
							<div class="col-sm-9">	
								<div class="input-group-sm">
													
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>										
									<input style="width:68px;" name="memPhone" type="text" class="form-control float-left" />
										
								</div>
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go();" class="btn btn-info">등&nbsp;&nbsp;록</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick=""
										class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
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



<!-- <form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" 
		   style="display:none;" onchange="picture_go();" />
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form> -->

<script>

	var checkedID ="";
	function idCheck_go(){
		//alert("idcheck btn click");
		var input_ID=$('input[name="memId"]');
		if(!input_ID.val()){
	       alert("아이디를 입력하시오");
	       input_ID.focus();
	       return;
		}
		$.ajax({
			url : "idCheck.do?memId="+input_ID.val().trim(),
			method : "get",	
			success : function(result){
				if(result.toUpperCase() == "DUPLICATED"){
			      alert("중복된 아이디 입니다.");
			      $('input[name="memId"]').focus();
				}else{
	              alert("사용가능한 아이디 입니다.");
	              checkedID=input_ID.val().trim();
	              $('input[name="memId"]').val(input_ID.val().trim());	    
	           } 
			},
			error:function(error){
		       alert("시스템장애로 가입이 불가합니다.");
		    }
		});
		
	}
	
	function regist_go(){
		//alert("regist btn click");

		if(!$('input[name="memId"]').val()){
		  alert("아이디는 필수입니다.");
		  return;
		}
	    if($('input[name="memId"]').val()!=checkedID){
	      alert("아이디는 중복 확인이 필요합니다.");
	      return;
	    }
	    if(!$('input[name="memPw"]').val()){
		  alert("패스워드는 필수입니다.");
		  return;
	    }
	    if(!$('input[name="memName"]').val()){
		  alert("이름은 필수입니다.");
		  return;
		}
	    
	    var form = $('form[role="form"]');
		form.attr({"method":"post",
		     	   "action":"regist.do"
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
    





