package io.openliberty.sample.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class PetService {

    static HashMap<Integer, Pet> petIdMap = getPetIdMap();

    public PetService() {
        super();

        if (petIdMap == null) {
            petIdMap = new HashMap<Integer, Pet>();
            // Creating some objects of pet while initializing
            Pet pet1 = new Pet(1, "Boola", "Dog", 4);
            Pet pet2 = new Pet(2, "Bob", "Fish", 1);
            Pet pet3 = new Pet(3, "Peththappu", "Parrot", 3);
            Pet pet4 = new Pet(4, "Garfield", "Cat", 3);
            Pet pet5 = new Pet(5, "Lassy", "Dog", 10);
            Pet pet6 = new Pet(6, "Tom", "Cat", 5);

            petIdMap.put(1, pet1);
            petIdMap.put(2, pet2);
            petIdMap.put(3, pet3);
            petIdMap.put(4, pet4);
            petIdMap.put(5, pet5);
            petIdMap.put(6, pet6);
        }
    }

    public Set<String> getPetTypes() {
        List<String> petTypes = new ArrayList<String>();
        for (Pet petObj : petIdMap.values()) {
            petTypes.add(petObj.getPetType());
        }
        Set<String> uniqueTypes = new HashSet<String>(petTypes);
        return uniqueTypes;
    }

    public void deletePetType(String type) {
        for (Pet petObj : petIdMap.values()) {
            if (petObj.getPetType().equals(type)) {
                petIdMap.remove(petObj.getId());
            }
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<Pet>(petIdMap.values());
        return pets;
    }

    public Pet addPet(Pet pet) {
        petIdMap.put(pet.getId(), pet);
        return pet;
    }

    public Pet updatePet(Pet pet) {
        if (pet.getId() <= 0)
            return null;
        petIdMap.put(pet.getId(), pet);
        return pet;
    }

    public void deletePet(int id) {
        petIdMap.remove(id);
    }

    public Pet getPetById(int id) {
        Pet pet = petIdMap.get(id);
        return pet;
    }

    public List<Pet> getPetsByName(String name) {
        List<Pet> pets = new ArrayList<Pet>();
        for (Pet petObj : petIdMap.values()) {
            if (petObj.getPetName().equalsIgnoreCase(name)) {
                pets.add(petObj);
            }
        }
        return pets;
    }

    public List<Pet> getPetsByType(String type) {
        List<Pet> pets = new ArrayList<Pet>();
        for (Pet petObj : petIdMap.values()) {
            if (petObj.getPetType().equalsIgnoreCase(type)) {
                pets.add(petObj);
            }
        }
        return pets;
    }

    public List<Pet> getPetsByAge(int age) {
        List<Pet> pets = new ArrayList<Pet>();
        for (Pet petObj : petIdMap.values()) {
            if (petObj.getPetAge() == age) {
                pets.add(petObj);
            }
        }
        return pets;
    }

    public static HashMap<Integer, Pet> getPetIdMap() {
        return petIdMap;
    }
}