
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.learning.entity.Food;
//import com.learning.entity.TYPE;
//import com.learning.exception.AlreadyExistsException;
//import com.learning.exception.IdNotFoundException;
//import com.learning.service.FoodService;
//
//@RestController
//@RequestMapping("/food")
//public class FoodController {
//	
//	@Autowired
//	private FoodService foodService;
//	
////	POST request for adding food item
//	@PostMapping("")
//	public ResponseEntity<?> addFood(@RequestBody Food food) throws AlreadyExistsException {
//		Food result = foodService.addFood(food);
//		return ResponseEntity.status(201).body(result);
//	}
//	
////	GET request for retrieving food item by id
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getFoodById(@PathVariable("id") int id) throws IdNotFoundException {
//		Optional<Food> optional = foodService.getFoodById(id);
//		System.out.println("hello");
//		return ResponseEntity.ok(optional.get());
//	}
//	
////	PUT request for updating food item by id
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateFood(@PathVariable("id") int id, @RequestBody Food food) throws IdNotFoundException {
//		Food result = foodService.updateFood(food, id);
//		return ResponseEntity.status(200).body(result);
//	}
//	
////	GET request for retrieving all food items
//	@GetMapping("")
//	public ResponseEntity<?> getAllFood() {
//		Optional<List<Food>> optional = foodService.getAllFoods();
//		if (optional.isEmpty()) {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("message", "No record found");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
//		}
//		return ResponseEntity.ok(optional.get());
//	}
//	
////	GET request for retrieving food item by food type
//	@GetMapping("/type/{type}")
//	public ResponseEntity<?> getFoodByType(@PathVariable("type") TYPE foodType) {
//		Optional<List<Food>> optional = foodService.getByFoodType(foodType);
//		if (optional.isEmpty()) {
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("message", "Sorry Food Not Found");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
//		}
//		return ResponseEntity.ok(optional.get());
//	}
//	
////	DELETE request for deleting food item by id
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deleteFoodById(@PathVariable("id") int id) throws IdNotFoundException {
//		foodService.deleteFood(id);
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("message", "Food item deleted");
//		return ResponseEntity.status(200).body(map);
//	}
//
//}

package com.learning.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Food;
//import com.zee.zee5app.dto.Series;
import com.learning.payload.request.FoodRequest;
import com.learning.payload.response.MessageResponse;
import com.learning.repository.FoodRepository;

@RestController
@RequestMapping("/api/episode")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;
	//@Autowired
	//private SeriesRepository seriesRepository;
	
	@PostMapping("/addFood")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addFood(@Valid @RequestBody FoodRequest foodRequest) {
		if (foodRepository.existsById(foodRequest.getId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Episode Id already exists!"));
		}
//		if (seriesRepository.existsById(episodeRequest.getSerId()) == false) {
//			return ResponseEntity
//					.badRequest()
//					.body(new MessageResponse("Error: Series Id doesnot exist!"));
//		}
		//Optional<Series> optional = seriesRepository.findById(episodeRequest.getSerId());
		Food episode = new Food(foodRequest.getId(),
				foodRequest.getFoodName(),
				foodRequest.getFoodCost(),
				foodRequest.getFoodPic(),
				foodRequest.getFoodType()
				);
				//optional.get());
		foodRepository.save(episode);
		return ResponseEntity
				.status(201)
				.body(new MessageResponse("Food inserted successfully"));
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> getAllFoods() {
		List<Food> foods = foodRepository.findAll();
		if (foods.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NO_CONTENT)
					.body(new MessageResponse("No record found"));
		}
		return ResponseEntity.ok(foods);
	}

}

