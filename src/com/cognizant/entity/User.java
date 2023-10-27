package com.cognizant.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String mobile;
	private String preferredLanguage;
	private String isAdmin;
	private String isBlocked;
	
	/*@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<FavoriteArticle>favArticles = new HashSet<>();
	
	public Set<FavoriteArticle> getFavArticles() {
		return favArticles;
	}

	public void setFavArticles(Set<FavoriteArticle> favArticles) {
		this.favArticles = favArticles;
	}*/

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPreferredLanguage() {
		return preferredLanguage;
	}

	public void setPreferredLanguage(String preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "["+
					"{\"userId\":"+userId + "," +
					  "\"firstName\":" + firstName+"," +
				      "\"username\":" + username+"," +
				      "\"email\":" + email+"," + 
				      "\"mobile\":" +mobile+"," +
				      "\"preferredLanguage\":" + preferredLanguage+"," +
				      "\"isAdmin\":"+isAdmin + "," + 
				      "\"isBlocked\":"+isBlocked+"}]";
	}
	/*@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", mobile=" + mobile
				+ ", preferredLanguage=" + preferredLanguage + ", isAdmin=" + isAdmin + ", isBlocked=" + isBlocked
				+ "]";
	}*/
}
