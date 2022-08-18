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


  <!-- Content Wrapper. Contains page content -->
  <div>
   <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>보호견 입양 처리 페이지</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">유기동물 관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	수정
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section> 
  <!-- Main content -->
  <section class="content register-page" >
	<form role="form" class="form-horizontal" action="dogadopt.do" method="post" enctype="multipart/form-data">	
		<div class="card" style="min-width:450px;">	
			<div class="card-body">	
					<input type="hidden" name="dogPic" />
						<div class="input-group mb-3">
							<div class="mailbox-attachments clearfix" style="text-align: center;">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
								<div class="mailbox-attachment-info">
									<div class="input-group input-group-sm">
										<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">
										<span style="color:red;font-weight:bold;">*</span>입양 후 사진선택</label>
										<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
										<span class="input-group-append-sm">											
											<button type="button" class="btn btn-info btn-sm btn-append" onclick="upload_go();">업로드</button>											
										</span>
									</div>
								</div>
							</div>
						<br />
					 </div>	
				<div class="form-group row">
					 <label for="dogName" class="col-sm-3" style="font-size:0.9em;" >등록번호</label>	
					<div class="col-sm-9 input-group input-group-sm">
						<input readonly="readonly" name="dogNo" 
						type="text" class="form-control" id="dogNo" value="${dog.dogNo }" >								
					</div>								
				</div>	
				<div class="form-group row">
					 <label for="dogName" class="col-sm-3" style="font-size:0.9em;" >이  름</label>	
					<div class="col-sm-9 input-group input-group-sm">
						<input name="dogName" readonly="readonly"
						type="text" class="form-control" id="dogName" value="${dog.dogName }" >								
					</div>								
				</div>
				<div class="form-group row">
					<label for="dogBreed" class="col-sm-3" style="font-size:0.9em;">견  종</label>
					<div class="col-sm-9 input-group-sm">								
						<input readonly="readonly" class="form-control" name="dogBreed" class="form-control" id="dogBreed" value="${dog.dogBreed }" />
					</div>
				</div>
				<div class="form-group row">
					<label for="dogGender" class="col-sm-3" style="font-size:0.9em;">성  별</label>
					<div class="col-sm-9 input-group-sm">
						<input readonly="readonly" name="dogGender" type="email" class="form-control" id="email" value="${dog.dogGender }"  />
					</div>
				</div>
				<div class="form-group row">
					<label for="dogFeature" class="col-sm-3" style="font-size:0.9em;">소  개</label>
					<div class="col-sm-9 input-group-sm">
						<input readonly="readonly" name="dogFeature" type="email" class="form-control" id="email" value="${dog.dogFeature }"  />
					</div>
				</div>
					<div class="form-group row">
						 <label for="memId" class="col-sm-3" style="font-size:0.9em;" >
						 <span style="color:red;font-weight:bold;">*</span>입양자 ID</label>	
						<div class="col-sm-9 input-group input-group-sm">
							<input name="memId"
							type="text" class="form-control" id="memId" value="" >								
						</div>								
					</div>
				<div class="card-footer row" style="margin-top: 0; border-top: none;">						
					<button type="button" id="modifyBtn"  onclick="adopt_go();"
						class="btn btn-warning col-sm-4 text-center" >입양등록</button>
					<div class="col-sm-4"></div>
					<button type="button" id="cancelBtn" onclick="history.go(-1);"
						class="btn btn-default pull-right col-sm-4 text-center">취 소</button>
				</div>	
			</div>
		</div>
	</form>
  </section>
    <!-- /.content -->
  </div>
  
  <form role="imageForm" action="upload/picture" method="post" enctype="multipart/form-data">
	<input id="inputFile" name="pictureFile" type="file" class="form-control" 
		   style="display:none;" onchange="picture_go();" />
	<input id="oldFile" type="hidden" name="oldPicture" value="" />
	<input type="hidden" name="checkUpload" value="0" />	
</form>
  
  <script>
    window.onload=function(){
	   DogPictureThumb('<%=request.getContextPath()%>');
	}
  </script>
  
  
<script>
	function picture_go(){
		//alert("file change");
		var form = $('form[role="imageForm"]');
		var picture = form.find('[name=pictureFile]')[0];
		
	   //이미지 확장자 jpg 확인
	   var fileFormat = picture.value.substr(picture.value.lastIndexOf(".")+1).toUpperCase();
		if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
	   		alert("이미지는 jpg/jpeg 형식만 가능합니다.");
	   		picture.value="";      
	   		return;
		} 

		//이미지 파일 용량 체크
	   if(picture.files[0].size>1024*1024*1){
	      alert("사진 용량은 1MB 이하만 가능합니다.");
	      picture.value="";
	      return;
	   };
	   
		
		//alert(picture.value);
		//업로드 확인변수 초기화 (사진변경)
   		form.find('[name="checkUpload"]').val(0);	
		document.getElementById('inputFileName').value=picture.value;
		
		if (picture.files && picture.files[0]) {
		  var reader = new FileReader();
		  reader.onload = function (e) {
			  $('div#pictureView').css({
			     'background-image':'url('+e.target.result+')',
			     'background-position':'center',
			     'background-size':'cover',
			     'background-repeat':'no-repeat'
			  });
			}
			  
		 reader.readAsDataURL(picture.files[0]);
	   }
	}
	
	function upload_go(){
		//alert("upload btn click");
		if(!$('input[name="pictureFile"]').val()){
		  alert("사진을 선택하세요.");
		  $('input[name="pictureFile"]').click();
		  return;
		}  
		
		if($('input[name="checkUpload"]').val()==1){
		  alert("이미업로드 된 사진입니다.");
		  return;      
		}
		
		var formData = new FormData($('form[role="imageForm"]')[0]);
		$.ajax({
			url:"picture.do",
			data:formData,
			type:"post",
			processData:false,
		    contentType:false,
		    success:function(data){
		      //업로드 확인변수 세팅
	          $('input[name="checkUpload"]').val(1);
	          //저장된 파일명 저장.
	          $('input#oldFile').val(data); // 변경시 삭제될 파일명	          
	          $('form[role="form"]  input[name="dogPicCurrent"]').val(data);	    	  
	    	  alert("사진이 업로드 되었습니다.");
		    },
		    error:function(error){
		      alert("현재 사진 업로드가 불가합니다.\n 관리자에게 연락바랍니다.");
		    }
		});
	}

</script>
<script>
  	function adopt_go() {
		var uploadCheck = $('input[name="checkUpload"]').val();   
		if(uploadCheck=="0"){
		  alert("사진업로드는 필수 입니다");      
		  return;
		}
		if(!$('input[name="memId"]').val()){
		  alert("입양자 ID는 필수 기재사항입니다.");
		  return;
		}
	    var form = $('form[role="form"]');
		form.submit();
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
    





