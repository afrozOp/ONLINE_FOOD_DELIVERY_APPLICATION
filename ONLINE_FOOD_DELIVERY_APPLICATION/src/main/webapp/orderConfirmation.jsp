<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Confirmation</title>
<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
<style>
body {
    font-family: 'Inter', sans-serif;
    background-color: #f4f6f8;
    margin: 0;
    padding: 0;
    color: #333;
}

.container {
    max-width: 600px;
    margin: 50px auto;
    background-color: #ffffff;
    padding: 30px 40px;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
    text-align: center;
}

h2 {
    font-size: 24px;
    margin-bottom: 20px;
    color: #fc8019;
}

p {
    font-size: 16px;
    color: #555;
    margin: 10px 0;
}

.order-number {
    font-size: 18px;
    font-weight: bold;
    color: #48c479;
    margin: 15px 0;
}

.btn {
    display: inline-block;
    margin-top: 20px;
    padding: 12px 24px;
    background-color: #fc8019;
    color: white;
    font-weight: bold;
    border: none;
    border-radius: 8px;
    text-decoration: none;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #e76b0a;
}

@media(max-width: 600px) {
    .container {
        margin: 20px;
        padding: 20px;
    }
}
</style>
</head>
<body>

<div class="container">
    <h2>Thank you for your order!</h2>
    <p>Your order has been successfully placed.</p>

    <%-- Optional: show order number if saved in session --%>
    <%
        Integer orderId = (Integer) session.getAttribute("lastOrderId");
        if(orderId != null) {
    %>
        <p class="order-number">Order Number: <%= orderId %></p>
    <%
        }
    %>

    <p>We are preparing your food. It will be delivered soon!</p>

    <a href="home1" class="btn">Back to Restaurants</a>
</div>

</body>
</html>
