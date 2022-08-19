<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>

	alert("${dog.dogName}의 정보가 삭제되었습니다.");
	if(window.opener) window.opener.location.reload(true);
	window.close();	
	
</script>