package com.demo.twitter.repo;

import java.util.List;

import com.demo.twitter.api.controller.dto.UserDto;
import com.demo.twitter.api.controller.dto.TweetsCountDto;

public interface CustomRepository {

	List<UserDto> findTop5FollowersCount();
	List<TweetsCountDto> getTweetsByHour();
	
}