package com.User.Service.Entitys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.User.Service.Payload.ApiResponse;
import com.User.Service.Payload.ApiResponse.ApiResponseBuilder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "user_Service")
public class User {
	@Id
	@Column(name = "Id")
	private String UserId;
	@Column(name = "Name")
	private String name;
	@Column(name = "Email")
	private String email;
	@Column(name = "About")
	private String about;
	@Transient
	private List<Rating> rating=new ArrayList<Rating>();

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String userId) {
		UserId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public User(String userId, String name, String email, String about, List<Rating> rating) {
		super();
		UserId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.rating = rating;
	}

	public List<Rating> getRating() {
		return rating;
	}

	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "User [UserId=" + UserId + ", name=" + name + ", email=" + email + ", about=" + about + "]";
	}

	public User(String userId, String name, String email, String about) {
		super();
		UserId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Builder class
	public static ApiResponseBuilder builder() {
		return new ApiResponseBuilder();
	}

	// Builder class
	public static class ApiResponseBuilder {
		private String UserId;
		private String name;
		private String email;
		private String about;
		private List<Rating> rating;
		// private HttpStatus status;

		private ApiResponseBuilder() {
		}

		public ApiResponseBuilder UserId(String UserId) {
			this.UserId = UserId;
			return this;
		}

		public ApiResponseBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ApiResponseBuilder email(String email) {
			this.email = email;
			return this;
		}

		public ApiResponseBuilder about(String about) {
			this.about = about;
			return this;
		}

		public ApiResponseBuilder rating(List<Rating> rating) {
			this.rating = rating;
			return this;
		}

		public User build() {
			return new User(UserId, name, email, about, rating);
		}
	}
}
