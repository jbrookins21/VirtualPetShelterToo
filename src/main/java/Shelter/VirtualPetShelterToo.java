package Shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelterToo {
    Map<String, VirtualPet> pets = new HashMap<>();

    public void add(VirtualPet petToAdd) {
        pets.put(petToAdd.getPetId(), petToAdd);
    }

    public void removePet(VirtualPet petToRemove) {
        pets.remove(petToRemove.getPetId(), petToRemove);
    }

    public VirtualPet findPet(String petId) {
        return pets.get(petId);
    }

    public Collection<VirtualPet> getAllPets() {
        return pets.values();

    }

    public static void tick() {
        int hunger = 2;
        int thirst = 2;
        int boredom = 2;
        int rest = 2;
        int potty = 2;
    }

    public void feedShelter(int food){
        for (VirtualPet allPets : pets.values()) {
            allPets.feed(food);
        }
    }

    public void hydrateShelter ( int water){
        for (VirtualPet allPets : pets.values()) {
            allPets.hydrate(water);
        }

    }


}
