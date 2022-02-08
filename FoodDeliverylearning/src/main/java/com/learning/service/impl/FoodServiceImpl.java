package com.learning.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.EFOOD;
import com.learning.entity.Food;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repo.FoodRepository;
import com.learning.service.FoodService;
import com.learning.utils.Fileutils;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository repository;
	@Autowired
	private Fileutils fileUtils;
	
	@Override
	public Food addFood(Food food) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(repository.existsById(food.getFoodId())) {
			throw new AlreadyExistsException("This record already exists");
		}
		else
		return repository.save(food);
	}

	@Override
	public Optional<List<Food>> getAllFoods() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	@Override
	public Optional<Food> getFoodById(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry Food Not Found");
		}
		return optional;
	}

	@Override
	public Food updateFood(Food food, int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (repository.findById(id).isEmpty()) {
			throw new IdNotFoundException("Sorry Food Not Found");
		}
		return repository.save(food);
	}

	@Override
	public String deleteFood(int id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = repository.findById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Sorry Food Not Found");
		else {
			repository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Food>> getByFoodType(EFOOD foodType) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAllByFoodType(foodType));
	}

	

}