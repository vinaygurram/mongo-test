package com.mandii.newbackend.resources;

import com.codahale.metrics.annotation.Timed;
import com.mandii.newbackend.api.PersonAPI;
import com.mandii.newbackend.dao.PersonDAO;
import com.mandii.newbackend.protos.PersonProtos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.dropwizard.jersey.protobuf.ProtocolBufferMediaType;

/**
 * PersonAPI DAO
 * Created by vinay on 29/12/15.
 */
@Path("/pesron")
@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonDAO personDAO;

    public PersonResource(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GET@Timed@Path("/list")
    public List<PersonAPI> getPersons() {
        return personDAO.listPersons();
    }

    @GET@Timed@Path("/list/protobuf")@Produces(ProtocolBufferMediaType.APPLICATION_PROTOBUF)
    public PersonProtos.PersonList getProtoPersons() {
        PersonProtos.PersonList.Builder personListBuilder =  personDAO.listPersonsWithProto();
        System.out.println(personListBuilder);
        PersonProtos.PersonList personList = personListBuilder.build();
        return personList;
    }
}
