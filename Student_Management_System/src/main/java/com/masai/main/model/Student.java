package com.masai.main.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Size(min = 3 , max = 30, message ="Name Should be of Minimum 3 and Maximum 30 characters")
	private String name;
	
	@Column(unique = true)
	private String email;
	
	@Size(min = 0,max = 1000,message = "Minimum score should be 0 and maximum should be 1000")
	private Integer score;
	


}
