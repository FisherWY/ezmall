<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>欢迎注册EasyMall</title>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/regist.css"/>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/regist" method="POST">
    <h1>欢迎注册EasyMall</h1>
    <table>
        <tr>
            <td class="tds">用户名：</td>
            <td>
                <input type="text" name="username" value="${username}"/>
            </td>
        </tr>
        <tr>
            <td class="tds">密码：</td>
            <td>
                <input type="password" name="password" value="${password}"/>
            </td>
        </tr>
        <tr>
            <td class="tds">确认密码：</td>
            <td>
                <input type="password" name="password2" value="${password2}"/>
            </td>
        </tr>
        <tr>
            <td class="tds">昵称：</td>
            <td>
                <input type="text" name="nickname" value="${nickname}"/>
            </td>
        </tr>
        <tr>
            <td class="tds">邮箱：</td>
            <td>
                <input type="text" name="email" value="${email}"/>
            </td>
        </tr>
        <tr>
            <td class="sub_td" colspan="2" class="tds">
                <input type="submit" value="注册用户"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align:center">
                <c:if test="${m!=null}">
                    添加了${m}条记录！
                </c:if>
                <c:if test="${msg!=null }">
                    ${msg}
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
