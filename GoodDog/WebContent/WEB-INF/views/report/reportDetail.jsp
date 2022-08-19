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
  <title>제보내용 상세보기</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
	
<div class="wrapper">
  <div >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상세페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">제보</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
    <!-- Main content -->
    <section class="content register-page">       
		<div class="register-box">         
	    	<form role="form" class="form-horizontal"  method="post">
	    		<div class="register-card-header" >
	    			<h1 class="text-center">제보내용 상세보기</h1>
	    		</div>
	        	<div class="register-card-body" >
					<br />
	                <div class="form-group row" >
	                  <label for="reportNo" class="col-sm-3 control-label text-right">글번호</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportNo" type="text" class="form-control" id="reportNo"  value="${report.reportNo }" readonly>
	                  </div>
	                </div>	               
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">제목</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportTitle }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">제보유형</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportType }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">견종</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportBreed }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">성별</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportGender }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">발견장소</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportPlace }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">특징</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportFeature }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">발견날짜</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.foundDate }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">제보날짜</label>
	
	                  <div class="col-sm-9">
<%-- 	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportDate }" readonly> --%>
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="<fmt:formatDate value="${report.reportDate }" pattern="yyyy/MM/dd"/>" readonly>
	                    
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">작성자</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.memId }" readonly>
	                  </div>
	                </div>
	                
	                <div class="form-group row">
	                  <label for="inputPassword3" class="col-sm-3 control-label text-right">제목</label>
	
	                  <div class="col-sm-9">
	                    <input name="reportTitle" type="text" class="form-control" id="reportTitle" value="${report.reportTitle }" readonly>
	                  </div>
	                </div>
	                
	              </div>  
	              
	              <div class="card-footer" style="padding:5px 0;" >
		          		<div class="row">
			          		<div class="col-sm-4 text-center">
			          			<button type="button" onclick="location.href='modifyForm.do?reportNo=${report.reportNo}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
			          		</div>
		          		
			          		<div class="col-sm-4 text-center">
			          			<button type="button" onclick="location.href='remove.do?reportNo=${report.reportNo}';" id="deleteBtn" class="btn btn-danger" >삭 제</button>
			          		</div>
		          			
			          		<div class="col-sm-4 text-center">
			            		<button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button>
			            	</div>
		          	    </div>  	
		          </div>
	      	  </form>
      	  </div>
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
</div>



<script>
window.onload=function(){
	MemberPictureThumb('<%=request.getContextPath()%>');
}
</script>

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js" ></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- common.js -->
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</body>
</html>
    





