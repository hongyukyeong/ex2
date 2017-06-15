<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>NOTICE VIEW PAGE</h2>


	<table>

		<tr>
			<th>NUM</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REG_DATE</th>
			<th>HIT</th>
		</tr>


		<tr>
			<td>${view.num}</td>
			<td>${view.title}</td>
			<td>${view.writer}</td>
			<td>${view.reg_date}</td>
			<td>${view.hit}</td>
		</tr>

		<tr>
			<th colspan="5">CONTENTS</th>
		</tr>


		<tr>
			<td colspan="5">${view.contents}</td>
		</tr>


	</table>



<a href="noticeUpdate?num=${view.num}">Update</a>
<a href="noticeDelete?num=${view.num}">Delete</a>


</body>
</html>