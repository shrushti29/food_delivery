package com.learning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.EFOOD;
import com.learning.entity.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
	
//	Retrieving food items by food type
	List<Food> findAllByFoodType(EFOOD foodType);

}