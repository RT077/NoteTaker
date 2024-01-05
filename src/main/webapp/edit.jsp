<%@page import="javax.persistence.criteria.CriteriaBuilder.In"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.helper.*,org.hibernate.*,com.entities.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit page</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-10 m-10">
		<%@include file="navbar.jsp"%>


		<h1>Edit Your Note</h1>
		<br>
		<%
		int noteId = Integer.parseInt(request.getParameter("note_ID").trim());
		Session s = FactoryProvider.getFactory().openSession();

		NoteTaker note = (NoteTaker) s.get(NoteTaker.class, noteId);
		%>
		<form action="UpdateServlet" method="post">
			
			<input value="<%=note.getId()%>" name="noteId" type="hidden">
			
			<div class="form-group">
			
				<label for="title">Note Title</label> 
				<input name="title"
					required="required" type="text" 
					class="form-control" id="title"
					aria-describedby="note" placeholder="Enter here"
					value="<%=note.getTitle()%>" />

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" required="required" id="content"
					placeholder="Enter Your Content here" class="form-control"
					style="height: 300px;"><%=note.getConten()%>
				</textarea>
			</div>
	</div>
	<div class="containe text-center">
		<button type="submit" class="btn btn-success">Save Note</button>
	</div>

	</form>

	</div>
</body>
</html>