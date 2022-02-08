package com.learning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "food")

	
	
	

public class Food {
	
	@Id
	@Column(name = "foodId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int foodId;
	
	@NotBlank
	private String foodName;
	@Min(value = 1)
	private float foodCost;
	@NotBlank
	private String foodPic;
	
	@Enumerated(EnumType.STRING)
	private EFOOD foodType;

}

