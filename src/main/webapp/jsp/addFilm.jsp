<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

#addfilm{
	width:auto;
	height:auto;
	text-align: center;
}

#tab{
	border-style: none;
	margin-left: 30%;
}

#tab tr td{
	width: 200px;
	text-align: center;
}
</style>
</head>

<body>
	<div id="addfilm">
		<form action="<%=request.getContextPath()%>/saveAddFilm" method="post">
			<table id="tab">	
				<tr>
				<td>title:</td><td><input type="text" name="title" ></td>
				</tr>
				<tr>
				<td>description:</td><td><textarea cols="19" rows="5" name="description" ></textarea></td>
				</tr>
				<tr>
				<td>language:</td>
				<%List list = (List)request.getAttribute("list"); %>
				<td><select name="language">
		                   <option>choose language</option>
		                   <% for(int i=0;i<list.size();i++){ %>
		                   <option value="<%=list.get(i)%>"><%=list.get(i)%></option>
		                   <%} %>
		                  </select></td>
		         </tr>
		     </table>	
		         <br/><input type="submit" name="submit" name="保存"/>      
         </form>
	</div>
</body>
</html>