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
	  				<h1>봉사등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">봉사관리</i>
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
    			<a href=""><b>봉사 등록</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist" method="post">						
						<input type="hidden" name="picture" />
						<div class="input-group mb-3">
							<br />
						  </div>	
						  <div class="form-group row">
							<label for="volTitle" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>봉사명</label>
							<div class="col-sm-9 input-group input-group-sm" >								
								<input class="form-control" name="volTitle" type="text" class="form-control" id="volTitle"
										placeholder="등록할 봉사명을 입력"
										onkeyup="this.value=this.value.trim();" />
								<span class="input-group-append-sm">	
									<button type="button" onclick="titleCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
								</span>
							</div>
							
						</div>	
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>봉사 일시</label>
							</div>
<!-- **************************************************************** -->
<!-- **************************************************************** -->

						<div class="form-group row">
							<label for="phone" class="col-sm-3 control-label">전화번호</label>
							<div class="col-sm-9">	
								<div class="input-group-sm">
									<select style="width:75px;" name="phone" id="phone" class="form-control float-left">
										<option value="">-선택-</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="017">017</option>
										<option value="018">018</option>
									</select>							
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>										
									<input style="width:68px;" name="phone" type="text" class="form-control float-left" />
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-</label>
									<input style="width:68px;" name="phone" type="text" class="form-control float-right" />						
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
	var checkedID ="";
	function titleCheck_go(){
		//alert("idcheck btn click");
		var input_ID=$('input[name="volTitle"]');
		if(!input_ID.val()){
	       alert("아이디를 입력하시오");
	       input_ID.focus();
	       return;
		}
		$.ajax({
			url : "idCheck.do?id="+input_ID.val().trim(),
			method : "get",	
			success : function(result){
				if(result.toUpperCase() == "DUPLICATED"){
			      alert("중복된 아이디 입니다.");
			      $('input[name="id"]').focus();
				}else{
	              alert("사용가능한 아이디 입니다.");
	              checkedID=input_ID.val().trim();
	              $('input[name="id"]').val(input_ID.val().trim());	             
	           } 
			},
			error:function(error){
		       alert("시스템장애로 가입이 불가합니다.");
		    }
		});
		
	}
	
	function regist_go(){
		//alert("regist btn click");
		if(!$('input[name="id"]').val()){
		  alert("아이디는 필수입니다.");
		  return;
		}
	    if($('input[name="id"]').val()!=checkedID){
	      alert("아이디는 중복 확인이 필요합니다.");
	      return;
	    }
	    if(!$('input[name="pwd"]').val()){
		  alert("패스워드는 필수입니다.");
		  return;
	    }
	    if(!$('input[name="name"]').val()){
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

<!--**************************  -->
<script>
  $(function() {
    //Datemask dd/mm/yyyy
    $('#datemask').inputmask('yyyy/mm/dd', { 'placeholder': 'yyyy/mm/dd' });
  });
</script>
<!--**************************  -->

<!--**************************  -->

  
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js" ></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>




</body>
</html>
    





