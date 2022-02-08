package com.learning.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.entity.Food;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;

public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodrepository;
	@Override
	public Food saveFood(Food food)
	{
		return foodrepository.save(food);
	}
	@Override
	public List<Food> saveFoods(List<Food> foods)
	{
		return foodrepository.saveAll(foods);
	}
	@Override
	public Food getFoodById(int foodId)
	{
		return foodrepository.findById(foodId).orElse(null);
	}
	@Override
	public List<Food> getFood()
	{
		return foodrepository.findAll();
	}
	@Override
	public String updateFood(int foodId, Food food) throws Exception {
		// TODO Auto-generated method stub
		
		if(!this.foodrepository.existsById(foodId))
			throw new Exception("invalid id");
		
		return (this.foodrepository.save(food)!= null) ? "success":"fail";}
@Override
	public String deleteFood(int foodId)
	{
		foodrepository.deleteById(foodId);
		return "id removed";
	}

}
