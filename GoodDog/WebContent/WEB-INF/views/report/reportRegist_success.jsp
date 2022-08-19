<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<script>
	alert("제보등록 성공했습니다.\n 제보게시판 페이지로 이동합니다.");
	window.opener.location.href="<%=request.getContextPath()%>/report/reportList.do";
 	window.close();
</script>