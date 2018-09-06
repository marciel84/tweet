package com.demo.twitter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.twitter.api.controller.dto.TweetsCountDto;
import com.demo.twitter.api.controller.dto.UserDto;
import com.demo.twitter.api.exception.TwitterApiException;
import com.demo.twitter.api.exception.TwitterApiNotFoundException;
import com.demo.twitter.repo.CustomRepository;
import com.demo.twitter.service.TwitterService;

@Service
public class TwitterServiceImpl implements TwitterService {
	
	@Autowired
	private CustomRepository customRepo;

	@Override
	public List<UserDto> getUsersMaxSeg() throws TwitterApiException, TwitterApiNotFoundException {

		try {
			
			List<UserDto> users = customRepo.findTop5FollowersCount();
			
			if(users.isEmpty()) {
				throw new TwitterApiNotFoundException("A consulta nao retornou registros");
			}
			
			return users;
			
		} catch (Exception e) {
			throw new TwitterApiException(e.getMessage(), e);
		}
		
	}

	@Override
	public List<TweetsCountDto> getTweetsByHour() throws TwitterApiException, TwitterApiNotFoundException {
		
		try {
			
			List<TweetsCountDto> tweets = customRepo.getTweetsByHour();
			
			if(tweets.isEmpty()) {
				throw new TwitterApiNotFoundException("A consulta nao retornou registros");
			}
			
			return tweets;
			
		} catch (Exception e) {
			throw new TwitterApiException(e.getMessage(), e);
		}
	}

}
