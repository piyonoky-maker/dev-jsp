<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello jsp
<%
	//스크립틀릿 - 자바 변수선언이나 제어문을 쓸 수 있는 영역임.
	//스크립틀릿에서 선언한 변수는 모두 지변이다.
	/**
		service메서드 안에 선언되므로 지역변수이다
		1) jsp-api.jar, 2)servlet-api.jar ( 두개가 컴파일을 위한 jar 파일임 )

		자바(서블릿-request, response) 클래스 내부에
		서블릿에서 doGet, doPost, doPut, doDelete
		
		index.jsp -> index_jsp.java -> index_jsp.class
	*/
	
	String msg = "안녕 ~~~";
%>
<!-- html주석임
아래 스크립트를 익스프레션
 -->
<%=msg %>
</body>
</html>