package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int userId;
	
		@Column
		private String username;
		@Column
		private String password;
		public Login() {
			super();
			// TODO Auto-generated constructor stub
		}
		
//		
		public Login(int userId, String username, String password) {
			super();
			this.userId = userId;
			this.username = username;
			this.password = password;
		}


		public String getPassword() {
			return password;
		}

//		public Login(String username, String password) {
//			super();
//			this.username = username;
//			this.password = password;
//		}

		public void setPassword(String password) {
			this.password = password;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}

		
		
}
