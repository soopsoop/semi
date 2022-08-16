<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style> 
.money {
  animation: mymove 5s infinite;
}
@keyframes mymove {
  from {
      transform: rotateY(0deg);
    }
    to {
      transform: rotateY(359deg);
    }
}
</style>
<%-- 	<%@ include file="/WEB-INF/views/include/style.jsp" %> --%>
	
</head>
<body>
<section class="content">
      <div class="error-page">
        <h2 class="headline text-danger">500</h2>

        <div class="error-content">
          <h3><i class="fas fa-exclamation-triangle text-danger"></i> 잘못된 요청 ! </h3>
		<img src="images/volimg.png">  
          <p>
            We will work on fixing that right away.
            Meanwhile, you may <a href="../../GoodDog">홈으로 가기</a> or try using the search form.
          </p>

          <form class="search-form">
            <div class="input-group">
              <input type="text" name="search" class="form-control" placeholder="Search">

              <div class="input-group-append">
                <button type="submit" name="submit" class="btn btn-danger"><i class="fas fa-search"></i>
                </button>
              </div>
            </div>
            <!-- /.input-group -->
          </form>
        </div>
      </div>
      <!-- /.error-page -->

    </section>
	<%for(int i = 0; i < 100; i++) {%>
	<img class="money" src="images/pet.png">    
	<% }%>
<%-- 	<%@ include file="/WEB-INF/views/include/js.jsp" %> --%>
</body>
</html>