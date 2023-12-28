<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  - ${name }
</h1>

<P>  The time on the server is ${serverTime} </P>

<h3><a href="/time">time</a></h3>
<h3><a href="/elasticsearch/list">/elasticsearch/list</a></h3>
</body>
</html>
