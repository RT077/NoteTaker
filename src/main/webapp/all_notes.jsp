<%@page import="org.hibernate.hql.internal.ast.tree.IndexNode"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.entities.NoteTaker"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactoryProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Notes : Notetaker</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-10 m-10">

		<%@include file="navbar.jsp"%>
		<br>
		<h1 class="text-uppercase">all class</h1>
		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from NoteTaker");
		
		List<NoteTaker> list = q.list();
		for (NoteTaker note : list) {
		%>
		<div class="card mt-3">
			<img class="card-img-top m-4" style="max-width: 100px"
				src="image/note.png" alt="Card image cap">
			<div class="card-body px-5">
				<h5 class="card-title">
					<%=note.getTitle()%></h5>
				<p class="card-text"><%=note.getConten()%>
				</p>
				<p><b class="text-primary"> <%=note.getAddesDate() %></b></p>
				<div class="container text-center mt-2">

					<a href="DeleteServlet_D?note_ID=<%=note.getId()%>"
						class="btn btn-danger">Delete</a> 
						
						<a href="edit.jsp?note_ID=<%=note.getId()%>"
						class="btn btn-primary">Update</a>
				</div>

			</div>
		</div>

		<%
		}
		s.close();
		%>
	</div>
</body>
</html>