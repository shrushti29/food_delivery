package com.learning.payload.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.learning.entity.TYPE;

import lombok.Data;

@Data
public class FoodRequest {
	
	@NotBlank
	private String id;
	@NotBlank
	private String foodName;
	
	@Min(value = 1)
	private float foodCost;
	
	@NotBlank
	private String foodPic;
	
	@Enumerated(EnumType.STRING)
	private TYPE foodType;
}
