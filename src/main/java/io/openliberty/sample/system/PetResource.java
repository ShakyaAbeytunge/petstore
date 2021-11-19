package io.openliberty.sample.system;

import java.util.List;
import java.util.Set;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pets")
public class PetResource {

	PetService petService = new PetService();

	// show pet-types available at the store
	@GET
	@Path("/types")
	@Produces(MediaType.APPLICATION_JSON)
	public Set<String> getPetTypes() {
		return petService.getPetTypes();
	}

	// delete the given pet-type along with the pets of that type
	@DELETE
	@Path("/deleteType/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePetType(@PathParam("type") String type) {
		petService.deletePetType(type);
	}

	// show all pets available at the store
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> getPets() {
		List<Pet> listOfPets = petService.getAllPets();
		return listOfPets;
	}

	// add a new pet to the store
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Pet addPet(Pet pet) {
		return petService.addPet(pet);
	}

	// edit pet details
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Pet updatePet(Pet pet) {
		return petService.updatePet(pet);
	}

	// remove a pet from the store by id
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletePet(@PathParam("id") int id) {
		petService.deletePet(id);
	}

	// search a pet by id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pet getPetById(@PathParam("id") int id) {
		return petService.getPetById(id);
	}

	// search pets by name
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> getPetsByName(@PathParam("name") String name) {
		return petService.getPetsByName(name);
	}

	// search pets by type
	@GET
	@Path("/type/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> getPetsByType(@PathParam("type") String type) {
		return petService.getPetsByType(type);
	}

	// search pets by age
	@GET
	@Path("/age/{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pet> getPetsByAge(@PathParam("age") int age) {
		return petService.getPetsByAge(age);
	}
}
