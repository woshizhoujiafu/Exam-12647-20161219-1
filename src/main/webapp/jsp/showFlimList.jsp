<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hand.zjf.entity.Film" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<table>
			<tr>
				<th>film_id</th>
				<th>title</th>
				<th>description</th>
				<th>language</th>
				<th>删除</th>
			</tr>
			<% List<Film> film = new ArrayList<>();
			   film = (List<Film>)request.getAttribute("film");
			%>
			<% for(int i=0;i < film.size();i++){ %>
			<tr>
				<td><%=film.get(i).getFilmId() %></td>
				<td><%=film.get(i).getTitle() %></td>
				<td><%=film.get(i).getDescription() %></td>
				<td><%=film.get(i).getLanguage() %></td>
				<td><a href="<%=request.getContextPath()%>/deleteFilm?filmId=<%=film.get(i).getFilmId()%>">删除</a></td>
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>