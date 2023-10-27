package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.FavoriteArticle;

public interface FavoriteArticleService {
	FavoriteArticle save(FavoriteArticle favoriteArticle);
	List<FavoriteArticle>findFavoriteArticle(int userId);
	void delete(long favoriteArticleId);
}