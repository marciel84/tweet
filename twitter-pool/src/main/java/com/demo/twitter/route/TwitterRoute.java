package com.demo.twitter.route
;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.demo.twitter.process.SaveProcess;

@Component
public class TwitterRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		from("twitter://timeline/home?type=polling&delay=900000&consumerKey=qN6QbsJlr1KR4iYXn3wqFK12Q&consumerSecret=fofwtdhaBHTD8usmhH8wI4ZM3q97lSiwlptLf7ViCvaungSV19&accessToken=21710756-2nDJV6GdTVQffjv0gGZCTGaw82Jz3o1lWBphlSIoy&accessTokenSecret=lABGwiD3jfoZgI5z5yKxMTcGP3DlkExDfPq622FBFnPcg")
			.bean(SaveProcess.class)
			.to("stream:out")
		.end();
	}
	
	

}
