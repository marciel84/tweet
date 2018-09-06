package com.demo.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.twitter.*")
@EnableSwagger2
public class TwitterPoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterPoolApplication.class, args);
	}
}
