<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="reportList" value="${dataMap.reportList }" />

<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css" href="../css/default.css">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<meta charset="utf-8">
<title>제보게시판 화면입니다.</title>

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


</div>
	<div>
	<!-- volunteerList Header Start -->
		<section class="content-header">
			<div class="container-fluid">
				<div class="row md-2">
					<div class="col-sm-6">
						<h3>세나개 제보게시판</h3>
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
   				<button type="button" class="btn btn-primary" onclick="OpenWindow('reportRegistForm.do','제보하기',600,700);" >제보하기</button>
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
							<option value="n" ${param.searchType=='i' ? "selected":"" } >작성자</option>
							<option value="t" ${param.searchType=='t' ? "selected":"" }>제목</option>
							<option value="ty" ${param.searchType=='ty' ? "selected":"" }>제보유형</option>
							<option value="fd" ${param.searchType=='fd' ? "selected":"" }>발견날짜</option>
							<option value="rd" ${param.searchType=='rd' ? "selected":"" }>제보날짜</option>
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
		                	<th>번호</th>
		                	<th>제목</th>
		                	<th>제보유형</th>
		                	<th>견종</th>
		                	<th>성별</th>
		                	<th>발견장소</th>
		                	<th>특징</th>
		                	<th>사진</th>
		                	<th>발견날짜</th>
		                	<th>제보날짜</th>
		                	<th>작성자</th>
		               	</tr>
		     			<c:if test="${!empty reportList }" >
		            		<c:forEach items="${reportList }" var="report">		     						     				
		     					  <tr onclick = "OpenWindow('reportDetail.do?reportNo=${report.reportNo }','상세내용',700,800);" style="cursor:pointer;">
<!-- 		            		  	   	<td style="margin:0;padding:0;padding-top:5px;"> -->
		            		  	   	<td>${report.reportNo }</td>
				              		<td>${report.reportTitle }</td>
				              		<td>${report.reportType}</td>
				              		<td>${report.reportBreed}</td>
				              		<td>${report.reportGender}</td>
				              		<td>${report.reportPlace}</td>
				              		<td>${report.reportFeature}</td>
				              		<td>${report.reportPic}</td>
				              		<td>${report.foundDate}</td>
				              		<td><fmt:formatDate value="${report.reportDate }" pattern="yyyy/MM/dd"/></td>
				              		<td>${report.memId}</td>
           		  	 			</tr>
		     					
		     				</c:forEach>
		            	</c:if>		
		     			<c:if test="${empty reportList }" >
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
		<!-- reportList Content End -->
	</div>

<form id="jobForm">	
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value=""/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="keyword" value="" />
</form>

<script>
	
	function list_go(page,url){
		//alert(page);
		if(!url) url="reportList.do";
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val());
		jobForm.attr({
			action:url,
			method:'get'
		}).submit(); 
	}
</script>

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