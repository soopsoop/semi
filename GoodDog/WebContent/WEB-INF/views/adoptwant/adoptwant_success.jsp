<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("보호견에 대한 입양 신청이 완료되었습니다.");
	location.href = "<%=request.getContextPath()%>/dog/doglist.do";
	window.close();
</script>
    