package com.mandii.newbackend.db;

import com.mongodb.async.client.MongoClient;

import io.dropwizard.lifecycle.Managed;

/**
 * Managing mongo client life cycle
 * Created by vinay on 29/12/15.
 */
public class MongoManaged implements Managed {
    private MongoClient mongoClient;

    public MongoManaged(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @Override
    public void start() throws Exception {

    }

    @Override
    public void stop() throws Exception {
        mongoClient.close();
    }
}
