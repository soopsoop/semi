<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
	alert("${dog.dogName}의 정보가 수정되었습니다.");
	location.href = 'dogdetail.do?dogNo=${dog.dogNo}';
	
	if(${parentReload}) {
		if(confirm('${dog.dogName}의 정보가 수정되었습니다.\n현재 화면을 닫고 새로고침 하시겠습니까?')) {
			window.opener.location.reload(true);	
			window.close();	
		}
	}
</script>