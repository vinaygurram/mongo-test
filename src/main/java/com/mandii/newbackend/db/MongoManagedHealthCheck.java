package com.mandii.newbackend.db;


import com.codahale.metrics.health.HealthCheck;
import com.mongodb.async.client.MongoClient;

/**
 * Created by vinay on 29/12/15.
 */
public class MongoManagedHealthCheck extends HealthCheck {

    private final MongoClient mongoClient;

    public MongoManagedHealthCheck(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    protected Result check() throws Exception {
        mongoClient.listDatabases();
        return Result.healthy("MongoDB is running");
    }
}
