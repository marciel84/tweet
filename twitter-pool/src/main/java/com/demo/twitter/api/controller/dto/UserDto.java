package com.demo.twitter.api.controller.dto;

public class UserDto {
	
	private String name;
	private int followersCount;
	
	public UserDto(String name, int followersCount) {
		super();
		this.name = name;
		this.followersCount = followersCount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	
	

}
