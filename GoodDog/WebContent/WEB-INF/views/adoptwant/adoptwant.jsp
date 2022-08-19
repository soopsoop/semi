<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세상에 나쁜개는 없다</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/default.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/sub.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body>
<!-- 헤더영역 -->
	<header>
		<hr/>
		<div id="top">
			<a href="<%=request.getContextPath()%>/index.do"><img alt="메인로고" src="<%=request.getContextPath()%>/resources/images/mainlogo.JPG"></a>
		</div>
	</header>

	<div id="header" class="index">

		<h2 class="hide">대메뉴(Hide)</h2>
		<div id="lnb">
			<nav>
				<ul>
				<li><a>ABOUT US</a>
					<ul>
					<li><a href="<%=request.getContextPath()%>/aboutus/map.do">기관 및 구성원소개</a></li>
					</ul>
				</li>
				<li><a>유기견 등록 / 제보</a>
					<ul>
					<li><a href="<%=request.getContextPath()%>/report/reportList.do">유기동물 제보</a></li>
					</ul>
				</li>
				<li><a>입양신청</a>
					<ul>
					<li><a href="<%=request.getContextPath()%>/adoptwant/adoptwantform.do">입양신청서 등록</a></li>
					<li><a href="<%=request.getContextPath()%>/dog/doglist.do">등록 유기동물현황</a></li>
					</ul>
				</li>
				<li><a>자원봉사 모집/신청</a>
					<ul>
					<li><a href="<%=request.getContextPath()%>/volunteer/volunteerList.do">봉사 신청자</a></li>
					<li><a href="<%=request.getContextPath()%>/vol/calendarList.do">봉사 일정알림</a></li>
					</ul>
				</li>
				<li><a>세나개 소식지</a>
					<ul>
					<li><a>입양 후기</a></li>
					<li><a>입양 전후 갤러리</a></li>
					<li><a>정보 공유</a></li>
					<li><a>유의 사항</a></li>
					</ul>
				</li>
				<li><a>고객센터</a>
					<ul>
					<li><a href="<%=request.getContextPath()%>/qnaBoard/list.do">문의사항</a></li>
					</ul>
				</li>
				<li><a href="<%=request.getContextPath()%>">LOGIN / JOIN US</a>
				<c:if test="${empty loginUser && empty loginAdmin }">
                  <ul>
                  <li><a href="<%=request.getContextPath()%>/loginForm.do">LOGIN</a></li>      
                  <li><a href="<%=request.getContextPath()%>/member/registForm.do">JOIN</a></li>
                  </ul>
                </c:if>
                <c:if test="${!empty loginUser || !empty loginAdmin }">
                  <ul>
                  <li><a href="#a">${ loginUser.memName }</a></li>
                  <li><a href="#a">${ loginAdmin.adminName }</a></li>
                  <li><a href="#" onclick="location.href='<%=request.getContextPath() %>/logout.do';">로그아웃</a></li>
                </c:if>
				</li>
				</ul>
			</nav>
			<div></div>
		</div>
      <div class="visual">
         <img
            src="<%=request.getContextPath()%>/resources/images/subBackGround2.jpg"
            alt="">
      </div>
	</div>

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

<footer>
      <div class="clear">
         <a href="#header">TOP</a>
         <div class="left">
            <div>
               <a href="#a">개인정보처리방침</a> <a href="#a">이용약관</a> <a href="#a">이메일무단수집거부</a>
               <a href="#a">사이트맵</a>
            </div>
            <p>
               세나개(주)<span></span>사업자번호 : 201-81-45685<span></span>공동 대표자 : 채희진,
               박수빈, 박지영, 한재웅, 곽금규, 박성우<br> 대전시 서구 대덕대로 372 세상에 나쁜개는 없다 <span></span>042-3381-7414<span></span>Copyright
               © 2022 senagae Corporation., All rights reserved.
            </p>
         </div>
         <div class="right">
            <select>
               <option>FAMILY SITE</option>
               <option>FAMILY SITE</option>
               <option>FAMILY SITE</option>
               <option>FAMILY SITE</option>
               <option>FAMILY SITE</option>
               <option>FAMILY SITE</option>
               <option>FAMILY SITE</option>
            </select>
         </div>
      </div>
   </footer>



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
    





