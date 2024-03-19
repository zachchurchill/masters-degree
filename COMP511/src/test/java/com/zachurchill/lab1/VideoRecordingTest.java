package com.zachurchill.lab1;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * The test class VideoRecordingTest.
 *
 * @author  Zach Churchill <church58@email.franklin.edu>
 * @version 2024-03-19
 */
public class VideoRecordingTest {
    /**
     * Tests default values of VideoRecording constructor using getters.
     */
    @Test
    void testVideoRecordingDefaultConstructor() {
        VideoRecording defaultVideoRecording = new VideoRecording();
        assertNull(defaultVideoRecording.getTitle());
        assertNull(defaultVideoRecording.getCallNumber());
        assertEquals(0, defaultVideoRecording.getCopyNumber());
        assertNull(defaultVideoRecording.getDueDate());
        assertNull(defaultVideoRecording.getBorrower());
    }

    /**
     * Tests adherence to MediaType interface of setters.
     */
    @Test
    void testVideoRecordingSetters() {
        VideoRecording lotr = new VideoRecording();
        lotr.setTitle("The Hobbit");
        assertEquals("The Hobbit", lotr.getTitle());

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
        VideoRecording lotr = new VideoRecording();

        GregorianCalendar dueDate = new GregorianCalendar(2024, 3, 19);
        lotr.setDueDate(dueDate);

        GregorianCalendar currentDate = new GregorianCalendar(2024, 3, 10);
        Dollar expectedLateFee = new Dollar(0);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 19);
        expectedLateFee = new Dollar(0);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 20);
        expectedLateFee = new Dollar(0, 50);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 29);
        expectedLateFee = new Dollar(5, 0);
        assertEquals(expectedLateFee, lotr.calculateFees(currentDate));
    }
    
}
