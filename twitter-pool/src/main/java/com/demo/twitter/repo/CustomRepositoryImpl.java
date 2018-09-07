package com.demo.twitter.repo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.limit;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Repository;

import com.demo.twitter.api.controller.dto.TweetsCountDto;
import com.demo.twitter.api.controller.dto.TweetsHashtagCountDto;
import com.demo.twitter.api.controller.dto.UserDto;
import com.demo.twitter.model.Twitter;

@Repository
public class CustomRepositoryImpl implements CustomRepository {
	
	 @Autowired
	 protected MongoTemplate mongoTemplate;

	@Override
	public List<UserDto> findTop5FollowersCount() {

		Aggregation agg = newAggregation(
				group("user.name").max("user.followersCount").as("followersCount"),
				project("followersCount").and("name").previousOperation(),
				sort(Sort.Direction.DESC, "followersCount"),
				limit(5));
		
		AggregationResults<UserDto> groupResults = mongoTemplate.aggregate(agg, Twitter.class, UserDto.class);
	
		List<UserDto> result = groupResults.getMappedResults();
		
		return result;
		
	}
	 
	public List<TweetsCountDto> getTweetsByHour() {
		
		Aggregation agg = newAggregation(
			project()
				.and("createdAt").dateAsFormattedString("%d/%m/%Y %H").as("dataHora"),
			group("dataHora")
				.addToSet("dataHora").as("dataHora")
				.count().as("total")
		);


		AggregationResults<TweetsCountDto> groupResults = mongoTemplate.aggregate(agg, Twitter.class, TweetsCountDto.class);
			
		List<TweetsCountDto> result = groupResults.getMappedResults();
		
		return result;
	}
	
	public List<TweetsHashtagCountDto> getTweetsByTagAndLang() {
		
		Aggregation agg = newAggregation(
			unwind("hashtagEntities"),
			group("lang", "hashtagEntities.text")
				.count().as("total"),
			project()
				.and("text").as("hashTag")
				.and("lang").as("lang")
				.and("total").as("total")
			
		);
		
		AggregationResults<TweetsHashtagCountDto> groupResults = mongoTemplate.aggregate(agg, Twitter.class, TweetsHashtagCountDto.class);
			
		List<TweetsHashtagCountDto> result = groupResults.getMappedResults();
		
		return result;
	}
	
}
