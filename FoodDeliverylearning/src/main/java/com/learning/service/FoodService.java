package com.learning.service;

import java.util.List;

import com.learning.entity.Food;

public interface FoodService {
	public Food saveFood(Food food);
	public List<Food> saveFoods(List<Food> foods);
	public Food getFoodById(int foodId);
	public List<Food> getFood();
	public String updateFood(int foodId, Food food) throws Exception;
	public String deleteFood(int foodId);
}
