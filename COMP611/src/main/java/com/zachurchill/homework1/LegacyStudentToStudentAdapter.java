package com.zachurchill.homework1;

public class LegacyStudentToStudentAdapter implements IStudent {

    private ILegacyStudent legacyStudent;

    public LegacyStudentToStudentAdapter(ILegacyStudent student) {
        this.legacyStudent = student;
    }

    public int getId() {
        int id;
        try {
            id = Integer.parseInt(this.legacyStudent.getId());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Legacy Student ID must be updated to be integer string");
        }
        return id;
    }

    public void setId(int id) {
        this.legacyStudent.setId(String.valueOf(id));
    }

    public String getFirstName() {
        String[] firstLast = this.legacyStudent.getFullName().split(" ");
        return firstLast[0];
    }

    public void setFirstName(String firstName) {
        String[] firstLast = this.legacyStudent.getFullName().split(" ");
        this.legacyStudent.setFullName(String.format("%s %s", firstName, firstLast[1]));
    }

    public String getLastName() {
        String[] firstLast = this.legacyStudent.getFullName().split(" ");
        return firstLast[1];
    }

    public void setLastName(String lastName) {
        String[] firstLast = this.legacyStudent.getFullName().split(" ");
        this.legacyStudent.setFullName(String.format("%s %s", firstLast[0], lastName));
    }

    public static void main(String[] args) {
        System.out.println("Test the adapter here");
    }
}
