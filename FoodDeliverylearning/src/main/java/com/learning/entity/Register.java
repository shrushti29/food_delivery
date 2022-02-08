package com.learning.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "register")
public class Register {
	
	@Id
	@Column(name = "regId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(max = 50)
	@Email
	private String email;
	@Size(max = 100)
	@NotBlank
	private String name;
	@Size(max = 100)
	@NotBlank
	private String password;
	@Size(max = 100)
	@NotBlank
	private String address;
	
	@JsonIgnore
	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
	private Login login;

}

