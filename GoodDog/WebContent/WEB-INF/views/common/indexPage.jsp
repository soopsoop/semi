<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title></title>
<head>
<style>
	*{margin:0;padding:0;}
</style>
</head>

<body>

<c:if test="${empty loginUser && empty loginAdmin }">
	로그인중이 아닙니다
</c:if>

<c:if test="${!empty loginAdmin }">
	${ loginAdmin.adminName } 님 환영합니다
 	<button onclick="location.href='<%=request.getContextPath() %>/logout.do';" class="btn btn-xs btn-primary col-xs-3" type="button">
	  			LOGOUT
	  		</button>
</c:if>
<c:if test="${!empty loginUser }">
	    ${ loginUser.memName } 님 환영합니다~
	    
 <div class="info">
	  	<div class="row">
	  		
	  		<a href="#" class="d-block">${loginUser.memName }</a>
	  		 <button onclick="location.href='<%=request.getContextPath() %>/logout.do';" class="btn btn-xs btn-primary col-xs-3" type="button">
	  			LOGOUT
	  		</button>
	  	</div>
		
</c:if>


<!-- handlebars -->

<script type="text/x-handlebars-template"  id="subMenu-list-template" >
{{#each .}}
<li class="nav-item subMenu" >
	<a href="javascript:goPage('{{murl}}','{{mcode}}');initPageParam();" class="nav-link">
		<i class="{{micon}}"></i>
		<p>{{mname}}</p>
	</a>
</li>
{{/each}}
</script>

<script>
function init() {
	goPage('${menu.murl}','${menu.mcode}');
	subMenu('${menu.mcode}'.substring(0,3)+"0000");
}
</script>

</body>