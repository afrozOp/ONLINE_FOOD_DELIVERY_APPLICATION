<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Register</title>

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
    width: 420px;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0,0,0,0.15);
}

input {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
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
}
</style>
</head>

<body>

<div class="navbar"></div>

<div class="container">
    <div class="card">
        <h2 style="text-align:center;">Register</h2>

        <form action="register" method="post">
            <input type="text" name="name" placeholder="Full Name" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="phone" placeholder="Phone Number" required>

            <button type="submit">Register</button>
        </form>
    </div>
</div>

</body>
</html>
