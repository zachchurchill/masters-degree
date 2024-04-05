package com.zachurchill.lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

/**
 * The test class AudioRecordingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AudioRecordingTest {

    private AudioRecording tomorrow;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        this.tomorrow = new AudioRecording();
    }

    @Test
    public void testOverdueFeeCorrectlyOverriden() {
        assertEquals(new Dollar(0, 50), this.tomorrow.getOverdueFee());
    }

    @Test
    public void testGettersAndSettersHappyPath() {
        this.tomorrow.setCallNumber("TOMORROW");
        assertEquals("TOMORROW", this.tomorrow.getCallNumber());

        this.tomorrow.setCopyNumber(1);
        assertEquals(1, this.tomorrow.getCopyNumber());

        this.tomorrow.setTitle("Tomorrow - Best of Kodo");
        assertEquals("Tomorrow - Best of Kodo", this.tomorrow.getTitle());

        this.tomorrow.setDueDate(new GregorianCalendar(2024, 4, 9));
        assertEquals(new GregorianCalendar(2024, 4, 9), this.tomorrow.getDueDate());

        this.tomorrow.setBorrower("ZAC");
        assertEquals("ZAC", this.tomorrow.getBorrower());

        this.tomorrow.setArtist("Kodo");
        assertEquals("Kodo", this.tomorrow.getArtist());
    }

    @Test
    public void testArtistShouldBeNonEmptyString() {
        boolean emptyStringCaught = false;
        try {
            this.tomorrow.setArtist("");
        } catch(IllegalArgumentException e) {
            emptyStringCaught = true;
        }
        assertTrue(emptyStringCaught);

        boolean onlySpacesCaught = false;
        try {
            this.tomorrow.setArtist("     ");
        } catch(IllegalArgumentException e) {
            onlySpacesCaught = true;
        }
        assertTrue(onlySpacesCaught);

        boolean nullCaught = false;
        try {
            this.tomorrow.setArtist(null);
        } catch(IllegalArgumentException e) {
            nullCaught = true;
        }
        assertTrue(nullCaught);
    }
}
