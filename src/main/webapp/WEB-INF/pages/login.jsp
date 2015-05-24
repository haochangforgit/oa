﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
    	<base href="<%=basePath%>">
    		
        <meta charset="utf-8">
        <title>Login</title>
		<meta name="keywords" content="Login" />
		<meta name="description" content="Login" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="<%=basePath%>static/css/reset.css">
        <link rel="stylesheet" href="<%=basePath%>static/css/supersized.css">
        <link rel="stylesheet" href="<%=basePath%>static/css/style.css">
		<script type="text/javascript">
		</script>
    </head>

    <body>
        <div class="page-container">
            <h1>登录</h1>
            <form action="verifyToken.go" method="post">
                <input type="text" name="loginName" placeholder="用户名"  value="${loginName}" required />
                <input type="password" name="password" placeholder="密码" value="${password}" required />

                <button type="submit">提交</button>
                
            </form>
                <div class="error">
	                <span>
	                	<c:choose>
		                	<c:when test="${errorCode eq '0'}"> </c:when>
		                	<c:when test="${errorCode eq '1'}"> </c:when>
		                	<c:when test="${errorCode eq '2'}"> </c:when>
		                	<c:otherwise></c:otherwise>
	                	</c:choose>
					</span>
				</div>
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
        </div>
		
        <!-- Javascript -->
        <script src="<%=basePath%>static/js/jquery-1.8.2.min.js"></script>
        <script src="<%=basePath%>static/js/supersized.3.2.7.min.js"></script>
        <script src="<%=basePath%>static/js/supersized-init.js"></script>
        <script src="<%=basePath%>static/js/scripts.js"></script>
		
    </body>

</html>
<script >
	window.onload = function ()
	{
		//alert('${error}');
	}
</script>

