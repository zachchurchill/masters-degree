package com.zachurchill.homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LegacyStudentToStudentAdapterTest {

    LegacyStudent legacyStudent;
    LegacyStudentToStudentAdapter adapter;

    @BeforeEach
    public void setUp() {
        this.legacyStudent = new LegacyStudent();
        this.legacyStudent.setId("1984");
        this.legacyStudent.setFullName("Winston Smith");
    }

    @Test
    public void testGetIdForIntegerStringsWorks() {
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        assertEquals(1984, this.adapter.getId());
    }

    @Test
    public void testGetIdForNonIntegerStringThrowsIllegalArgumentException() {
        this.legacyStudent.setId("1984Orwell");
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        assertThrows(IllegalArgumentException.class, () -> this.adapter.getId());
    }

    @Test
    public void testSetId() {
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        this.adapter.setId(2112);
        assertEquals("2112", this.legacyStudent.getId());
        assertEquals(2112, this.adapter.getId());
    }

    @Test
    public void testGetFirstName() {
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        assertEquals("Winston", this.adapter.getFirstName());
    }

    @Test
    public void testSetFirstName() {
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        this.adapter.setFirstName("George");
        assertEquals("George Smith", this.legacyStudent.getFullName());
        assertEquals("George", this.adapter.getFirstName());
    }

    @Test
    public void testGetLastName() {
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        assertEquals("Smith", this.adapter.getLastName());
    }

    @Test
    public void testLastName() {
        this.adapter = new LegacyStudentToStudentAdapter(this.legacyStudent);
        this.adapter.setLastName("Orwell");
        assertEquals("Winston Orwell", this.legacyStudent.getFullName());
        assertEquals("Orwell", this.adapter.getLastName());
    }
}
