<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<script>
	alert("정보 수정에 성공했습니다.\n 창을 닫습니다");
	window.opener.location.href="<%=request.getContextPath()%>/vol/calendarList.do";
	window.close();	
</script>


