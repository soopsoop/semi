<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

<c:set var="pageMaker" value="${dataMap.pageMaker }" />
<c:set var="cri" value="${dataMap.pageMaker.cri }" />
<c:set var="dogList" value="${dataMap.dogList }" />
    
    
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
			<a href="#a"><img alt="메인로고" src="<%=request.getContextPath()%>/resources/images/mainlogo.JPG"></a>
		</div>
	</header>

	<div id="header" class="index">

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
				<li><a href="#a">유기견 등록 / 제보</a>
					<ul>
					<li><a href="#a">유기동물 제보</a></li>
					<li><a href="#a">분실동물 등록</a></li>
					</ul>
				</li>
				<li><a href="#a">입양신청</a>
					<ul>
					<li><a href="#a">입양신청서 등록</a></li>
					<li><a href="doglist.do">등록 유기동물현황</a></li>
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
				<li><a href="#a">LOGIN / JOIN US</a>
					<ul>
					<li><a href="#a">LOGIN</a></li>
					<li><a href="#a">JOIN US</a></li>
					</ul>
				</li>
				</ul>
			</nav>
			<div></div>
		</div>
		<!-- <h2 class="hide">회원</h2>
		<ul>
		<li><a href="#a">LOGIN</a></li>
		<li><a href="#a">JOIN</a></li>
		</ul> -->
		<div class="visual">
			<div class="mainVideo">
				<video muted autoplay loop>
					<source src="<%=request.getContextPath()%>/resources/video/senagae_main_video.mp4" type="video/mp4" type="video/mp4">
					<strong>현재 동영상 기능이 제공되지 않습니다.</strong>
				</video>
			</div>
		</div>
	</div>
<!-- 헤더영역 끝 -->

<!-- 본문영역 -->
	<main>
		<section class="info_box">
			<h2>세상에 나쁜개는 없다의 <span>보호유기동물</span></h2>
			<ul class="clear">
				<c:set var="loopFlag" value="false" />
				<c:set var="cnt" value="0" />
				<c:if test="${!empty dogList }" >
		        <c:forEach items="${dogList }" var="dog" >
		        	 <c:if test="${loopFlag ne true}">
						<li onclick="OpenWindow('dogdetail.do?dogNo=${dog.dogNo}','보호견 상세',700,800);">
							<a href="#a">
								<em>
									<img src="<%=request.getContextPath()%>/resources/images/upload/${dog.dogPic}" 
									     alt="현재 이미지 기능이 제공되지 않습니다.">
			            		</em>
								<div>
									<h3>${dog.dogName} - ${dog.dogBreed}</h3>
									<p>${dog.dogFeature}</p>
									<span class="ico no1" style="background: #042e6f;">
										<c:if test="${dog.adoptYn eq 0}">분양중</c:if>
										<c:if test="${dog.adoptYn eq 1}">입양완료</c:if>
									</span>
									<div>${dog.dogName} 만나러가기</div>
								</div>
							</a>
						</li>
						<c:set var="cnt" value="${cnt+1}"></c:set>
						<c:if test="${cnt eq 12}">
	  						<c:set var="loopFlag" value="true"/>
	   					</c:if>
	   				</c:if>
			    </c:forEach>
		        </c:if>		
			</ul>
			<div class="btns center">
				<a href="doglist.do" class="btn_more">더보기</a>
			</div>
		</section>
		<section class="news">
			<div class="clear">
				<h2>입양후기</h2>
				<ul>
				<li>
					<a href="#a">
						<h3>제목</h3>
						<p>내용1</p>
						<span>내용2</span>
						<em></em><em></em><em></em><em></em>
					</a>	
				</li>
				<li>
					<a href="#a">
						<h3>제목</h3>
						<p>내용1</p>
						<span>내용2</span>
						<em></em><em></em><em></em><em></em>
					</a>	
				</li>
				<li>
					<a href="#a">
						<h3>제목</h3>
						<p>내용1</p>
						<span>내용2</span>
						<em></em><em></em><em></em><em></em>
					</a>	
				</li>
				</ul>
			</div>
		</section>
		<section class="guide_box clear">
			<article class="guide">
				<h2>고객<br>가이드</h2>
				<ul>
				<li><a href="#a">고객문의</a></li>
				<li><a href="#a">A/S센터</a></li>
				<li><a href="#a">자주하는질문</a></li>
				<li><a href="#a">고객의소리</a></li>
				</ul>
			</article>
			<article class="phone">
				<div>
					<h2>문의전화</h2>
					<span>02.779.6114</span>
				</div>
				<div>
					<h2>평일</h2>
					<p>AM9 ~ PM6</p>
					<div>(토, 일, 공휴일 휴무)</div>
				</div>
			</article>
		</section>
	</main>
	<footer>
		<div class="clear">
			<a href="#header">TOP</a>
			<div class="left">
				<div>
					<a href="#a">개인정보처리방침</a>
					<a href="#a">이용약관</a>
					<a href="#a">이메일무단수집거부</a>
					<a href="#a">사이트맵</a>
				</div>
				<p>
					세나개(주)<span></span>사업자번호 : 201-81-45685<span></span>공동 대표자 : 채희진, 박수빈, 박지영, 한재웅, 곽금규, 박성우<br>
					대전시 서구 대덕대로 372 세상에 나쁜개는 없다 <span></span>042-3381-7414<span></span>Copyright © 2022 senagae Corporation., All rights reserved.
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

<script>
window.onload=function() {
	DogPictureThumb('<%=request.getContextPath()%>');
}
</script>

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- common.js -->
<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
</body>
</html>