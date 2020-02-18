<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 전체보기</title>
<style>
th {
  background-color: #4CAF50;
  color: white;
}
table {
  border-collapse: collapse;
  width: 100%;
}
th, td {
  text-align: center;
  padding: 8px;
  border: 1px solid black;
}
a{
  text-decoration:none;	
}

</style>


</head>
<body>
	<h1>Hello world!</h1>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>제목</th>
				<th>시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${memberList}" var="member">
				<tr>
					<td>${member.no}</td>
					<td>${member.name}</td>
					<td><a href="<c:url value="/read/${member.no }"/>">${member.title}</a></td>
					<td><fmt:formatDate value="${member.date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="<c:url value="/write" />">글쓰기</a>
	</div>


</body>
</html>
