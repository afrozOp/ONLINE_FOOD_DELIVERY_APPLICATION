<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.Model.Restaurant"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Food Delivery | Restaurants</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

body {
	background-color: #f5f5f5;
	color: #333;
}

/* NAVBAR */
.navbar {
	background-color: #ffffff;
	padding: 16px 40px;
	display: flex;
	justify-content: space-between;
	align-items: center;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08);
	position: sticky;
	top: 0;
	z-index: 1000;
}

.logo {
	font-size: 26px;
	font-weight: bold;
	color: #ff5a00;
}

.nav-links a {
	margin-left: 25px;
	text-decoration: none;
	color: #333;
	font-weight: 500;
	transition: color 0.3s;
}

.nav-links a:hover {
	color: #ff5a00;
}

/* PAGE HEADER */
.page-header {
	padding: 30px 40px;
}

.page-header h1 {
	font-size: 28px;
	margin-bottom: 8px;
}

.page-header p {
	color: #666;
}

/* RESTAURANT GRID */
.restaurant-grid {
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
	gap: 25px;
	padding: 20px 40px 60px;
}

.restaurant-card {
	background-color: #ffffff;
	border-radius: 16px;
	overflow: hidden;
	box-shadow: 0 6px 20px rgba(0, 0, 0, 0.08);
	transition: transform 0.3s, box-shadow 0.3s;
}

.restaurant-card:hover {
	transform: translateY(-6px);
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.12);
}

.restaurant-image img {
	width: 100%;
	height: 180px;
	object-fit: cover;
}

.restaurant-content {
	padding: 16px;
}

.restaurant-title {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 6px;
}

.restaurant-title h3 {
	font-size: 18px;
}

.rating {
	background-color: #48c479;
	color: #fff;
	padding: 4px 8px;
	border-radius: 6px;
	font-size: 14px;
	font-weight: 600;
}

.meta {
	font-size: 14px;
	color: #777;
	margin: 6px 0;
}

.description {
	font-size: 14px;
	color: #555;
	margin: 8px 0;
}

.address {
	font-size: 13px;
	color: #888;
	margin-bottom: 10px;
}

.admin {
	font-size: 13px;
	color: #ff5a00;
	font-weight: 600;
}

/* FOOTER */
footer {
	background-color: #ffffff;
	text-align: center;
	padding: 20px;
	font-size: 14px;
	color: #777;
	box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.05);
}

@media ( max-width : 768px) {
	.navbar {
		padding: 16px 20px;
	}
	.page-header, .restaurant-grid {
		padding-left: 20px;
		padding-right: 20px;
	}
}
</style>
</head>
<body>

	<!-- NAVBAR -->
	<nav class="navbar">
		<div class="logo">Foodify</div>
		<div class="nav-links">
			<a href="#">Home</a> <a href="cart.jsp">Cart</a> <a href="#">Profile</a> <a
				href="login.jsp">Login</a>
		</div>
	</nav>

	<!-- PAGE HEADER -->
	<section class="page-header">
		<h1>Restaurants Near You</h1>
		<p>Discover the best food & drinks delivered to your doorstep</p>
	</section>

	<!-- RESTAURANTS -->
	<section class="restaurant-grid">

		<!-- 20 RESTAURANT CARDS -->




		<%
		List<Restaurant> allRestaurant = (List<Restaurant>) request.getAttribute("allRestaurant");

		for (Restaurant restaurant : allRestaurant) {
		%>

		<a href="menu?restaurantId=<%=restaurant.getRestaurantId() %>">
		
			<div class="restaurant-card">
				<div class="restaurant-image">
					<img src="<%=restaurant.getImageURL()%>" />
				</div>
				<div class="restaurant-content">
					<div class="restaurant-title">
						<h3><%=restaurant.getName()%>>
						</h3>
						<span class="rating"><%=restaurant.getRating()%> ★</span>
					</div>
					<div class="meta">
						ETA:
						<%=restaurant.getETA()%>
						mins •
					</div>
					<p class="description"><%=restaurant.getCuisineType()%>.
					</p>
					<div class="address"><%=restaurant.getAddress()%></div>
					<div class="admin">
						Admin ID:
						<%=restaurant.getAdminId()%></div>
				</div>
			</div>



		</a>

		<%
		}
		%>

	</section>

	<footer> © 2026 Foodify | Inspired by top food delivery apps </footer>

</body>
</html>

