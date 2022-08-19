<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
   <tr>
      <th>번호</th>
      <th>영화제목</th>
      <th>영화이미지</th>
      <th>장르</th>
   </tr>
 
   <c:forEach var="v" items="${datas}">
   <tr>
      <td>${v.cid}</td>
      <td>${v.title}</td>
      <td>${v.image}</td>
      <td>${v.genre}</td>
   </tr>
   </c:forEach>
</table>

</body>
</html>