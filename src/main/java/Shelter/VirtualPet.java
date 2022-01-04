package Shelter;

public class VirtualPet {
    private String petId;
    private String name;
    private String description;
    private int hunger;
    private int thirst;
    private int boredom;
    private int rest;
    private int potty;

    public VirtualPet(String petId, String name, String description) {
        this.description = description;
        this.name = name;
        this.petId = petId;
        this.hunger = 10;
        this.thirst = 10;
        this.boredom = 10;
        this.rest = 10;
        this.potty = 10;
    }

    //Getters
    public String getPetId() {
        return petId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBoredom() {
        return boredom;
    }

    public int getRest() {
        return rest;
    }

    public int getPotty() {
        return potty;
    }

    //behavioral methods
    public void feed(int food) {
        hunger += food;
    }

    public void hydrate(int water) {
        thirst += water;
    }

    public void play(int toys) {
        boredom += toys;
    }

    public void nap(int sleep) {
        rest += sleep;
    }

    public void bathrooom(int poop) {
        potty += poop;
    }

    //stats check & update
    public boolean getAliveStatus() {
        if (hunger > 0 || thirst > 0 || boredom > 0 || potty > 0) {
            return true;
        }
        return false;
    }

    public void tick() {
        hunger -= 2;
        thirst -= 2;
        boredom -= 2;
        rest -= 2;
        potty -= 2;
    }

}
