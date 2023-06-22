package com.tiktok.demo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

@Document(collection = "data")
public class Data {

    @Id
    private String id;
    private String title;
    private String content;

    public Data() {
    }

    public Data(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters and Setters

    public static List<Data> getDataList(MongoTemplate mongoTemplate) {
        Query query = new Query();
        return mongoTemplate.find(query, Data.class);
    }
}
