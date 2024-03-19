package com.zachurchill.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;
/**
 * The test class BookTest.
 *
 * @author  Zach Churchill <church58@email.franklin.edu>
 * @version 2024-03-19
 */
public class BookTest {

    /**
     * Tests default values of Book constructor using getters.
     */
    @Test
    void testBookDefaultConstructor() {
        Book defaultBook = new Book();
        assertNull(defaultBook.getTitle());
        assertNull(defaultBook.getAuthor());
        assertNull(defaultBook.getCallNumber());
        assertEquals(0, defaultBook.getCopyNumber());
        assertNull(defaultBook.getDueDate());
        assertNull(defaultBook.getBorrower());
    }

    /**
     * Tests adherence to MediaType interface of setters.
     */
    @Test
    void testBookSetters() {
        Book lotr = new Book();
        lotr.setTitle("The Hobbit");
        assertEquals("The Hobbit", lotr.getTitle());

        lotr.setAuthor("Tolkien the Younger");
        assertEquals("Tolkien the Younger", lotr.getAuthor());

        lotr.setCallNumber("LOTR2.0");
        assertEquals("LOTR2.0", lotr.getCallNumber());

        lotr.setCopyNumber(10);
        assertEquals(10, lotr.getCopyNumber());

        GregorianCalendar dueDate = new GregorianCalendar(2024, 3, 19);
        lotr.setDueDate(dueDate);
        assertEquals(dueDate, lotr.getDueDate());

        lotr.setBorrower("ZAC");
        assertEquals("ZAC", lotr.getBorrower());
    }

    /**
     * Tests appropriate late charge is returned.
     */
    @Test
    void testLateCharges() {
        Book lotr = new Book();

        GregorianCalendar dueDate = new GregorianCalendar(2024, 3, 19);
        lotr.setDueDate(dueDate);

        GregorianCalendar currentDate = new GregorianCalendar(2024, 3, 10);
        Dollar expectedLateFee = new Dollar(0);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 19);
        expectedLateFee = new Dollar(0);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 20);
        expectedLateFee = new Dollar(0, 25);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 29);
        expectedLateFee = new Dollar(2, 50);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));
    }
}
