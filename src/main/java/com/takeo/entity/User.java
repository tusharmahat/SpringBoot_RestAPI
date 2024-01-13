package com.takeo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

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
