package com.demo.twitter.process;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.twitter.model.Twitter;
import com.demo.twitter.repo.TwitterRepository;

import twitter4j.Status;

@Component
public class SaveProcess {

	private static final Logger LOGGER = LoggerFactory.getLogger(SaveProcess.class);
	
	@Autowired
    private TwitterRepository repository;

	public void process(Exchange exchange) throws Exception {
		
		LOGGER.debug("process - INICIO");
		
		Status status = (Status) exchange.getIn().getBody();
		
		repository.save(builder(status));
		
		LOGGER.debug("process - FIM");
		
	}
	
	private Twitter builder(Status status) {
		
		Twitter twitter = new Twitter();
		
		twitter.setCreatedAt(status.getCreatedAt());
		twitter.setGeoLocation(status.getGeoLocation());
		twitter.setHashtagEntities(status.getHashtagEntities());
		twitter.setLang(status.getLang());
		twitter.setPlace(status.getPlace());
		twitter.setRetweetCount(status.getCurrentUserRetweetId());
		twitter.setRetweeted(status.isRetweeted());
		twitter.setSource(status.getSource());
		twitter.setText(status.getText());
		twitter.setUser(status.getUser());
		
		return twitter;
		
	}
	
}
