package com.cognizant.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class FavoriteArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1483936101198787257L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@Column(name="fav_article_id")
	private long favArticleId;
	private int articleId;
	private String url;
	
	/*@ManyToOne(optional=false, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;*/
	
	private int userId;
	
	public FavoriteArticle() {
		super();
	}

	public long getFavArticleId() {
		return favArticleId;
	}

	public void setFavArticleId(long favArticleId) {
		this.favArticleId = favArticleId;
	}


	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FavoriteArticle [favArticleId=" + favArticleId + ", articleId=" + articleId + ", url=" + url
				+ ", userId=" + userId + "]";
	}

	/*public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FavoriteArticle [favArticleId=" + favArticleId + ", articleId=" + articleId + ", url=" + url + ", user="
				+ user + "]";
	}*/
}