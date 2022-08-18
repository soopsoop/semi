<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
	<script>
	alert("${dog.dogNo}번 보호견이 성공적으로 입양 완료 처리되었습니다.");
	window.opener.location.href="<%=request.getContextPath()%>/dog/doglist.do";
	window.close();	
</script>
