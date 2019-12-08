<%@page import="java.net.URLDecoder" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css"/>
    <title>EasyMall欢迎您登录</title>
</head>
<body>
<h1>欢迎登录EasyMall</h1>
<form action="${pageContext.request.contextPath}/user/login" method="POST">
    <table>
        <tr>
            <td class="tdx">用户名：</td>
            <td><input type="text" name="username" value="${username}"/></td>
        </tr>
        <tr>
            <td class="tdx">密&nbsp;&nbsp; 码：</td>
            <td><input type="password" name="password" value="${password}"/></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center">
                <input type="submit" value="登 陆"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center">${msg}</td>
        </tr>
    </table>
</form>
</body>
</html>
