<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<title>Insert title here</title>
</head>
<body>
	<%
	  session.setAttribute("flag", "error");
    %>

	<div id="oper">
		<ul id="operul">
			<li><a href="<%=request.getContextPath()%>/GetFilmList">film列表显示</a></li>
			<li><a href="<%=request.getContextPath()%>/GetLanguage">film信息添加</a></li>
		</ul>
	</div>
	<div id="login">
		<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
			用户名：<input type="text" name="firstName">
			<input type="submit" name="submit" value="登录">
		</form>
	</div>
</body>
</html>