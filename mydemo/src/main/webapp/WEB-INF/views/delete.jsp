<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>

<body>
	<form:form commandName="MemberVO" method="post">
		<table>
			<tr>
				<th>번호</th>
				<td><form:input  path="no"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input name="password"></td>
			</tr>
			<tr>
				<th><input type="submit"></th>
				<th><a href="<c:url value="/read/${MemberVO.no}" />">취소</a></th>
				<th><a href="<c:url value="/list" />">목록</a></th>
			</tr>
		</table>	
	</form:form>
	<div>${msg}</div>
	
</body>

</html>