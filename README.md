# Online Food Delivery Application 🍔🛵

A **web‑based Food Delivery Application** built using **Java, JSP, and Servlets**. Users can browse restaurants, view menus, manage a cart, and place orders online.

---

## 🚀 Features

- **User Registration & Login** – Secure account creation and authentication  
- **Restaurant Listing** – Browse available restaurants  
- **Menu Browsing** – View dishes available in each restaurant  
- **Add to Cart / Update Cart** – Add items to cart, update quantities, or remove items  
- **Place Order** – Confirm and place an order  
- **Order Success Page** – Confirmation page after successful order placement

---

## 🛠 Tech Stack

- **Backend:** Java, JSP, Servlets  
- **Frontend:** HTML, CSS  
- **Database:** MySQL  
- **Server:** Apache Tomcat

---

## 📂 Project Structure

Online-Food-Delivery/
│
├── src/main/java/ # Backend Java code (Servlets, DAO, Models)
├── src/main/webapp/ # JSP pages, CSS, images
│ ├── css/ # Stylesheets
│ ├── images/ # Images used in the project
│ ├── index.jsp # Homepage
│ └── ... # Other JSP pages (login, menus, cart, order)
├── lib/ # External libraries (if any)
├── README.md # Project documentation


---

## 💻 How to Run

1. **Clone the Repository**  
   ```bash
   git clone https://github.com/afrozOp/<ONLINE_FOOD_DELIVERY_APPLICATION>

2. Import Project into Eclipse

File → Import → Existing Java Project

3. Configure Apache Tomcat Server

Window → Preferences → Server → Runtime Environments → Add Tomcat

4. Setup MySQL Database

Create a database named food_delivery

Run the SQL script below to create tables and insert sample data

5. Run the Project

Right‑click the project → Run As → Run on Server

-- Create database
CREATE DATABASE IF NOT EXISTS food_delivery;
USE food_delivery;

-- Users table
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Restaurants table
CREATE TABLE restaurants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(100)
);

-- Menu items table
CREATE TABLE menu_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    price DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(id)
);

-- Cart table
CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    menu_item_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (menu_item_id) REFERENCES menu_items(id)
);

-- Orders table
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Sample data
INSERT INTO users (name, email, password) VALUES
('John Doe', 'john@example.com', 'password123'),
('Jane Smith', 'jane@example.com', 'password123');

INSERT INTO restaurants (name, location) VALUES
('Pizza Palace', 'Downtown'),
('Burger Hub', 'Uptown');

INSERT INTO menu_items (restaurant_id, name, description, price) VALUES
(1, 'Margherita Pizza', 'Classic cheese pizza', 250.00),
(1, 'Pepperoni Pizza', 'Pepperoni and cheese', 300.00),
(2, 'Cheeseburger', 'Beef burger with cheese', 150.00),
(2, 'Veggie Burger', 'Burger with fresh vegetables', 120.00);


👩‍💻 Author

Kashimpatel Biradar

GitHub: https://github.com/afrozOp
LinkedIn: https://www.linkedin.com/in/kashimpatel-biradar-19b88a37b/



