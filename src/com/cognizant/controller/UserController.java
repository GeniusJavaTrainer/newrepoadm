package com.cognizant.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.FavoriteArticle;
import com.cognizant.entity.Login;
import com.cognizant.entity.User;
import com.cognizant.entity.UserId;
import com.cognizant.service.FavoriteArticleService;
import com.cognizant.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

	private Set<String>jwtTokens = new HashSet<>();
	
	private User user;
	@Autowired
	private UserService userService;

	@Autowired
	FavoriteArticleService favArticleService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public User registerUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User blockUser(@RequestBody User user) {
		return userService.save(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody Login login) throws ServletException {

		String jwtToken = "";

		String username = login.getUsername();
		String password = login.getPassword();
		System.out.println(username);
		System.out.println(password);
		if (username == null || password == null) {
			throw new ServletException("Please fill in username and password");
		}

		user = userService.findUser(username, password);

		if (user == null) {
			throw new ServletException("User email not found.");
		}

		String pwd = user.getPassword();

		if (!password.equals(pwd)) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}

		jwtToken = Jwts.builder().setSubject(username).claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();

		jwtTokens.add(jwtToken);
		return jwtToken;
	}

	@RequestMapping(value = "/Username", method = RequestMethod.POST)
	public User finduser(@RequestBody User login) throws ServletException {

		if (login.getUsername() == null) {
			throw new ServletException("There is no such news analyst");
		}

		String username = login.getUsername();

		User user = userService.findByUsername(username);

		return user;
	}
	
	@RequestMapping(value = "/User", method = RequestMethod.GET)
	public User returnUser(@RequestParam String jwtToken) throws ServletException {
		User user = null;
		System.out.println(user);
		System.out.println(jwtToken);
		if(jwtTokens.contains(jwtToken)){
			user = this.user;
		}
		return user;
	}

	@RequestMapping(value = "/findFavorites", method = RequestMethod.POST)
	public List<FavoriteArticle> findFavorites(@RequestBody UserId userId,  String jwtToken) throws ServletException {
		List<FavoriteArticle>favoriteArticles = null;
		System.out.println(jwtToken);
		if(jwtTokens.contains(jwtToken)){
			favoriteArticles = favArticleService.findFavoriteArticle(userId.getUserId());
		}
		
		return favoriteArticles;
	}
	
	@RequestMapping(value = "/Fav", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String addToFavorites(FavoriteArticle favoriteArticle) throws ServletException {

		/*article.setUser(user);
		Set<FavoriteArticle> favArticles = new HashSet<>();
		favArticles.add(article);
		user.setFavArticles(favArticles);*/
		//user = userService.save(user);
		favArticleService.save(favoriteArticle);
		return "Record inserted";
	}

	@RequestMapping(value = "/Fav/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String removeFavorites(int favArticleId) throws ServletException {
		favArticleService.delete(favArticleId);
		return "Record deleted";
	}
}
