<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.Model.Cart, com.tap.Model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
    <title>Your Cart</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }

        /* Navbar */
        .navbar {
            background: #ffffff;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }

        .navbar h2 {
            margin: 0;
            color: #fc8019;
        }

        .nav-links a {
            margin-left: 20px;
            text-decoration: none;
            color: #333;
            font-weight: 500;
        }

        /* Cart Container */
        .cart-container {
            max-width: 900px;
            margin: 30px auto;
            background: #ffffff;
            padding: 20px;
            border-radius: 10px;
        }

        .cart-item {
            display: flex;
            justify-content: space-between;
            align-items: flex-start;
            border-bottom: 1px solid #e0e0e0;
            padding: 15px 0;
        }

        .cart-item:last-child {
            border-bottom: none;
        }

        .cart-item-details h3 {
            margin: 0;
            color: #333;
        }

        .cart-item-details p {
            margin: 5px 0;
            color: #666;
            font-size: 14px;
        }

        /* Quantity controls */
        .quantity-controls {
            display: flex;
            align-items: center;
            margin-bottom: 8px;
        }

        .quantity-btn {
            width: 30px;
            height: 30px;
            border: none;
            background: #fc8019;
            color: white;
            font-size: 18px;
            cursor: pointer;
            border-radius: 5px;
        }

        .quantity-btn:disabled {
            background: #ccc;
            cursor: not-allowed;
        }

        .quantity {
            margin: 0 10px;
            font-weight: bold;
        }

        /* Remove button */
        .remove-btn {
            background: #e23744;
            color: white;
            border: none;
            padding: 6px 14px;
            font-size: 13px;
            border-radius: 5px;
            cursor: pointer;
        }

        .remove-btn:hover {
            opacity: 0.9;
        }

        /* Total */
        .total {
            margin-top: 20px;
            text-align: right;
            font-size: 18px;
            font-weight: bold;
        }

        /* Buttons */
        .actions {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
        }

        .btn {
            padding: 10px 18px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            text-decoration: none;
            font-weight: bold;
        }

        .add-more-btn {
            background: #ffffff;
            color: #fc8019;
            border: 2px solid #fc8019;
        }

        .checkout-btn {
            background: #60b246;
            color: white;
        }

        /* Empty Cart */
        .empty-cart {
            text-align: center;
            padding: 60px 0;
        }

        .empty-cart p {
            color: #757575;
            font-size: 18px;
        }
    </style>
</head>

<body>

<!-- Navbar -->
<div class="navbar">
    <h2>FoodApp</h2>
    <div class="nav-links">
        <a href="home.jsp">Home</a>
        <a href="cart.jsp">Cart</a>
        <a href="profile.jsp">Profile</a>
    </div>
</div>

<div class="cart-container">

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId = (Integer) session.getAttribute("oldRestaurantId");

    if (cart != null && !cart.getItems().isEmpty()) {
        for (CartItem item : cart.getItems().values()) {
%>

    <!-- CART ITEM -->
    <div class="cart-item">

        <div class="cart-item-details">
            <h3><%= item.getName() %></h3>
            <p>Price: ₹<%= item.getPrice() %></p>
            <p>Total: ₹<%= cart.getTotalPrice() %></p>
        </div>

        <div>
            <!-- Quantity Controls -->
            <div class="quantity-controls">

                <!-- PLUS -->
                <form action="cart"  style="display:inline;">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                    <button class="quantity-btn">+</button>
                </form>

                <span class="quantity"><%= item.getQuantity() %></span>

                <!-- MINUS -->
                <form action="cart"  style="display:inline;">
                    <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                    <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                    <button class="quantity-btn"
                        <%= item.getQuantity() == 1 ? "disabled" : "" %>>-</button>
                </form>
            </div>

            <!-- REMOVE BUTTON -->
            <form action="cart" >
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                <input type="hidden" name="action" value="remove">
                <button class="remove-btn">Remove</button>
            </form>
        </div>
    </div>

<%
        }
%>

    <!-- GRAND TOTAL -->
    <div class="total">
        Grand Total: ₹<%= cart.getTotalPrice() %>
    </div>

    <!-- ACTION BUTTONS -->
    <div class="actions">
        <a href="menu?restaurantId=<%= restaurantId %>" class="btn add-more-btn">
            Add More Items
        </a>

        <form action="checkout.jsp" >
            <button class="btn checkout-btn">Proceed to Checkout</button>
        </form>
    </div>

<%
    } else {
%>

    <!-- EMPTY CART -->
    <div class="empty-cart">
        <p>Your cart is empty</p>
        <a href="home1" class="btn add-more-btn">Add Items</a>
    </div>

<%
    }
%>

</div>

</body>
</html>

    