package main.java.spring.mongo.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "JJTST1";
	}

	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		Mongo ret = new MongoClient(new ServerAddress("127.0.0.1", 27017),
				Arrays.asList(MongoCredential.createCredential("admin", "admin", "admin".toCharArray())));
		return ret;
	}

}
