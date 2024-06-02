package de.mvs.service.endpoints.v1;

import de.mvs.service.entities.Person;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @GET
    public List<Person> getAllPersons() {
        return Person.listAll();
    }

    @GET
    @Path("{id}")
    public Person getPerson(@PathParam("id") Long id) {
        return Person.findById(id);
    }

    @POST
    @Transactional
    public void addPerson(Person person) {
        person.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Person updatePerson(@PathParam("id") Long id, Person person) {
        Person entity = Person.findById(id);
        if (entity != null) {
            entity.setSalutation(person.getSalutation());
            entity.setFirstName(person.getFirstName());
            entity.setLastName(person.getLastName());
            entity.setCategory(person.getCategory());
            entity.setPhone(person.getPhone());
        }
        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deletePerson(@PathParam("id") Long id) {
        Person person = Person.findById(id);
        if (person != null) {
            person.delete();
        }
    }
}
