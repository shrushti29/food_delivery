////package com.learning.entity;
////
////import javax.persistence.CascadeType;
////import javax.persistence.Column;
////import javax.persistence.Entity;
////import javax.persistence.GeneratedValue;
////import javax.persistence.GenerationType;
////import javax.persistence.Id;
////import javax.persistence.OneToOne;
////import javax.persistence.Table;
////import javax.validation.constraints.Email;
////import javax.validation.constraints.NotBlank;
////import javax.validation.constraints.Size;
////
////import com.fasterxml.jackson.annotation.JsonIgnore;
////
////import lombok.AllArgsConstructor;
////import lombok.EqualsAndHashCode;
////import lombok.Getter;
////import lombok.NoArgsConstructor;
////import lombok.Setter;
////import lombok.ToString;
////
////@Setter
////@Getter
////@EqualsAndHashCode
////@ToString
////@NoArgsConstructor
////@AllArgsConstructor
////@Entity
////@Table(name = "register")
////public class Register {
////	
////	@Id
////	@Column(name = "regId")
////	@GeneratedValue(strategy = GenerationType.AUTO)
////	private int id;
////	
////	@Size(max = 50)
////	@Email
////	private String email;
////	@Size(max = 50)
////	@NotBlank
////	private String name;
////	@Size(max = 100)
////	@NotBlank
////	private String password;
////	@Size(max = 50)
////	@NotBlank
////	private String address;
////	
////	@JsonIgnore
////	@OneToOne(mappedBy = "register", cascade = CascadeType.ALL)
////	private Login login;
////
////}
//
//package com.learning.entity;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.learning.entity.Login;
//import com.learning.entity.Role;
//import com.learning.entity.Register;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@Getter
//@EqualsAndHashCode
//@ToString
//@NoArgsConstructor
////@AllArgsConstructor
//@Entity
//@Table(name = "register")
//public class Register implements Comparable<Register> {
//	
//	public Register(String name, String email, String password, String address) {
//		this.name = name;
//		this.email = email;
//		this.password = password;
//		this.address = address;
//	}
//	
//	@Id
//	@Column(name = "regId")
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	
//	@Size(max = 50)
//	@Email
//	private String email;
//	@Size(max = 50)
//	@NotBlank
//	private String name;
//	@Size(max = 100)
//	@NotBlank
//	private String password;
//	@Size(max = 50)
//	@NotBlank
//	private String address;
//	
//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userId"),
//	inverseJoinColumns = @JoinColumn(name  = "roleId"))
//	private Set<Role> roles = new HashSet<Role>();
//	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Login login;
//	
//	
//	@Override
//	public int compareTo(Register o) {
//		// TODO Auto-generated method stub
//		return this.id.compareTo(o.getId());
//	}
//
//}
//

package com.learning.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
//@AllArgsConstructor
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Register {

	public Register(String email, String name, String password, String address) {
		this.email = email;
		this.name = name;
		this.password = password;
		this.address = address;
	}

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Size(max = 50)
	@Email
	private String email;
	@Size(max = 50)
	@NotBlank
	private String name;
	@Size(max = 100)
	@NotBlank
	private String password;
	@Size(max = 50)
	@NotBlank
	private String address;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userId"),
	inverseJoinColumns = @JoinColumn(name  = "roleId"))
	private Set<Role> roles = new HashSet<Role>();

}
