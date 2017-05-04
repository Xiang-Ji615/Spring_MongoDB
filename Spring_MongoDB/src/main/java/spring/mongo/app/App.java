package main.java.spring.mongo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import main.java.spring.mongo.model.JJUser;

@SpringBootApplication
@ComponentScan(basePackages = { "main.java" })
@ImportResource(locations={"classpath:SpringMongo.xml"})
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
//		JJUser user = new JJUser();
//		user.setUsername("JJ"); 
//		user.setPassword("password");
//		mongoTemplate.save(user);
		System.out.println(mongoTemplate.findAll(JJUser.class));
		System.out.println("works");
	}

}
