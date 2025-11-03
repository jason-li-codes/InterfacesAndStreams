package com.pluralsight;

// implements Comparable interface for sorting
public class Person implements Comparable<Person> {

    // private fields
    private String firstName;
    private String lastName;
    private int age;

    // constructor
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    // Overridden compareTo method to compare Persons for sorting
    @Override
    public int compareTo(Person p) {
        // checks if last names are identical
        if (lastName.compareTo(p.lastName) == 0) {
            // checks if first names are identical
            if (firstName.compareTo(p.firstName) == 0) {
                // checks if ages are identical
                if (age == p.getAge()) {
                    return 0; // if all these are true, return a 0
                } else {
                    // otherwise, return 1 or -1, with the older Person getting priority
                    return (age > p.getAge()) ? 1 : -1;
                }
            } else { // if last names are identical but first names are not, compare first names
                return firstName.compareTo(p.firstName);
            }
        } else { // if last names are not identical, compare last names
            return lastName.compareTo(p.lastName);
        }
    }

}
