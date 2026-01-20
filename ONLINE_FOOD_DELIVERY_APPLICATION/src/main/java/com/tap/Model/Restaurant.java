package com.tap.Model;

public class Restaurant {
	

	
		
		private int restaurantId;
		private String name;
		private int adminId;
		private String address;
		private String cuisineType;
		private double rating;
		private int ETA;
		private String imageURL;
		private String isAvailable;
		
		public Restaurant() {
			// TODO Auto-generated constructor stub
		}

		public Restaurant(int restaurantId, String name, int adminId, String address, String cuisineType, double rating,
				int ETA, String imageURL, String isAvailable) {
			super();
			this.restaurantId = restaurantId;
			this.name = name;
			this.adminId = adminId;
			this.address = address;
			this.cuisineType = cuisineType;
			this.rating = rating;
			this.ETA = ETA;
			this.imageURL = imageURL;
			this.isAvailable = isAvailable;
		}

		public int getRestaurantId() {
			return restaurantId;
		}

		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getCuisineType() {
			return cuisineType;
		}

		public void setCuisineType(String cuisineType) {
			this.cuisineType = cuisineType;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public int getETA() {
			return ETA;
		}

		

		public void setETA(int ETA) {
			this.ETA = ETA;
		}

		public String getImageURL() {
			return imageURL;
		}

		public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
		}

		public String isAvailable() {
			return isAvailable;
		}

		public void setAvailable(String isAvailable) {
			this.isAvailable = isAvailable;
		}
		
		
		
		@Override
		public String toString() {
			return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", adminId=" + adminId + ", address="
					+ address + ", cuisineType=" + cuisineType + ", rating=" + rating + ", ETA=" + ETA + ", imageURL="
					+ imageURL + ", isAvailable=" + isAvailable + "]";
		}
		
		
		

	}



