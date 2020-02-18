<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 보기</title>
<style>
th {
  background-color: #4CAF50;
  color: white;
  text-align: center;
}
table {
  border-collapse: collapse;
  width: 80%;
}
input{
	width:40%;
}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<td><input type="text" value="${MemberVO.no }" readonly ></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" value="${MemberVO.name }"readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" value="${MemberVO.title }"readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" value="${MemberVO.content }"readonly></td>
		</tr>
		<tr>
			<th>시간</th>
			<td><input type="text" value="<fmt:formatDate value="${MemberVO.date}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly/></td>
		</tr>
	</table>
	<div>
		<a href="<c:url value="/edit" />">수정</a>
		<a href="<c:url value="/delete/${MemberVO.no}" />">삭제</a>
		<a href="<c:url value="/list" />">목록</a>
	</div>
</body>
</html>