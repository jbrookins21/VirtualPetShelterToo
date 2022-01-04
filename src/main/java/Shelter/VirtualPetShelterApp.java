package Shelter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VirtualPetShelterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        VirtualPet pet1 = new VirtualPet("1", "Jacob", "Tall and kinda dumb");
        VirtualPet pet2 = new VirtualPet("2", "Tammy", "Sings and works hard");
        VirtualPet pet3 = new VirtualPet("3", "Joseph", "Bright and colorful");
        VirtualPet pet4 = new VirtualPet("4", "Maurice", "Short with a lazy eye");
        VirtualPet pet5 = new VirtualPet("5", "Fatimah", "Loves to eat");


        VirtualPetShelterToo petsInShelter = new VirtualPetShelterToo();


        petsInShelter.add(pet1);
        petsInShelter.add(pet2);
        petsInShelter.add(pet3);
        petsInShelter.add(pet4);
        petsInShelter.add(pet5);

        System.out.println("Welcome to DinoCare Shelter!");
        System.out.println("Press enter to wake everyone up: ");
        System.out.println("               __           ");
        System.out.println("              / _)          ");
        System.out.println("     _.----._/ /            ");
        System.out.println("    /         /             ");
        System.out.println(" __/ (  | (  |              ");
        System.out.println("/__.-'|_|--|_|              ");
        System.out.println("≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈≈");



        System.out.println("Please select from the menu below");
        System.out.println("Press 1 to check hunger, thirst, and boredom");
        System.out.println("Press 2 to hydrate");
        System.out.println("Press 3 to feed");
        System.out.println("Press 4 to play");
        System.out.println("Press 5 to exit");
        String userSelection = input.nextLine();

        while (!userSelection.equals("5")) {
            switch (userSelection) {
                case "1":
                    System.out.println("Who would you like to check on");
                    String petSelection = input.nextLine();
                    petsInShelter.findPet(petSelection);
                    System.out.println("Checking hunger, thrist, and boredom");
                    System.out.println(petsInShelter.findPet(petSelection).getName() + "'s status is: " +
                            "\n hunger: " + petsInShelter.findPet(petSelection).getHunger() +
                            "\n thirst: " + petsInShelter.findPet(petSelection).getThirst() +
                            "\n boredom: " + petsInShelter.findPet(petSelection).getBoredom());
                    break;


                case "2":
                    System.out.println("Who would you like to hydrate");
                    petSelection = input.nextLine();
                    System.out.println("Let's get " + petsInShelter.findPet(petSelection).getName() + " some water.");
                    System.out.println("How much do you want to give them?");
                    int water = input.nextInt();
                    petsInShelter.findPet(petSelection).hydrate(water);
                    System.out.println(petsInShelter.findPet(petSelection).getName() + " is happy and hydrated! Thirst is now at " + petsInShelter.findPet(petSelection).getThirst());
                    VirtualPetShelterToo.tick();
                    input.nextLine();
                    break;

                case "3":
                    System.out.println("Who would you like to feed?");
                    petSelection = input.nextLine();
                    System.out.println("You want to feed " + petsInShelter.findPet(petSelection).getName() + "?");
                    System.out.println("How many snacks? ");
                    int snacks = input.nextInt();
                    petsInShelter.findPet(petSelection).feed(snacks);
                    System.out.println(petsInShelter.findPet(petSelection).getName() + "'s belly is happy! Hunger is now at " + petsInShelter.findPet(petSelection).getHunger());
                    petsInShelter.findPet(petSelection).tick();
                    input.nextLine();
                    break;

                case "4":
                    petSelection = input.nextLine();
                    System.out.println("You want to play with " + petsInShelter.findPet(petSelection).getName() + "?");
                    System.out.println("How many toys are you using? ");
                    int numberOfToys = input.nextInt();
                    petsInShelter.findPet(petSelection).play(numberOfToys);
                    System.out.println(petsInShelter.findPet(petSelection).getName() + " is happy! Boredom is now at " + petsInShelter.findPet(petSelection).getBoredom());
                    VirtualPetShelterToo.tick();
                    input.nextLine();
                    break;

                case "6":
                    //add pet to shelter
                    onboardPet(input, petsInShelter);
                    input.nextLine();
                    break;

                case "7":
                    //list all pets
                    showPets(petsInShelter);
                    input.nextLine();
                    break;

                case "8":
                    //a pet gets adopted and is removed from shelter
                    adoptPet(input, petsInShelter);
                    input.nextLine();
                    break;



                default:
                    System.out.println("You cannot perform that action at this time");
                    input.nextLine();
                    break;
            }
            System.out.println("Please select from the menu below");
            System.out.println("Press 1 to check hunger, thirst, and boredom");
            System.out.println("Press 2 to hydrate");
            System.out.println("Press 3 to feed");
            System.out.println("Press 4 to play");
            System.out.println("Press 5 to exit");
            userSelection = input.nextLine();
        }
        String petSelection = input.nextLine();
        System.out.println(petsInShelter.findPet(petSelection).getName() + " say's thank you for playing. See you soon! Bye!");


        Map<String, VirtualPet> pets = new HashMap<>();


        }


    public static void showPets(VirtualPetShelterToo virtualPetShelter) {
        for (VirtualPet entry : virtualPetShelter.getAllPets()) {
            VirtualPet pet = entry;
            System.out.println(pet.getName() + " : " + pet.getDescription());

        }
    }

    public static void onboardPet(Scanner input, VirtualPetShelterToo petsInShelter) {
        System.out.println("What's the Pet's Name?");
        String name = input.nextLine();
        System.out.println("What's it like?");
        String description = input.nextLine();
        System.out.println("Thank you for your submission " + " we will be sure to take good care of " + name);
        VirtualPet newVirtualPet = new VirtualPet("6", name, description);
        petsInShelter.add(newVirtualPet);
    }

    public static void adoptPet(Scanner input, VirtualPetShelterToo virtualPetShelter) {
        System.out.println("What's the Pet's Id?");
        String petId = input.nextLine();
        VirtualPetShelterToo.removePet(petId);
        System.out.println("You Adopted " + virtualPetShelter.findPet(petId).getName());
    }
}