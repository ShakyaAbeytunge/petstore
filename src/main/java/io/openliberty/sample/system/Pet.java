package io.openliberty.sample.system;

public class Pet {

    int id;
    String petName;
    String petType;
    int petAge;

    public Pet() {
        super();
    }

    public Pet(int i, String name, String type, int age) {
        super();
        this.id = i;
        this.petName = name;
        this.petType = type;
        this.petAge = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String type) {
        this.petType = type;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int age) {
        this.petAge = age;
    }

}