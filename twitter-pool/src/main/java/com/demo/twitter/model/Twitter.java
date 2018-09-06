package com.demo.twitter.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.Place;
import twitter4j.User;

@Document(collection = "twitter")
public class Twitter {
	
	@Id
	private String id;
	private Date createdAt;
    private String text;
    private String source;
    private boolean isRetweeted;
    private GeoLocation geoLocation = null;
    private Place place = null;
    private long retweetCount;
    private String lang;
    private HashtagEntity[] hashtagEntities;
    private User user = null;
    private int followersCount;

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public boolean isRetweeted() {
		return isRetweeted;
	}
	public void setRetweeted(boolean isRetweeted) {
		this.isRetweeted = isRetweeted;
	}
	public GeoLocation getGeoLocation() {
		return geoLocation;
	}
	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public long getRetweetCount() {
		return retweetCount;
	}
	public void setRetweetCount(long retweetCount) {
		this.retweetCount = retweetCount;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public HashtagEntity[] getHashtagEntities() {
		return hashtagEntities;
	}
	public void setHashtagEntities(HashtagEntity[] hashtagEntities) {
		this.hashtagEntities = hashtagEntities;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
    
}
