package com.mandii.newbackend.dao;

import com.mandii.newbackend.api.PersonAPI;
import com.mandii.newbackend.core.Person;
import com.mongodb.Block;
import com.mongodb.async.SingleResultCallback;
import com.mongodb.async.client.FindIterable;
import com.mongodb.async.client.MongoCollection;

import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operation support as of now Created by vinay on 29/12/15.
 */
public class PersonDAO {
    private final MongoCollection<Document> mongoCollection;

    public PersonDAO(MongoCollection<Document> mongoCollection) {
        this.mongoCollection = mongoCollection;
    }

    public List<PersonAPI> listPersons() {
        List<PersonAPI> persons = new ArrayList<>();
        FindIterable<Document> iterable = mongoCollection.find();
        iterable.forEach(new Block<Document>() {
                             @Override
                             public void apply(Document document) {
                                 try {
                                     Person person = new Person(document.getObjectId("_id"),document.getString("first"), document.getString("last"), document.getString("dob"),
                                             document.getString("gender"), document.getString("hair_color"), document.getString("occupation"), document.getString("nationality"));
                                     PersonAPI personAPI = new PersonAPI();
                                     personAPI.setFirst(person.getFirst());
                                     personAPI.setLast(person.getLast());
                                     personAPI.setGender(person.getGender());
                                     personAPI.setOccupation(person.getOccupation());
                                     persons.add(personAPI);

                                 }catch (Exception e) {
                                     e.printStackTrace();
                                 }
                             }
                         },
                new SingleResultCallback<Void>() {
                    @Override
                    public void onResult(Void aVoid, Throwable throwable) {
                        System.out.println("Operation Finished");
                    }
                });
        return persons;
    }


}
