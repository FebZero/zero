package com.bean;

import java.util.Arrays;

public class User {
		private Integer id;
		private String username;
		private String password;
		private Integer sex;
		private Integer city;
		private String[] hobby;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Integer getSex() {
			return sex;
		}
		public void setSex(Integer sex) {
			this.sex = sex;
		}
		public Integer getCity() {
			return city;
		}
		public void setCity(Integer city) {
			this.city = city;
		}
		public String[] getHobby() {
			return hobby;
		}
		public void setHobby(String[] hobby) {
			this.hobby = hobby;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", city="
					+ city + ", hobby=" + Arrays.toString(hobby) + "]";
		}
		
		
		public User() {
			super();
		}
		public User(Integer id, String username, String password, Integer sex, Integer city, String[] hobby) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.sex = sex;
			this.city = city;
			this.hobby = hobby;
		}
		public User(String username, String password, Integer sex, Integer city, String[] hobby) {
			super();
			this.username = username;
			this.password = password;
			this.sex = sex;
			this.city = city;
			this.hobby = hobby;
		}
}
