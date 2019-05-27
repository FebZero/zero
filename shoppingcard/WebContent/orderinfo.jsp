<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
border-collapse: collapse;
width:600px;
}
th,td{
border:1px solid
}
</style>
</head>
<body>
订单信息
<hr/>
订单编号：${orderno}<br/>
下单时间：${orderTime}<br/>
<table>
<caption>购物车列表</caption>
<tr><th>封面</th><th>id</th><th>书名</th><th>编码</th><th>作者</th><th>出版社</th><th>单价</th><th>数量</th><th>总价</th></tr>
<c:forEach items="${cartList}" var="c" varStatus="s">
<tr>
<td><img src="${c.product.picture }" height="80" width="60"></td>
<td>${c.product.id }</td>
<td>${c.product.bookname }</td>
<td>${c.product.isbn }</td>
<td>${c.product.author }</td>
<td>${c.product.press}</td>
<td>${c.product.price }</td>
<td>${c.count }</td>
<td class="price">${c.product.price * c.count}</td>
</tr>
</c:forEach>
</table>

</body>
</html>