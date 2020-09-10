package com.demo.twitter.route
;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.demo.twitter.process.SaveProcess;

@Component
public class TwitterRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("twitter://timeline/home?type=polling&delay=900000&consumerKey={{consumer_key}}&accessToken={{access_token}}&accessTokenSecret={{secret}}")
			.bean(SaveProcess.class)
			.to("stream:out")
		.end();
	}
	
	

}
