package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> myFriends = new ArrayList<>();
        myFriends.add(new Person("Jason", "Li", 92));
        myFriends.add(new Person("Alwin", "Zhao", 25));
        myFriends.add(new Person("Ahsan", "Baseer", 36));
        myFriends.add(new Person("Harman", "Sing", 50));
        myFriends.add(new Person("Jazzy", "Germ", 5));
        myFriends.add(new Person("Ashley", "Mendez", 21));
        myFriends.add(new Person("Andy", "Ariza", 20));
        myFriends.add(new Person("Denus", "Leon", 12));

        Collections.sort(myFriends);
        for (Person p : myFriends) {
            System.out.println(p.getFirstName() + " " + p.getLastName() + ", " + p.getAge());
        }
    }

}
