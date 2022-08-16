<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="volunteerList" value="${dataMap.volunteerList }" />

<!DOCTYPE html>
<html lang="en">
<head>
<style>
th, td {
	padding: 30px;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Starter</title>

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
		<!-- Main content -->
		<img src="../images/volimg.png" width="1280" height="290">
		<section class="content-header">
			<div class="container-fluid">
				<div class="row md-2">
					<div class="col-sm-6">
						<h1>봉사 신청자</h1>
					</div>
					<div class="col-sm-6">
					</div>
				</div>
			</div>
		</section>

				<div class="card-header with-border">
<!-- 				<div id="keyword" class="card-tools" style="width: 550px;"> -->
						<div class="input-group row"></div>
						<select class="form-control col-md-1" name="perPageNum"
							id="perPageNum" onchange="list_go(1);">
							<option value="10" ${cri.perPageNum eq 10 ? 'selected' : ''}>정렬개수</option>
							<option value="2" ${cri.perPageNum eq 5 ? 'selected' : ''}>5개씩</option>
							<option value="3" ${cri.perPageNum eq 10 ? 'selected' : ''}>10개씩</option>
							<option value="5" ${cri.perPageNum eq 20 ? 'selected' : ''}>20개씩</option>

						</select>
					</div>
				</div>


		<section class="content">
			<div class="card">

				<div class="card-body" style="text-align: center;">
					<div class="row">
						<div class="col-sm-2"></div>
						<div class="col-sm-8">
							<table class="table table-bordered">
								<tr>
									<th>봉사자 번호</th>
									<th>회원 아이디</th>
									<th>봉사 이름</th>
								</tr>
								<c:if test="${!empty volunteerList }">
									<c:forEach items="${volunteerList }" var="volunteer">
										<tr>
											<td>${volunteer.volNo }</td>
											<td class="maskingName" data-id="${volunteer.memId }">
													
											</td>
<%-- 											<td>${volunteer.memId }</td> --%>
											<td>${volunteer.volTitle }</td>
										</tr>

									</c:forEach>
								</c:if>
								<c:if test="${empty volunteerList }">
									<tr>
										<td colspan="7" class="text-center">해당내용이 없습니다.</td>
									</tr>
								</c:if>
							</table>
						</div>
						<div class="col-sm-2"></div>
						<!-- col-sm-12 -->
					</div>
					<!-- row -->
					
				</div>
				<!-- card-body -->
				<div class="card-footer">
					<!-- pagination -->
					<nav aria-label="Navigation">
						<ul class="pagination justify-content-center m-0">
							<li class="page-item"><a class="page-link"
								href="javascript:list_go(1);"> <i
									class="fas fa-angle-double-left"></i>
							</a></li>
							<li class="page-item"><a class="page-link"
								href="javascript:list_go('${pageMaker.prev ? pageMaker.startPage-1 : cri.page}');">
									<i class="fas fa-angle-left"></i>
							</a></li>

							<c:forEach var="pageNum" begin="${pageMaker.startPage }"
								end="${pageMaker.endPage }">
								<li class="page-item ${cri.page == pageNum?'active':''}"><a
									class="page-link" href="javascript:list_go('${pageNum}');">${pageNum }</a>
								</li>
							</c:forEach>
							<li class="page-item"><a class="page-link"
								href="javascript:list_go('${pageMaker.next ? pageMaker.endPage+1 :cri.page}');">
									<i class="fas fa-angle-right"></i>
							</a></li>
							<li class="page-item"><a class="page-link"
								href="javascript:list_go('${pageMaker.realEndPage}');"> <i
									class="fas fa-angle-double-right"></i>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</section>
	</div>

	<script>
	function MaskingName(){
		
	for(var target of document.querySelectorAll('.maskingName')){	
		var strName = target.getAttribute('data-id');
		  if (strName.length > 2) { 
			    var originName = strName.split('');
			    originName.forEach(function(name, i) {
			      if (i === 0 || i === originName.length - 1) return;
			      originName[i] = '*';
			    });
			    var joinName = originName.join();
			    var maskting = joinName.replace(/,/g, '');
			    
			    document.getElementsByClassName("maskingName")[0].innerHTML = maskting;
			    console.log(maskting);
			  } else {
			    var pattern = /.$/; // 정규식
			    return strName.replace(pattern, '*');
			    
			  }
			};
			
	}
	window.onload=MaskingName;
	
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
</body>
</html>






