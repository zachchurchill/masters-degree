package com.zachurchill.homework1;

import java.util.HashSet;

public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public int hashCode() {
        return this.firstName.hashCode() + this.lastName.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) {
            throw new IllegalArgumentException("expecting another Student object");
        }
        return this.hashCode() == other.hashCode();
    }

    public static void main(String [] args) {
        System.out.println("Constructing set using String...");
        HashSet<String> stringSet = new HashSet<>();
        System.out.println(stringSet.add("Hi"));
        System.out.println(stringSet.add("Hi"));
        System.out.println(stringSet.size());

        System.out.println("Constructing set using Student...");
        HashSet<Student> studentSet = new HashSet<>();
        System.out.println(studentSet.add(new Student("John", "Doe")));
        System.out.println(studentSet.add(new Student("John", "Doe")));
        System.out.println(studentSet.size());
    }
}

