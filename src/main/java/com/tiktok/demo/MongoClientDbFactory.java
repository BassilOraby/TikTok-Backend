package com.tiktok.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@SpringBootApplication
public class MongoClientDbFactory {

    private static final String MONGODB_URI = "mongodb+srv://BassilOraby:vFF74EhiyJ&r%23%2F4@cluster0.j9atw.mongodb.net/tutorialDB?retryWrites=true&w=majority";

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(new SimpleMongoClientDatabaseFactory(MONGODB_URI));
    }
}

