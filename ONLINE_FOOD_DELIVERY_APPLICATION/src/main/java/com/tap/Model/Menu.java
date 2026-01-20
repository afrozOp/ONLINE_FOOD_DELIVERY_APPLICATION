package com.tap.Model;

public class Menu {
	
	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private double price;
	private String rating;
	private String imagepath;
	private String type;
	
	public Menu() {
	
		
	}

	public Menu(int menuId, int restaurantId, String itemName, String description, double price, String rating,
			String imagepath, String type) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.imagepath = imagepath;
		this.type = type;
	}
	
	public Menu( int restaurantId, String itemName, String description, double price, String rating,
			String imagepath, String type) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.rating = rating;
		this.imagepath = imagepath;
		this.type = type;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", rating=" + rating + ", imagepath=" + imagepath + ", type="
				+ type + "]";
	}
	
	
	

}
