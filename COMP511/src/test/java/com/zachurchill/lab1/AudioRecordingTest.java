package com.zachurchill.lab1;

import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * The test class AudioRecordingTest.
 *
 * @author  Zach Churchill <church58@email.franklin.edu>
 * @version 2024-03-19
 */
public class AudioRecordingTest {

    /**
     * Tests default values of AudioRecording constructor using getters.
     */
    @Test
    void testAudioRecordingDefaultConstructor() {
        AudioRecording defaultRecording = new AudioRecording();
        assertNull(defaultRecording.getTitle());
        assertNull(defaultRecording.getArtist());
        assertNull(defaultRecording.getCallNumber());
        assertEquals(0, defaultRecording.getCopyNumber());
        assertNull(defaultRecording.getDueDate());
        assertNull(defaultRecording.getBorrower());
    }

    /**
     * Tests adherence to MediaType interface of setters.
     */
    @Test
    void testAudioRecordingSetters() {
        AudioRecording blizzard = new AudioRecording();
        blizzard.setTitle("Blizzard of Ozz");
        assertEquals("Blizzard of Ozz", blizzard.getTitle());

        blizzard.setArtist("Ozzy Osbourne");
        assertEquals("Ozzy Osbourne", blizzard.getArtist());

        blizzard.setCallNumber("blizzard-of-ozz");
        assertEquals("blizzard-of-ozz", blizzard.getCallNumber());

        blizzard.setCopyNumber(10);
        assertEquals(10, blizzard.getCopyNumber());

        GregorianCalendar dueDate = new GregorianCalendar(2024, 3, 19);
        blizzard.setDueDate(dueDate);
        assertEquals(dueDate, blizzard.getDueDate());

        blizzard.setBorrower("ZAC");
        assertEquals("ZAC", blizzard.getBorrower());
    }

    /**
     * Tests appropriate late charge is returned.
     */
    @Test
    void testLateCharges() {
        AudioRecording blizzard = new AudioRecording();

        GregorianCalendar dueDate = new GregorianCalendar(2024, 3, 19);
        blizzard.setDueDate(dueDate);

        GregorianCalendar currentDate = new GregorianCalendar(2024, 3, 10);
        Dollar expectedLateFee = new Dollar(0);
        assertEquals(expectedLateFee, blizzard.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 19);
        expectedLateFee = new Dollar(0);
        assertEquals(expectedLateFee, blizzard.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 20);
        expectedLateFee = new Dollar(0, 50);
        assertEquals(expectedLateFee, blizzard.calculateFees(currentDate));

        currentDate = new GregorianCalendar(2024, 3, 29);
        expectedLateFee = new Dollar(5, 0);
        assertEquals(expectedLateFee, blizzard.calculateFees(currentDate));
    }
}
