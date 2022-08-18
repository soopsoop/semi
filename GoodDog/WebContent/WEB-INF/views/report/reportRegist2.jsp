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
  <title>봉사등록Form</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- DatePicker -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/daterangepicker/daterangepicker.css">
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  
  
  
  
</head>
<body class="hold-transition sidebar-mini">



<div>
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>제보등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">제보</i>
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
    			<a href=""><b>제보 등록</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="reportRegist" method="post">	
						<input type="hidden" name="picture" />
<!-- 						<div class="input-group mb-3"> -->
<!-- 							<div class="mailbox-attachments clearfix" style="text-align: center;"> -->
<!-- 								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div> -->
<!-- 								<div class="mailbox-attachment-info"> -->
<!-- 									<div class="input-group input-group-sm"> -->
<!-- 										<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label> -->
<!-- 										<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/> -->
<!-- 										<span class="input-group-append-sm">											 -->
<!-- 											<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											 -->
<!-- 										</span> -->
<!-- 									</div> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 							<br /> -->
<!-- 						  </div>	 -->
										
<!-- 						  <div class="form-group row"> -->
<!-- 							<label for="reportNo" class="col-sm-3" style="font-size:0.9em;"> -->
<!-- 								<span style="color:red;font-weight:bold;">*</span>번호</label> -->
<!-- 							<div class="col-sm-9 input-group input-group-sm" >								 -->
<!-- 								<input class="form-control" name="reportNo" type="text" class="form-control" id="reportNo" -->
<!-- 										placeholder="등록할 게시판 제목을 입력" -->
<!-- 										onkeyup="this.value=this.value.trim();" /> -->
<!-- 							</div> -->
						  <div class="form-group row">
							<label for="reportPic" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>사진</label>
							<div class="col-sm-9 input-group input-group-sm" >								
								<input class="form-control" name="reportPic" type="text" class="form-control" id="reportPic"
										placeholder="등록할 게시판 제목을 입력"
										onkeyup="this.value=this.value.trim();" />
							</div>
						</div>	
						  <div class="form-group row">
							<label for="memId" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>작성자</label>
							<div class="col-sm-9 input-group input-group-sm" >								
								<input class="form-control" name="memId" type="text" class="form-control" id="memId"
										placeholder="등록할 게시판 제목을 입력"
										onkeyup="this.value=this.value.trim();" />
							</div>
						</div>	
						  <div class="form-group row">
							<label for="reportTitle" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>제목</label>
							<div class="col-sm-9 input-group input-group-sm" >								
								<input class="form-control" name="reportTitle" type="text" class="form-control" id="reportTitle"
										placeholder="등록할 게시판 제목을 입력"
										onkeyup="this.value=this.value.trim();" />
							</div>
						</div>	
						
						<div class="form-group row">
							<label for="reportType" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>제보유형</label>
							<div class="col-sm-9">	
								<div class="input-group-sm">
									<select style="width:75px;" name="reportType" id="reportType" class="form-control float-left">
										<option value="">-선택-</option>
										<option value="유기">유기</option>
										<option value="분실">분실</option>
									</select>							
								</div>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="reportBreed" class="col-sm-3" style="font-size:0.9em;">견종</label>
							<div class="col-sm-9 input-group-sm">
								<input name="reportBreed" type="text" class="form-control" id="reportBreed"
										placeholder="생략가능">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="reportGender" class="col-sm-3" style="font-size:0.9em;">성별</label>
							<div class="col-sm-9"> 
								<div class="input-group-sm">
								<select style="width:75px;" name="reportGender" id="reportGender" class="form-control float-left">
										<option value="">-선택-</option>
										<option value="남아">남아</option>
										<option value="여아">여아</option>
										<option value="모름">모름</option>
									</select>
								</div>
							</div>
						</div>
						
						<div class="form-group row">
							<label for="reportPlace" class="col-sm-3" style="font-size:0.9em;">발견장소</label>
							<div class="col-sm-9 input-group-sm">
								<input name="reportPlace" type="text" class="form-control" id="reportPlace"
										placeholder="발견한 대략적인 위치를 입력">
							</div>
						</div>
						
						<div class="form-group row">
							<label for="reportFeature" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>특징</label>
							<textarea class="form-control" rows="3" placeholder="제보 강아지의 특징을 입력하세요.(100자 이내)" 
									style="height: 159px;" name="reportFeature" id="reportFeature"></textarea>
						</div>
						
						
						<div class="form-group row">
							<label for="foundDate" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>발견날짜</label>
								
								<div class="form-group row">
									<label class="col-sm-3" style="font-size:0.9em;">
										<span style="color:red;font-weight:bold;"></span>날짜입력:</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text"><i class="far fa-calendar-alt"></i></span>
											</div>
									<input type="text" class="form-control" data-inputmask-alias="datetime" data-inputmask-inputformat="yyyy/mm/dd" data-mask="" inputmode="none"
										placeholder="yyyy/mm/dd" name="foundDate" id="foundDate">
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


<script>
	
	function regist_go(){
		//alert("regist btn click");
		if(!$('input[name="reportTitle"]').val()){
		  alert("제목은 필수입니다.");
		  return;
		}
	    if(!$('input[name="foundDate"]').val()){
		  alert("날짜입력은 필수입니다.");
		  return;
	    }
	    if(!$('select[name="reportType"]').val()){
		  alert("제보유형 선택은 필수입니다.");
		  return;
		}
	    if(!$('textarea[name="reportFeature"]').val()){
		  alert("특징 입력은 필수입니다.");
		  return;
		}
	    
	    var form = $('form[role="form"]');
		form.attr({"method":"post",
		     	   "action":"reportRegist.do"
		   		  });	   
		form.submit();
		   
		
	}
	
</script>

<!--**************************  -->
<!--**************************  -->
<!--**************************  -->

  
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js" ></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- Date Inputmask -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/inputmask/jquery.inputmask.min.js"></script>

<script type="text/javascript">
$(function() {
	//Datemask dd/mm/yyyy
	$('#datemask').inputmask('yyyy/mm/dd', { 'placeholder': 'yyyy/mm/dd' })
	$('[data-mask]').inputmask()
});
</script>
</body>
</html>
    





