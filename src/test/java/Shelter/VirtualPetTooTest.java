package Shelter;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VirtualPetTooTest {

    VirtualPetShelterToo underTest;
    VirtualPet pet1;
    VirtualPet pet2;

    @BeforeEach
    public void setUp(){
        underTest = new VirtualPetShelterToo();
        pet1 = new VirtualPet("1","Jamie", "energetic");
        pet2 = new VirtualPet("2","Doug", "high");
    }

    @Test
    public void shouldBeAbleToAddPet(){
        underTest = new VirtualPetShelterToo();
        underTest.add(pet1);
        VirtualPet retrievedPet = underTest.findPet("1");
        assertEquals(pet1, retrievedPet);
    }

    @Test
    public void shouldBeAbleToAddTwoPets(){
        underTest.add(pet1);
        underTest.add(pet2);
        Collection<VirtualPet> allPetsInShelter = underTest.getAllPets();
        assertEquals(2, allPetsInShelter.size());
        assertThat(allPetsInShelter, containsInAnyOrder(pet1,pet2));
    }

    @Test
    public void shouldRemoveAPetFromShelter(){
        underTest.add(pet2);
        underTest.removePet(pet2);
        VirtualPet retrievedPet = underTest.findPet("2");
        assertEquals(retrievedPet, null);
    }

    @Test
    public void shouldFeedAllPetsInShelter(){


    }


}
