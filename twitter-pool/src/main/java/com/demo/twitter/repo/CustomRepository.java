package com.demo.twitter.repo;

import java.util.List;

import com.demo.twitter.api.controller.dto.UserDto;
import com.demo.twitter.api.controller.dto.TweetsCountDto;
import com.demo.twitter.api.controller.dto.TweetsHashtagCountDto;

public interface CustomRepository {

	List<UserDto> findTop5FollowersCount();
	List<TweetsCountDto> getTweetsByHour();
	List<TweetsHashtagCountDto> getTweetsByTagAndLang();
	
}