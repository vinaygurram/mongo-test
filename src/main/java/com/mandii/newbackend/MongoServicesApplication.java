package com.mandii.newbackend;


import com.mandii.newbackend.dao.PersonDAO;
import com.mandii.newbackend.db.MongoManaged;
import com.mandii.newbackend.db.MongoManagedHealthCheck;
import com.mandii.newbackend.resources.PersonResource;
import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClient;
import com.mongodb.async.client.MongoClients;
import com.mongodb.async.client.MongoDatabase;

import io.dropwizard.Application;
import io.dropwizard.jersey.protobuf.InvalidProtocolBufferExceptionMapper;
import io.dropwizard.jersey.protobuf.ProtocolBufferMessageBodyProvider;
import io.dropwizard.setup.Environment;

/**
 * Mongo Services initializer
 * Created by vinay on 29/12/15.
 */
public class MongoServicesApplication extends Application<MongoTestConfiguration> {
    public static void main(String[] args) throws Exception {
        new MongoServicesApplication().run(args);
    }
    @Override
    public void run(MongoTestConfiguration mongoTestConfiguration, Environment environment) throws Exception {

        //create connection
        MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://"+mongoTestConfiguration.getDefaultMongoHost()+":"+
        mongoTestConfiguration.getDefaultPort()));

        //mongo dbs and daos
        final MongoDatabase persons = mongoClient.getDatabase("test");
        final PersonDAO personDAO = new PersonDAO(persons.getCollection("nettuts"));

        //register protobuf
        environment.jersey().register(new ProtocolBufferMessageBodyProvider());
        environment.jersey().register(new InvalidProtocolBufferExceptionMapper());


        MongoManaged mongoManaged = new MongoManaged(mongoClient);
        environment.lifecycle().manage(mongoManaged);
        environment.healthChecks().register("Mongo Health Check",new MongoManagedHealthCheck(mongoClient));
        environment.jersey().register(new PersonResource(personDAO));

    }
}
