<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css"/>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>

<div id="common_head">
    <div id="line1">
        <div id="content">
            <c:if test="${sessionScope.user!=null }">
                欢迎&nbsp;${sessionScope.user.username}&nbsp;回来！&nbsp;&nbsp;|&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath }/index/exit">退出</a>
            </c:if>
            <c:if test="${sessionScope.user==null }">
                <a href="${pageContext.request.contextPath }/index/login">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath }/index/register">注册</a>
            </c:if>
        </div>
    </div>
    <div id="line2">
        <img id="logo" src="${pageContext.request.contextPath}/img/head/logo.jpg"/>
        <input type="text" name=""/>
        <input type="button" value="搜 索"/>
        <span id="goto">
			<a id="goto_order" href="#">我的订单</a>
			<a id="goto_cart" href="#">我的购物车</a>
		</span>
        <img id="erwm" src="${pageContext.request.contextPath}/img/head/qr.jpg"/>
    </div>
    <div id="line3">
        <div id="content">
            <ul>
                <li><a href="#">首页</a></li>
                <li><a href="${ pageContext.request.contextPath }/before/prodlist">全部商品</a></li>
                <li><a href="#">手机数码</a></li>
                <li><a href="#">电脑平板</a></li>
                <li><a href="#">家用电器</a></li>
                <li><a href="#">汽车用品</a></li>
                <li><a href="#">食品饮料</a></li>
                <li><a href="#">图书杂志</a></li>
                <li><a href="#">服装服饰</a></li>
                <li><a href="#">理财产品</a></li>
            </ul>
        </div>
    </div>
</div>