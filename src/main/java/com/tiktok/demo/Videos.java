package com.tiktok.demo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@Document(collection = "videos")
public class Videos {

    @Id
    private String id;
    private String title;
    private String url;

    public Videos() {
    }

    public Videos(String id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }

    // Getters and Setters

    public static List<Videos> getAllVideos(MongoTemplate mongoTemplate) {
        Query query = new Query();
        return mongoTemplate.find(query, Videos.class);
    }

    public static Videos createVideo(Videos video, MongoTemplate mongoTemplate) {
        return mongoTemplate.insert(video);
    }
}

