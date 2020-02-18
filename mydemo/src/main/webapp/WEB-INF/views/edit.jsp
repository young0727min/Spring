<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
th#c {
  background-color: #4CAF50;
  color: white;
  text-align: center;
}
table {
  border-collapse: collapse;
  width: 80%;
}
input#a{
	width:40%;
}
</style>
<title>Insert title here</title>
</head>

<body>

	<form:form commandName="MemberVO" method="POST">
		<table border="1">
			<tr>
				<th id=c>이름</th>
				<td><form:input id="a" path="name" maxlength="5" size="25"/>
					<form:errors path="name" /></td>
			</tr>
			<tr>
				<th id=c>제목</th>
				<td><form:input id="a" path="title" maxlength="5" size="25"/>
					<form:errors path="title"/></td>
			</tr>
			<tr>
				<th id=c>내용</th>
				<td><form:input id="a" path="content"  maxlength="5" size="25"/>
					<form:errors path="content" /></td>
			</tr>
			<tr>
				<th id=c>비밀번호</th>
				<td><input name="password" />
					${msg}</td>
			</tr>
		</table>
		<div>
			<input type="submit" value="수정">
			<a href="<c:url value="/list" />">목록</a>
		</div>
	</form:form> 
</body>
</html>