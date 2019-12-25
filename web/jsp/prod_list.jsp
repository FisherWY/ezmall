<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.po.Product" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
	<link href="${pageContext.request.contextPath}/css/prodList.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%@ include file="_head.jsp" %>
	<div id="content">
		<div id="search_div">
			<form method="post" action="${pageContext.request.contextPath}/product/searchProd">
				<span class="input_span">商品名：<input type="text" name="name"/></span>
				<span class="input_span">商品种类：<input type="text" name="category"/></span>
				<span class="input_span">商品价格区间：<input type="text" name="minprice"/> - <input type="text" name="maxprice"/></span>
				<input type="submit" value="查 询">
			</form>
		</div>
		<div id="prod_content">
			<c:forEach items="${productList}" var="product">
				<div class="prod_div" onclick="window.location.href='${ pageContext.request.contextPath }/product/getProdinfo?pid=${product.id}'">
					<img src="${pageContext.request.contextPath}${product.imgurl}">
					<div id="prod_name_div">
						${product.name}
					</div>
					<div id="prod_price_div">
						￥${product.price}
					</div>
					<div>
						<div id="gotocart_div">
							<a href="${pageContext.request.contextPath}/cart/addToCart?pid=${product.id}&buyNum=1">加入购物车</a>
						</div>
						<div id="say_div">
							${product.pnum}
						</div>
					</div>
				</div>
			</c:forEach>

			<div style="clear: both"></div>
		</div>
	</div>
	<%@ include file="_foot.jsp" %>
</body>
</html>
