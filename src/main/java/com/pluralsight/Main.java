package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // List of Persons initialized as ArrayList
        List<Person> myFriends = new ArrayList<>();
        // manually add Persons to ArrayList
        myFriends.add(new Person("Jason", "Li", 92));
        myFriends.add(new Person("Alwin", "Zhao", 25));
        myFriends.add(new Person("Ahsan", "Baseer", 36));
        myFriends.add(new Person("Harman", "Sing", 50));
        myFriends.add(new Person("Jazzy", "Germ", 5));
        myFriends.add(new Person("Ashley", "Mendez", 21));
        myFriends.add(new Person("Andy", "Ariza", 20));
        myFriends.add(new Person("Denus", "Leon", 12));
        myFriends.add(new Person("Tamir", "Dmitriev", 19));
        myFriends.add(new Person("Roger", "Su", 12));

        // now that compareTo has been implemented in the class, Collections.sort() should work properly
        Collections.sort(myFriends);
        // after sorting, prints out each person's name and age to verify
        for (Person p : myFriends) {
            System.out.println(p.getFirstName() + " " + p.getLastName() + ", " + p.getAge());
        }

        // outdated method
        // traditionalLoopsMethod(myFriends);
        streamFilterMethod(myFriends);
    }

    // uses stream filters
    public static void streamFilterMethod(List<Person> myFriends) {

        System.out.println("Who are you searching for? Enter first or last name.");
        String userSearch = getValidString().toLowerCase();
        System.out.println("Here are people matching your search: ");

        myFriends.stream()
                .filter(p -> p.getFirstName().toLowerCase().contains(userSearch) ||
                        p.getLastName().toLowerCase().contains(userSearch))
                .forEach(p -> System.out.println(p.getFirstName() + " " + p.getLastName() + ", " + p.getAge()));

        int ageTotal = myFriends.stream()
                .map(Person::getAge)
                .reduce(0, (sum, age) -> sum + age);
        int numOfFriends = myFriends.size();
        System.out.printf("Average age of group: %d\n", ageTotal / numOfFriends);

        int ageMin = myFriends.stream()
                .map(Person::getAge)
                .reduce(Integer.MAX_VALUE, (ageSmaller, age) -> (ageSmaller > age) ? age : ageSmaller);
        System.out.printf("The youngest person in the group is %d years old.\n", ageMin);

        int ageMax = myFriends.stream()
                .map(Person::getAge)
                .reduce(0, (ageBigger, age) -> (ageBigger < age) ? age : ageBigger);
        System.out.printf("The oldest person in the group is %d years old.\n", ageMax);

    }

    // uses traditional for loops
    public static void traditionalLoopsMethod(List<Person> myFriends) {

        System.out.println("Who are you searching for? Enter first or last name.");
        String userSearch = getValidString().toLowerCase();
        System.out.println("Here are people matching your search: ");
        for (Person p: myFriends) {
            if (p.getFirstName().toLowerCase().contains(userSearch) ||
            p.getLastName().toLowerCase().contains(userSearch)) {
                System.out.println(p.getFirstName() + " " + p.getLastName() + ", " + p.getAge());
            }
        }
        System.out.println("Search complete.");

        int counter = 0;
        int ageTotal = 0;
        for (Person p : myFriends) {
            counter++;
            ageTotal += p.getAge();
        }
        System.out.printf("Average age of group: %d\n", ageTotal / counter);

        int ageMin = Integer.MAX_VALUE;
        int ageMax = 0;
        for (Person p : myFriends) {
            if (p.getAge() < ageMin) {
                ageMin = p.getAge();
            }
            if (p.getAge() > ageMax) {
                ageMax = p.getAge();
            }
        }

        System.out.printf("The youngest person in the group is %d years old.\n", ageMin);
        System.out.printf("The oldest person in the group is %d years old.\n", ageMax);
    }

    public static String getValidString() {
        // Initializes String called string, set to null
        String string;
        // Uses do/while loop with a boolean badInput to get a non-empty String from user
        boolean badInput = false;
        do {
            // Sets badInput to false first, to ensure loop doesn't run continuously
            badInput = false;
            string = input.nextLine().trim(); // Accepts next user input as a String, trimming it
            if (string.isEmpty()) {
                System.out.println("You have not entered anything, please try again.");
                badInput = true; // Sets badInput to true if input is empty after trimming
            }
        } while (badInput);
        return string; // Returns string after input is confirmed to be non-empty
    }

}