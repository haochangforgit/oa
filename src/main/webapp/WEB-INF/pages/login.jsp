<?xml version="1.0" encoding="utf-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
	
    <jsp:directive.page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" />
    <jsp:text>
        <![CDATA[ <?xml version="1.0" encoding="ISO-8859-1" ?> ]]>
    </jsp:text>
    <jsp:text>
        <![CDATA[ <!DOCTYPE html> ]]>
    </jsp:text>
	<html>
		<head>
			<base href="<%=basePath%>">
			<meta charset="utf-8">
			<title>登录</title>
			<link rel="stylesheet" href="<%=basePath%>static/css/style.css" media="screen" type="text/css" />
		</head>
		
		<body>
		
			<center>
				<form>
					<fieldset>
		
						<legend>Login</legend>
						
						<!-- Entypo &#128100;	= User -->
						<input type="text" name="username" id="username" placeholder="Username" pattern="^[a-zA-Z0-9]{3,12}$"
							data-validation-msg="Username must be 2	- 12 characters" required />
						<label for="username" data-icon="&#128100;">Username</label>
		
						<!-- Entypo &#128274;	= Locked -->
						<input type="password" name="password" id="password" placeholder="Password" pattern="^[a-zA-Z0-9]{3,12}$"
							data-validation-msg="Password must be 2-12 characters" required />
						<label for="password" data-icon="&#128274;">Password</label>
						<!-- Entypo &#58542; = Right Arrow -->
						<button value="Submit" data-icon="&#58542;" />
					</fieldset>
				</form>
			</center>
		</body>
	</html>
</jsp:root>