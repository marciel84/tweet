package com.demo.twitter.api.controller.dto;

import java.util.List;

public class UserInfoDto {
	
	private List<UserDto> users;

	public UserInfoDto(List<UserDto> users) {
		super();
		this.users = users;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}
	

}
