package com.capgemini.go.user.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserBean {
	
	private String userType;
	@Id
	private String userId;
	private String password;
	private String re_enterPassword;
	private long phoneNo;
	private String email;
	
	public UserBean() {
		super();
	}

	public UserBean(String userType, String userId, String password, String re_enterPassword, long phoneNo, String email) {
		super();
		this.userType = userType;
		this.userId = userId;
		this.password = password;
		this.re_enterPassword = re_enterPassword;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRe_enterPassword() {
		return re_enterPassword;
	}

	public void setRe_enterPassword(String re_enterPassword) {
		this.re_enterPassword = re_enterPassword;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phoneNo ^ (phoneNo >>> 32));
		result = prime * result + ((re_enterPassword == null) ? 0 : re_enterPassword.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNo != other.phoneNo)
			return false;
		if (re_enterPassword == null) {
			if (other.re_enterPassword != null)
				return false;
		} else if (!re_enterPassword.equals(other.re_enterPassword))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userType=" + userType + ", userId=" + userId + ", password=" + password + ", re_enterPassword="
				+ re_enterPassword + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
	

}
