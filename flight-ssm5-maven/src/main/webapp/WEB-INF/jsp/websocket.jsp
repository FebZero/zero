<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%pageContext.setAttribute("p", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<script src="${p}/assets/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
<script type="text/javascript">
$(function(){
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:28080/score-ssm5-maven/websocket/socketServer");
    } 
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:28080/score-ssm5-maven/websocket/socketServer");
    } 
    else {
        websocket = new SockJS("http://localhost:28080/score-ssm5-maven/sockjs/socketServer");
    }
    //建立连接
    websocket.onopen = function(){
    	alert("Websocket 通道已打开")
    }
    //收到消息
    websocket.onmessage = function(evt){
    	console.log("收到 Websocket消息 ")
    	console.log(evt)
    	document.getElementById("servermsg").innerHTML=evt.data;
    }
    //发生错误
    websocket.onerror = function(){
    	alert("Websocket 错误");
    }
    //关闭连接
    websocket.onclose = function(){
    	alert("Websocket 关闭")
    }
              
    //向websocket发武器发送消息
    $("#sendBtn").click=function(){
    	if (websocket.readyState == websocket.OPEN) {          
            var msg = document.getElementById("inputMsg").value;  
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");  
        } else {  
            alert("连接失败!");  
        }  
    }
    
    //取得session里的用户名
    var username = '${username}';
    //让websocket服务器推送消息
    $.get("${p}/websocket/send?username="+username,function(){
    	
    })
});
</script>
请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>
<button id="sendBtn">发送给webscoket服务器</button><br/>
<div id="servermsg"></div>
</body>
</html>