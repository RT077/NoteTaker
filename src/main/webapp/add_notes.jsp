<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Notes</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class="container-fluid p-10 m-10">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>Please Fill Your Note Details</h1>
		<br>
		<!-- this is adsd form   -->
		<form action="SaveNoteServlet" method="post">
			<div class="form-group">
				<label for="title">Note Title</label> <input name="title"
					required="required" type="text" class="form-control" id="title"
					aria-describedby="note" placeholder="Enter here" />

			</div>
			<div class="form-group">
				<label for="content">Note Content</label>
				<textarea name="content" required="required" id="content"
					placeholder="Enter Your Content here" class="form-control"
					style="height: 300px;">
				
				</textarea>
			</div>
	</div>
	<div class="containe text-center">
		<button type="submit" class="btn btn-primary">Add</button>
	</div>

	</form>
	</div>


</body>
</html>