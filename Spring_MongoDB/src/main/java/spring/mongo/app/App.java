package main.java.spring.mongo.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import main.java.spring.mongo.model.JJUser;

@SpringBootApplication
@ComponentScan(basePackages = { "main.java" })
@EnableMongoRepositories(basePackages = "com.jj.repository")
public class App implements CommandLineRunner {
	
	@Autowired
	MongoOperations mongoTemplate;
	
	@Autowired
	GridFsTemplate gridFsTemplate;
	
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
//		user.setCreateDate(new Date());
//		mongoTemplate.save(user);
//		JJUser user = mongoTemplate.findOne(new Query(Criteria.where("username").is("JJ")), JJUser.class);
//		JJUser user = mongoTemplate.findOne(new Query(Criteria.where("username").is("JJ").and("password").is("password")), JJUser.class);
//		mongoTemplate.findOne(new Query(Criteria.where("age").is(64)), JJUser.class);
//		List<JJUser> users = mongoTemplate.findAll(JJUser.class);
//		JJUser user1 = users.get(0);
//		user1.setUsername("JJ");
//		user1.setPassword("JJPassword");
//		mongoTemplate.save(user1);
//		for(JJUser userDetail : users){
//			mongoTemplate.remove(userDetail);
//		}
		
//		List<JJUser> users = new ArrayList<>();
//		for(int i =0; i<100; i++){
//			JJUser user = new JJUser("User"+i, "Password"+i, new Date());
//			users.add(user);
//		}
//		mongoTemplate.insert(users, JJUser.class);
		
//		List<JJUser> users = mongoTemplate.find(new Query(Criteria.where("username").regex("User.*")), JJUser.class);
//		for(JJUser user : users){
//			System.out.println(String.format("Username: %s, Date: %s", user.getUsername(), user.getCreateDate().toString()));
//		}
		
//		Query query = new Query();
//		query.addCriteria(Criteria.where("username").is("User1"));
//		query.fields().include("username");
//		JJUser user = mongoTemplate.findOne(query, JJUser.class);
//		System.out.println(user);
//		user.setPassword("jjPass");
//		mongoTemplate.save(user);
//		Query query1 = new Query();
//		query1.addCriteria(Criteria.where("username").is("User1"));
//		System.out.println(mongoTemplate.findOne(query1, JJUser.class));
		
		Query query = new Query();
		query.addCriteria(Criteria.where("username").regex("User.*")).with(new Sort(Sort.Direction.DESC, "username"));
		List<JJUser> user = mongoTemplate.find(query, JJUser.class);
//		Update update = new Update();
//		update.set("createDate", new Date());
//		mongoTemplate.upsert(query, update, JJUser.class);
		
		//Savefile
		DBObject metaData = new BasicDBObject();
		metaData.put("extra1", "anything 1");
		metaData.put("extra2", "anything 2");
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("C:\\MongoDB\\Files\\JJTestFile1.txt");
			gridFsTemplate.store(inputStream, "JJFile.txt", "txt", metaData);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//ReadFile
		List<GridFSDBFile> result = gridFsTemplate.find(
	               new Query().addCriteria(Criteria.where("filename").is("JJFile.txt")));

		for (GridFSDBFile file : result) {
			try {
				System.out.println(file.getFilename());
				System.out.println(file.getContentType());

				//save as another image
				file.writeTo("C:\\MongoDB\\Files\\JJTestFile2.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		System.out.println("works");
	}

}
