package com.cognizant.entity;

import java.io.Serializable;

public class UserId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3174783496935904775L;

	private int userId;
	
	public UserId(){
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserId [userId=" + userId + "]";
	}
	
	
}
