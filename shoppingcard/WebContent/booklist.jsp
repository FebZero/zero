<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
div{
float:left
}
</style>
</head>
<body>
<c:forEach items="${books}" var="b" varStatus="s">
<div>
<form action="ShoppingCarServlet" method="post">
<input type="hidden" name="id" value="${b.id}">
<input type="hidden" name="bookname" value="${b.bookname}">
<input type="hidden" name="isbn" value="${b.isbn}">
<input type="hidden" name="author" value="${b.author}">
<input type="hidden" name="press" value="${b.press}">
<input type="hidden" name="price" value="${b.price}">
<input type="hidden" name="picture" value="${b.picture}">
<img src="${b.picture }" height="250" width="200"><br/>
书名：${b.bookname }<br/>
编码：${b.isbn }<br/>
作者：${b.author }<br/>
出版社：${b.press }<br/>
价格：${b.price}<br/>
<button>加入购物车</button>
</form>
</div>
</c:forEach>
</body>
</html>