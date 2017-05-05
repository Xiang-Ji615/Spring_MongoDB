package main.java.spring.mongo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import main.java.spring.mongo.model.JJUser;

@SpringBootApplication
@ComponentScan(basePackages = { "main.java" })
@EnableMongoRepositories(basePackages = "com.jj.repository")
public class App implements CommandLineRunner {
	
	@Autowired
	MongoOperations mongoTemplate;
	
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(App.class);
		app.run(args);
	}

	// Put your logic here.
	@Override
	public void run(String... args) throws Exception {
		
		JJUser user = new JJUser();
		user.setUsername("JJ123"); 
		user.setPassword("password123");
		mongoTemplate.save(user);
		List<JJUser> users = mongoTemplate.findAll(JJUser.class);
		for(JJUser userDetail : users){
			mongoTemplate.remove(userDetail);
		}
		System.out.println("works");
	}

}
