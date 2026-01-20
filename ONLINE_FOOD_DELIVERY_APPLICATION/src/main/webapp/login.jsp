<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>

<style>
body {
	margin: 0;
	background-color: #f4f4f4;
	font-family: Arial, sans-serif;
}

.navbar {
	height: 50px;
	background-color: #ff6a00;
}

.container {
	height: calc(100vh - 50px);
	display: flex;
	justify-content: center;
	align-items: center;
}

.card {
	background-color: white;
	width: 380px;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
}

h2 {
	text-align: center;
	margin-bottom: 25px;
}

input {
	width: 100%;
	padding: 10px;
	margin-bottom: 18px;
	border-radius: 6px;
	border: 1px solid #ccc;
}

button {
	width: 100%;
	padding: 12px;
	background-color: #ff6a00;
	border: none;
	color: white;
	font-size: 16px;
	font-weight: bold;
	border-radius: 6px;
	cursor: pointer;
}

a {
	display: block;
	text-align: center;
	margin-top: 15px;
	text-decoration: none;
	color: #ff6a00;
}
</style>
</head>

<body>

	<div class="navbar"></div>

	<div class="container">
		<div class="card">
			<h2>Login</h2>

			<form action="login" method="post">
				<input type="text" name="email" placeholder="Email" required>
				<input type="password" name="password" placeholder="Password"
					required>

				<button type="submit">Login</button>
			</form>

			<%
		String error = (String) request.getAttribute("error");
		if (error != null) {
			%>
			<p style="color: red;"><%= error %></p>
			
			<%
			}
			%>

			<a href="register.jsp">Create an account</a>
		
		</div>
	</div>

</body>
</html>
