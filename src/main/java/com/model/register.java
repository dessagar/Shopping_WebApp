package com.model;

public class register {
		private int custId;
		private String userName;
		private String passWord;
		private String custName;
		private String email;
		private String mobNo;
		private String city;
		private String state;
		
		public register(int custId, String userName, String passWord, String custName, String email, String mobNo,
				String city, String state) {
			super();
			this.custId = custId;
			this.userName = userName;
			this.passWord = passWord;
			this.custName = custName;
			this.email = email;
			this.mobNo = mobNo;
			this.city = city;
			this.state = state;
		}

		public int getCustId() {
			return custId;
		}

		public void setCustId(int custId) {
			this.custId = custId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassWord() {
			return passWord;
		}

		public void setPassWord(String passWord) {
			this.passWord = passWord;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobNo() {
			return mobNo;
		}

		public void setMobNo(String mobNo) {
			this.mobNo = mobNo;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}
		
		
}
