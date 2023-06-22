package com.tiktok.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import com.tiktok.demo.MongoClientDbFactory;
import java.util.List;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class DemoApplication {

	MongoClientDbFactory dbFactory = new MongoClientDbFactory();

	@Autowired
	private MongoTemplate mongoTemplate = dbFactory.mongoTemplate();

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}

	@GetMapping("/v1/posts")
	public List<Data> getPosts() {
		return Data.getDataList(mongoTemplate);
	}

	@GetMapping("/v2/posts")
	public List<Videos> getVideos() {
		return Videos.getAllVideos(mongoTemplate);
	}

	@PostMapping("/v2/posts")
	public Videos createVideo(@RequestBody Videos video) {
		return Videos.createVideo(video, mongoTemplate);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}