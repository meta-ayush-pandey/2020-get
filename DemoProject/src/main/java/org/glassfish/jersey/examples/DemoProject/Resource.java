package org.glassfish.jersey.examples.DemoProject;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("inventory")
public class Resource {

	InventoryRepository repo = new InventoryRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fruits> getInventory() {
		System.out.println("called");
		return repo.getFruits();
	}

	@POST
	@Path("itemname")
	public void createFruits(Fruits a1) {
		System.out.println(a1);
		repo.createFruits(a1);
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Fruits getFruit(@PathParam("name") String name) {
		System.out.println(name);
		return repo.getFruit(name);
	}

	@PUT
	@Path("itemname")
	public void updateFruit(Fruits a1) {
		if(repo.getFruit(a1.getName()).getName()==null) {
			System.out.println("Can't update");
		} else {
			repo.updateFruits(a1);
		}
	}

	@DELETE
	@Path("/{name}")
	public Fruits deleteFruit(@PathParam("name") String name) {
		Fruits a = repo.getFruit(name);
		repo.deleteFruits(name);
		return a;
	}

	@DELETE
	public void deleteAll() {
		repo.deleteAll();
	}
}
