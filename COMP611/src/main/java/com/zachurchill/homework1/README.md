# Homework 1

## Adapter Pattern

Implement LegacyStudentToStudentAdapter,
which makes an object that implements ILegacyStudent look like it implements IStudent.
Make sure you don't make any assumptions about the order in which its methods will be called.

## Sets

If we insert JDK classes into a HashSet, then the Set will not accept duplicates:

```java
HashSet<String> set = new HashSet<>();
set.add("Hi"); // returns true
set.add("Hi"); // returns false
set.size(); // returns 1
```

If we try the same thing with a class we created, we don’t see the same results:

```java
public class Student {
      private String firstName;
        private String lastName;
          // constructor and accessors omitted
}

HashSet<Student> set = new HashSet<>();
set.add(new Student("John", "Doe"));  // returns true
set.add(new Student("John", "Doe"));  // returns true
set.size(); // returns 2
```

Fix the Student class so that it works correctly with HashSet.
Hint: Look into the contract for hashCode().
