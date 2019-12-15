<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=UTF-8" />
		<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<%@ include file="_head.jsp" %>
		<div id="wrap">
			<!-- 标题信息 -->
			<ul id="title">
				<li>
					<input class="allC" name="allC" type="checkbox"/>
					<span id="title_checkall_text">全选</span>
				</li>
				<li class="li_prod">商品</li>
				<li>单价（元）</li>
				<li>数量</li>
				<li>小计（元）</li>
				<li>操作</li>
			</ul>

			<!-- 购物信息 -->
			<c:set var="totalMoney" value="0"></c:set>
			<c:forEach items="${cartmap}" var="entry">
				<ul class="prods">
					<li>
						<input type="checkbox" class="prodC"/>
					</li>
					<li class="li_prod">
						<img src="${pageContext.request.contextPath}${entry.key.imgurl}" width="90" height="90" class="prodimg" />
						<span class="prodname">${entry.key.name}</span>
					</li>
					<li class="li_price">${entry.key.price}</li>
					<li>
						<a href="javascript:void(0)" class="delNum" >-</a>
						<input id="${entry.key.id}" class="buyNumInp" type="text" readonly="readonly" value="${entry.value}" />
						<a href="javascript:void(0)" class="addNum" >+</a>
					</li>
					<li class="sum_price">${entry.key.price * entry.value}</li>
					<li><a id="" class="delProd" href="javascript:void(0)">删除</a></li>
				</ul>
				<c:set var="totalMoney" value="${totalMoney + entry.key.price * entry.value}"></c:set>
			</c:forEach>

			<!-- 总计条 -->
			<div id="total">
				<div id="total_1">
					<input type="checkbox" class="allC" name="allC"/>
					<span>全选</span>
					<a id="del_a" href="javascript:void(0)">删除选中的商品</a>
					<div id="div_sum">
						<span id="span_1">总价：</span>
						<span>￥</span>
						<span id="span_2" class="total_sum_price">${totalMoney}</span>&nbsp;&nbsp;&nbsp;
					</div>
				</div>
				<div id="total_2">
					<a id="goto_order" href="${pageContext.request.contextPath}/index/orderadd">去结算</a>
				</div>
			</div>
		</div>
	<%@ include file="_foot.jsp" %>
	</body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			function totalMoney(obj, buyNum) {
				// 计算当前商品总价
				var price = $(obj).parents("ul").find(".li_price").text();
				var prod_sum = price * buyNum;
				$(obj).parents("ul").find(".sum_price").text(prod_sum);
				// 计算所有商品总价
				var totalMoney = 0;
				$(".sum_price").each(function () {
					totalMoney += parseFloat($(this).text())
				})
				$("#span_2").text(totalMoney);
			}

			$(".delNum").click(function () {
				var buyNumInput = $(this).siblings("input");
				var buyNum = parseInt(buyNumInput.val());
				if (buyNum > 1) {
					buyNum -= 1;
					buyNumInput.val(buyNum);
					var pid = buyNumInput.attr("id");
					$.post("${pageContext.request.contextPath}/cart/updateBuyNum", {
						"pid": pid,
						"buyNum": buyNum
					})
				}
				totalMoney(this, buyNum)
			});

			$(".addNum").click(function () {
				var buyNumInput = $(this).siblings("input");
				var buyNum = parseInt(buyNumInput.val()) + 1;
				buyNumInput.val(buyNum);
				var pid = buyNumInput.attr("id");
				$.post("${pageContext.request.contextPath}/updateBuyNum", {
					"pid": pid,
					"buyNum": buyNum
				})

				totalMoney(this, buyNum)
			});

			$(".delProd").click(function () {
				var pid = $(this).attr("id");

				$.post("${pageContext.request.contextPath}/updateBuyNum", {
					"pid": pid,
					"buyNum": -1
				})
				$(this).parents("ul").remove()
				// 计算所有商品总价
				var totalMoney = 0;
				$(".sum_price").each(function () {
					totalMoney += parseFloat($(this).text())
				})
				$("#span_2").text(totalMoney);
			});
		});
	</script>
</html>