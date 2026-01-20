<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">

<style>
body {
    font-family: 'Inter', sans-serif;
    background-color: #f4f6f8;   /* ✅ SAME AS MENU PAGE */
    margin: 0;
    padding: 0;
    color: #333;
}

.container {
    max-width: 600px;
    margin: 40px auto;
    background-color: #ffffff;   /* ✅ WHITE CARD */
    padding: 30px 40px;
    border-radius: 16px;
    box-shadow: 0 6px 20px rgba(0,0,0,0.08);
}

h2 {
    font-size: 24px;
    margin-bottom: 25px;
    color: #1f2937;
}

label {
    display: block;
    margin-bottom: 6px;
    font-weight: 600;
    color: #374151;
}

textarea,
select {
    width: 100%;
    padding: 10px;
    margin-bottom: 20px;
    border-radius: 8px;
    border: 1px solid #d1d5db;
    outline: none;
    background-color: #ffffff;
    color: #111827;
}

textarea {
    resize: vertical;
    height: 100px;
}

textarea:focus,
select:focus {
    border-color: #ff5a00;
}

input[type="submit"] {
    width: 100%;
    padding: 12px;
    background-color: #ff5a00;   /* ✅ SAME ORANGE AS MENU */
    color: #ffffff;
    font-size: 16px;
    font-weight: 600;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #e04f00;
}

@media (max-width: 600px) {
    .container {
        margin: 20px;
        padding: 20px;
    }
}
</style>
</head>

<body>

<div class="container">
    <h2>Checkout</h2>

    <form action="checkout" method="post">

        <label for="address">Delivery Address</label>
        <textarea id="address" name="address" required></textarea>

        <label for="paymentMethod">Payment Method</label>
        <select name="paymentMethod" id="paymentMethod" required>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="Cash on Delivery">Cash on Delivery</option>
        </select>

        <input type="submit" value="Place Order">

    </form>
</div>

</body>
</html>
