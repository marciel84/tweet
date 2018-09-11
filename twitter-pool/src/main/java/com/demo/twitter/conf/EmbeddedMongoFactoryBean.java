package com.demo.twitter.conf;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

public class EmbeddedMongoFactoryBean implements FactoryBean<Mongo>, DisposableBean {
	private static final Logger LOG = LoggerFactory.getLogger(EmbeddedMongoFactoryBean.class);
	private final EmbeddedMongoBuilder builder = new EmbeddedMongoBuilder();
	private MongoClient mongoClient;

	public MongoClient getObject() throws IOException {
		mongoClient = builder.build();
		return mongoClient;
	}

	public Class<MongoClient> getObjectType() {
		return MongoClient.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void destroy() {
		if (mongoClient != null) {
			LOG.info("Stopping embedded MongoDB instance");
			mongoClient.close();
		}
	}

	public void setVersion(String version) {
		builder.version(version);
	}

	public void setPort(int port) {
		builder.port(port);
	}

	public void setBindIp(String bindIp) {
		builder.bindIp(bindIp);
	}
}