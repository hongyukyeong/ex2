<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>NOTICE WRITE FORM</h2>

	<form action="notice${path}" method="post">

		<p><input type="hidden" name="num" value="${dto.num}">
		WRITER : <input type="text"  name="writer" value="${dto.num}">
		TITLE : <input type="text"  name=title value="${dto.title}">
		<p><textarea rows="" cols="65"  name="contents" value="${dto.contents }"></textarea></p>
	
	<input type="submit" value="SUBMIT">
	

	</form>




</body>
</html>