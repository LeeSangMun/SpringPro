<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="shortcut icon" href="http://localhost/images/SiSt.ico">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/cdn-main/example.css">
<script src="/resources/cdn-main/example.js"></script>
<style>
 span.material-symbols-outlined{
    vertical-align: text-bottom;
 }
 
 #chatArea {
 	width: 200px;
 	height: 100px;
 	overflow: auto;
 	border: 1px solid black; 
 }
 
 
</style>

<script>
	var wsocket;
	
	function connect() {
		wsocket = new WebSocket("ws://192.168.10.178:80/chat-ws");
		wsocket.onopen = onOpen;
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
	}
	
	function disconnect() {
		wsocket.close();
	}
	
	function onOpen(evt) {
		appendMessage("연결되었습니다.");
	}
	
	function onMessage(evt) {
		var data = evt.data;
		if(data.substring(0, 4) == "msg:") {
			appendMessage(data.substring(4));
		}
	}
	
	function onClose(evt) {
		appendMessage("연결을 끊었습니다.");
	}
	
	function send() {
		var nickname = $("#nickname").val();
		var msg = $("#message").val();
		wsocket.send("msg:" + nickname + ":" + msg);
		$("#message").val("");
	}
	
	function appendMessage(msg) {
		$("#chatMessageArea").append(msg + "<br>");
		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}
	
	$(document).ready(function() {
		$("#message").keypress(function(event) {
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if(keycode == '13') {
				send();
			}
			event.stopPropagation();
		});
		$("#sendBtn").click(function() {send();});
		$("#enterBtn").click(function() {connect();});
		$("#exitBtn").click(function() {disconnect();});
	})
</script>

</head>
<body>
	이름:<input type="text" id="nickname">
	<input type="button" id="enterBtn" value="입장"/>
	<input type="button" id="exitBtn" value="나가기"/>

	<h1>대화 영역</h1>
	<div id="chatArea"><div id="chatMessageArea"></div></div>
	<br>
	<input type="text" id="message"/>
	<input type="button" id="sendBtn" value="전송"/>
</body>
</html>