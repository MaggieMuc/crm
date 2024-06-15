package de.mvs.service.endpoints.v1;

import de.mvs.service.entities.Category;
import de.mvs.service.entities.Person;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @GET
    public List<Category> getAllCategories() {
        return Category.listAll();
    }

    @GET
    @Path("{id}")
    public Category getCategory(@PathParam("id") Long id) {
        return Category.findById(id);
    }

    @POST
    @Transactional
    public void addCategory(Category category) {
         category.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Category updateCategory(@PathParam("id") Long id, Category category) {
        Category entity = Category.findById(id);
        if (entity != null) {
            entity.setName(category.getName());
        }
        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteCategory(@PathParam("id") Long id) {
        Category category = Category.findById(id);
        if (category != null) {
            category.delete();
        }
    }
}
