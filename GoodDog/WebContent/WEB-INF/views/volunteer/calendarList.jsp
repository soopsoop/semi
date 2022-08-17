<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="volList" value="${dataMap.volList }" />

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/default.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta charset="utf-8">
<title>봉사목록리스트 화면입니다.</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">

<div>
	<a href="#contents" class="skip">본문바로가기</a>
<!-- 헤더영역 -->
	<header id="header" class="index">
		<h1><a href="#a"><img src="images/main_logo.PNG" alt="세상에 나쁜개는 없다"></a></h1>
		<h2 class="hide">대메뉴(Hide)</h2>
		<div id="lnb">
			<nav>
				<ul>
				<li><a href="#a">ABOUT US</a>
					<ul>
					<li><a href="#a">연혁 & 비전</a></li>
					<li><a href="#a">기관 및 구성원소개</a></li>
					<li><a href="#a">제공서비스 및 혜택</a></li>
					</ul>
				</li>
				<li><a href="#a">유기견 등록/제보</a>
					<ul>
					<li><a href="#a">유기동물 제보</a></li>
					<li><a href="#a">분실동물 등록</a></li>
					</ul>
				</li>
				<li><a href="#a">입양신청</a>
					<ul>
					<li><a href="#a">입양신청서 등록</a></li>
					<li><a href="#a">등록 유기동물현황</a></li>
					</ul>
				</li>
				<li><a href="#a">자원봉사 모집/신청</a>
					<ul>
					<li><a href="#a">봉사 신청</a></li>
					<li><a href="#a">봉사 신청자</a></li>
					<li><a href="#a">봉사 일정알림</a></li>
					</ul>
				</li>
				<li><a href="#a">세나개 소식지</a>
					<ul>
					<li><a href="#a">입양 후기</a></li>
					<li><a href="#a">입양 전후 갤러리</a></li>
					<li><a href="#a">정보 공유</a></li>
					<li><a href="#a">유의 사항</a></li>
					</ul>
				</li>
				<li><a href="#a">고객센터</a>
					<ul>
					<li><a href="#a">문의사항</a></li>
					<li><a href="#a">불만접수</a></li>
					</ul>
				</li>
				</ul>
			</nav>
			<div></div>
		</div>
		<h2 class="hide">회원</h2>
		<ul>
		<li><a href="#a">LOGIN</a></li>
		<li><a href="#a">JOIN</a></li>
		</ul>

	</header>
<!-- 헤더영역 끝 -->


</div>
	<div>
	<!-- volunteerList Header Start -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row md-2">
					<div class="col-sm-6">
						<h3>등록된 봉사목록</h3>
					</div>
					<div class="col-sm-6">
						<ol class="breadcrumb float-sm-right">
							<li class="breadcrumb-item"><a href="../main.html"> 
								<i class="fa fa-dashboard"></i>메인화면
							</a></li>
							<li class="breadcrumb-item active">목록</li>
						</ol>
					</div>
				</div>
			</div>
		</section>
		<!-- volunteerList Header End  -->
		
		<!-- volunteerList Content Start -->
		<section class="content">
			<div class="card">
				<div class="card-header with-border">
   				<button type="button" class="btn btn-primary" onclick="OpenWindow('volRegistForm.do','봉사등록',600,700);" >봉사등록</button>
   				<div id="keyword" class="card-tools" style="width:550px;">
   				<div class="input-group row">
   					 	<!-- search bar -->
   					 	<!-- sort num -->
					  		<select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="list_go(1);">					  		  		
					  		<option value="10" ${cri.perPageNum eq 10 ? 'selected' : '' } >정렬개수</option>
					  		<option value="5" ${cri.perPageNum eq 5 ? 'selected' : '' }>5개씩</option>
					  	</select>
					  	
					  	<!-- search bar -->
					 	<select class="form-control col-md-3" name="searchType" id="searchType">
					 		<option value=""  >검색구분</option>
							<option value="n" ${param.searchType=='i' ? "selected":"" } >봉사명</option>
							<option value="t" ${param.searchType=='n' ? "selected":"" }>봉사주제</option>
						</select>
						
						<!-- keyword -->
   					 	<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${cri.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" 
									id="searchBtn" data-card-widget="search" onclick="list_go(1);">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					<!-- end : search bar -->		
   					 </div>
   				</div>   			
   			</div>
   			<!-- end : card-header -->	
   			
			<!-- stard : card-body -->
			<div class="card-body" style="text-align:center;">
				<div class="row">
	             <div class="col-sm-12">	
		    		<table class="table table-bordered">
		    			<tr>
		                	<th>봉사명</th>
		                	<th>봉사날짜</th>
		                	<th>봉사주제</th>
		               	</tr>
		     			<c:if test="${!empty volList }" >
		            		<c:forEach items="${volList }" var="vol">		     						     				
		     					  <tr onclick = "OpenWindow('detail.do?volTitle=${vol.volTitle}','회원상세',700,800);" style="cursor:pointer;">
<!-- 		            		  	   	<td style="margin:0;padding:0;padding-top:5px;"> -->
		            		  	   	<td>${vol.volTitle }</td>
<%-- 				              		<td><fmt:formatDate value="${vol.volDate }" pattern="yyyy-MM-dd"/></td> --%>
				              		<td>${vol.volDate }</td>
				              		<td>${vol.volType}</td>
           		  	 			</tr>
		     					
		     				</c:forEach>
		            	</c:if>		
		     			<c:if test="${empty volList }" >
			     			<tr>
		            			<td colspan="7" class="text-center">
		            				해당내용이 없습니다.
		            			</td>
		            		</tr>
		     			</c:if>	
		            </table>
    		     </div>
    	       </div> <!-- row -->
				
			
			
			</div>
			<!-- end : card-body -->
			
			</div>
		
		
		</section>
		<!-- volunteerList Content End -->
		
		
	</div>


	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	<!-- common.js -->
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</body>
</html>