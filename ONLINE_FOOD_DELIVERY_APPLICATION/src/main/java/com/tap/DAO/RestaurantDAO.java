package com.tap.DAO;

import java.util.List;

import com.tap.Model.Restaurant;

public interface RestaurantDAO {
	
	int addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurant();

}
