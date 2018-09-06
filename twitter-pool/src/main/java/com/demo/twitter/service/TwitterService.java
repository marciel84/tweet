package com.demo.twitter.service;

import java.util.List;

import com.demo.twitter.api.controller.dto.TweetsCountDto;
import com.demo.twitter.api.controller.dto.UserDto;
import com.demo.twitter.api.exception.TwitterApiException;
import com.demo.twitter.api.exception.TwitterApiNotFoundException;

public interface TwitterService {
	
	List<UserDto> getUsersMaxSeg() throws TwitterApiException, TwitterApiNotFoundException;
	
	List<TweetsCountDto> getTweetsByHour() throws TwitterApiException, TwitterApiNotFoundException;

}
