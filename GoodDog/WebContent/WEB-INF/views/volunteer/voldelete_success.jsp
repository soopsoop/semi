<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	alert("삭제 성공했습니다.\n 창을 닫습니다");
	window.close();	
	window.opener.location.href="<%=request.getContextPath()%>/vol/calendarList.do";
</script>


