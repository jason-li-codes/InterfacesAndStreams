package com.pluralsight;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

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

    @Override
    public int compareTo(Person p) {

        if (lastName.compareTo(p.lastName) == 0) {
            if (firstName.compareTo(p.firstName) == 0) {
                if (age == p.getAge()) {
                    return 0;
                } else {
                    return (age > p.getAge()) ? 1 : -1;
                }
            } else {
                return firstName.compareTo(p.firstName);
            }
        } else {
            return lastName.compareTo(p.lastName);
        }
    }

}
