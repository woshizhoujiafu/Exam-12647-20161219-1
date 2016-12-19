<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<div id="addfilm">
		<form action="<%=request.getContextPath()%>/saveAddFilm" method="post">
		title&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp:<input type="text" name="title" ><br/><br/>
		description:<input type="text" name="description" ><br/><br/>
		<%List list = (List)request.getAttribute("list"); %>
		language:<select name="language" onchange="" margin-left:-20px; ">
                   <option selected id="op">choose language</option>
                   <% for(int i=0;i<list.size();i++){ %>
                   <option value=""><%=list.get(i)%></option>
                   <%} %>
                  </select><br/><br/>
         <input type="submit" name="submit" name="保存"/>      
         </form>
	</div>
</body>
</html>