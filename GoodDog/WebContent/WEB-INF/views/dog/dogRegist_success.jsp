<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
	alert("보호견 등록에 성공했습니다.\n 보호견 리스트 페이지로 이동합니다.");
	window.opener.location.href="<%=request.getContextPath()%>/dog/doglist.do";
	window.close();	
</script>