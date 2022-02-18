package com.learning.service;

import java.util.List;
import java.util.Optional;

import com.learning.entity.Food;
import com.learning.entity.TYPE;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;

public interface FoodService {
	
	public Food addFood(Food food) throws AlreadyExistsException;
	public Optional<List<Food>> getAllFoods();
	public Optional<Food> getFoodById(String id) throws IdNotFoundException;
	public Food updateFood(Food food, String id) throws IdNotFoundException;
	public String deleteFood(String id) throws IdNotFoundException;
	public Optional<List<Food>> getByFoodType(TYPE foodType);

}
