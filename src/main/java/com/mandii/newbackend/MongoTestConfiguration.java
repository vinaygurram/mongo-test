package com.mandii.newbackend;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.connection.ServerSettings;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.dropwizard.Configuration;

/**
 * Mongo configurations are defined here
 * Created by vinay on 29/12/15.
 */
public class MongoTestConfiguration extends Configuration {

    @JsonProperty @NotEmpty
    private String defaultMongoHost = "localhost";

    @JsonProperty @Min(1) @Max(65535)
    private int defaultPort = 27017;

    @JsonProperty @NotEmpty
    private String defaultMongoDB = "mydb";


    @JsonProperty
    public String getDefaultMongoHost() {
        return defaultMongoHost;
    }


    @JsonProperty
    public void setDefaultMongoHost(String defaultMongoHost) {
        this.defaultMongoHost = defaultMongoHost;
    }

    @JsonProperty
    public int getDefaultPort() {
        return defaultPort;
    }

    @JsonProperty
    public void setDefaultPort(int defaultPort) {
        this.defaultPort = defaultPort;
    }

    @JsonProperty
    public String getDefaultMongoDB() {
        return defaultMongoDB;
    }

    @JsonProperty
    public void setDefaultMongoDB(String defaultMongoDB) {
        this.defaultMongoDB = defaultMongoDB;
    }
}
