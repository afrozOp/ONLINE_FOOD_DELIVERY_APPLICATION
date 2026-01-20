<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.tap.Model.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Restaurant Menu</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
}

body {
	background-color: #f4f6f8;
	color: #333;
}

/* HEADER */
header {
	background-color: #f8fafc;
	color: #1f2937;
	padding: 8px 16px;
	border-bottom: 1px solid #e5e7eb;
	box-shadow: none;
}

header h1 {
	font-size: 16px;
	font-weight: 600;
}

header p {
	font-size: 11px;
	color: #6b7280;
	margin-top: 1px;
}

/* MENU GRID */
.menu-container {
	padding: 40px;
	display: grid;
	grid-template-columns: repeat(auto-fill, minmax(260px, 1fr));
	gap: 25px;
}

.menu-card {
	background-color: #ffffff;
	border-radius: 16px;
	overflow: hidden;
	box-shadow: 0 6px 20px rgba(0, 0, 0, 0.08);
	transition: transform 0.3s, box-shadow 0.3s;
}

.menu-card:hover {
	transform: translateY(-6px);
	box-shadow: 0 12px 30px rgba(0, 0, 0, 0.12);
}

.menu-image img {
	width: 100%;
	height: 180px;
	object-fit: cover;
}

.menu-content {
	padding: 16px;
}

.menu-title {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 6px;
}

.menu-title h3 {
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

.menu-description {
	font-size: 14px;
	color: #666;
	margin: 8px 0 12px;
}

.menu-footer {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.price {
	font-size: 16px;
	font-weight: bold;
	color: #ff5a00;
}

.add-cart {
	background-color: #ff5a00;
	color: #fff;
	border: none;
	padding: 8px 14px;
	border-radius: 8px;
	cursor: pointer;
	font-size: 14px;
	transition: background-color 0.3s;
}

.add-cart:hover {
	background-color: #e04f00;
}

/* RESPONSIVE */
@media ( max-width : 768px) {
	header {
		padding: 20px;
	}
	.menu-container {
		padding: 20px;
	}
}
</style>
</head>
<body>

	<!-- HEADER -->
	<header>
		<h1>Our Menu</h1>
		<p>Delicious food made with love</p>
	</header>

	<!-- MENU ITEMS -->
	<section class="menu-container">



		<%
  	
  	List<Menu> allMenuByRestaurantId=(List<Menu>)request.getAttribute("allMenuByRestaurantId");
  	
  	for(Menu menu:allMenuByRestaurantId)
	{ 
  		%>

		<div class="menu-card">
			<div class="menu-image">
				<img
					src="<%=menu.getImagepath()%>">
			</div>
			<div class="menu-content">
				<div class="menu-title">
					<h3><%=menu.getItemName() %></h3>
					<span class="rating"><%=menu.getRating() %> ★</span>
				</div>
				<p class="menu-description"><%=menu.getDescription() %></p>
				<div class="menu-footer">
					<span class="price">₹<%=menu.getPrice() %></span>
					
					
					<form action="cart">
					
					<input type="hidden" name="itemId" value="<%=menu.getMenuId() %>">
					<input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId() %>">
					<input type="hidden" name="quantity" value="1">
					<input type="hidden" name="action" value="add">
					<input  type="submit" class="add-cart" value="Add to Cart">
					</form>
									
					
					
				</div>
			</div>
		</div>

	



		<% 
	}

  	
  	%>




	</section>
	
</body>
</html>
