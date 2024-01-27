package com.takeo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@Column(name = "uid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;

	@Column(name = "fname")
	@JsonProperty("fn")
	private String fname;

	@Column(name = "lname")
	@JsonProperty("ln")
	private String lname;

	@Column(name = "email")
	@JsonProperty("em")
	private String email;

	@Column(name = "uname")
	@JsonProperty("un")
	private String uname;

	@Column(name = "password")
	@JsonProperty("pw")
	private String password;
}
