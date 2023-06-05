<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	
</head>
<body>
	<h1>HOME!</h1>
	<p> The time on the server is ${serverTime} </p>
	<h3>계정 ${userObj.userId} / 이름 ${userObj.name} / 권한 ${userObj.userRole}  님 반값습니다.</h3>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST"> 
		<input type="submit" value="로그아웃" /> 
	</form:form>


</body>
</html>