//package com.learning.service.impl;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.learning.entity.Food;
//import com.learning.entity.TYPE;
//import com.learning.exception.AlreadyExistsException;
//import com.learning.exception.IdNotFoundException;
//import com.learning.repo.FoodRepo;
//import com.learning.service.FoodService;
//import com.learning.utils.FileUtils;
//
//@Service
//public class FoodServiceImpl implements FoodService {
//	
//	@Autowired
//	private FoodRepo foodRepo;
//	
//	@Override
//	public Food addFood(Food food) throws AlreadyExistsException {
//		// TODO Auto-generated method stub
//		if(foodRepo.existsById(food.getId())) {
//			throw new AlreadyExistsException("This record already exists");
//		}
//		return foodRepo.save(food);
//	}
//
//	@Override
//	public Optional<List<Food>> getAllFoods() {
//		// TODO Auto-generated method stub
//		return Optional.ofNullable(foodRepo.findAll());
//	}
//
//	@Override
//	public Optional<Food> getFoodById(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<Food> optional = foodRepo.findById(id);
//		if (optional.isEmpty()) {
//			throw new IdNotFoundException("Sorry Food Not Found");
//		}
//		return optional;
//	}
//
//	@Override
//	public Food updateFood(Food food, int id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		if (foodRepo.findById(id).isEmpty()) {
//			throw new IdNotFoundException("Sorry Food Not Found");
//		}
//		return foodRepo.save(food);
//	}
//
//	@Override
//	public String deleteFood(String id) throws IdNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<Food> optional = foodRepo.findById(id);
//		if (optional.isEmpty())
//			throw new IdNotFoundException("Sorry Food Not Found");
//		else {
//			foodRepo.deleteById(id);
//			return "Success";
//		}
//	}
//
//	@Override
//	public Optional<List<Food>> getByFoodType(TYPE foodType) {
//		// TODO Auto-generated method stub
//		return Optional.ofNullable(foodRepo.findAllByFoodType(foodType));
//	}
//
//}

package com.learning.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.Food;
import com.learning.entity.TYPE;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.repository.FoodRepository;
import com.learning.service.FoodService;
import com.learning.utils.FileUtils;

@Service
public class FoodServiceImpl implements FoodService {
	
	@Autowired
	private FoodRepository foodRepo;
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public Food addFood(Food food) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(foodRepo.existsById(food.getId())) {
			throw new AlreadyExistsException("This record already exists");
		}
		
		return foodRepo.save(food);
	}

	@Override
	public Optional<List<Food>> getAllFoods() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepo.findAll());
	}

	@Override
	public Optional<Food> getFoodById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = foodRepo.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Sorry Food Not Found");
		}
		return optional;
	}

	@Override
	public Food updateFood(Food food, String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		if (foodRepo.findById(id).isEmpty()) {
			throw new IdNotFoundException("Sorry Food Not Found");
		}
		return foodRepo.save(food);
	}

	@Override
	public String deleteFood(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Food> optional = foodRepo.findById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Sorry Food Not Found");
		else {
			foodRepo.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Food>> getByFoodType(TYPE foodType) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(foodRepo.findAllByFoodType(foodType));
	}

}

