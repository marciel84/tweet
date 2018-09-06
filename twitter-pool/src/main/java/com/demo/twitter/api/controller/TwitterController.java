package com.demo.twitter.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.twitter.api.controller.dto.ErrorResponse;
import com.demo.twitter.api.controller.dto.TweetsCountDto;
import com.demo.twitter.api.controller.dto.UserDto;
import com.demo.twitter.api.exception.TwitterApiException;
import com.demo.twitter.api.exception.TwitterApiNotFoundException;
import com.demo.twitter.service.TwitterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "/twitter")
@Api(value = "/twitter", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class TwitterController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TwitterController.class);
	
	@Autowired
	private TwitterService service;
	
	@RequestMapping("/users")
	@ApiOperation(value = "Retorna os usuarios que mais possuem seguidores", httpMethod = "GET", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 400, message = "Failure", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Failure", response = ErrorResponse.class) })
	public List<UserDto> getUsersMaxSeg() throws TwitterApiException, TwitterApiNotFoundException {
		
		LOGGER.debug("getUsersMaxSeg - INICIO");
		
		List<UserDto> users = service.getUsersMaxSeg();
		
		LOGGER.debug("getUsersMaxSeg - FIM");
		
		return users;
		
	}
	
	@RequestMapping("/tweets")
	@ApiOperation(value = "Retorna os tweets agrupados por hora", httpMethod = "GET", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success", response = String.class),
			@ApiResponse(code = 400, message = "Failure", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Failure", response = ErrorResponse.class) })
	public List<TweetsCountDto> getTweets() throws TwitterApiException, TwitterApiNotFoundException {
		
		LOGGER.debug("getTweets - INICIO");
		
		List<TweetsCountDto> tweets = service.getTweetsByHour();
		
		LOGGER.debug("getTweets - FIM");
		
		return tweets;
		
	}
}
