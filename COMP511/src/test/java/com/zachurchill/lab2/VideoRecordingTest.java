package com.zachurchill.lab2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

/**
 * The test class VideoRecordingTest.
 *
 * @author  Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public class VideoRecordingTest {

    private VideoRecording avatar;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        this.avatar = new VideoRecording();
    }

    @Test
    public void testOverdueFeeCorrectlyOverriden() {
        assertEquals(new Dollar(0, 50), this.avatar.getOverdueFee());
    }

    @Test
    public void testGettersAndSettersHappyPath() {
        this.avatar.setCallNumber("ATLAB");
        assertEquals("ATLAB", this.avatar.getCallNumber());

        this.avatar.setCopyNumber(1);
        assertEquals(1, this.avatar.getCopyNumber());

        this.avatar.setTitle("Avatar - The Last Airbender");
        assertEquals("Avatar - The Last Airbender", this.avatar.getTitle());

        this.avatar.setDueDate(new GregorianCalendar(2024, 4, 9));
        assertEquals(new GregorianCalendar(2024, 4, 9), this.avatar.getDueDate());

        this.avatar.setBorrower("ZAC");
        assertEquals("ZAC", this.avatar.getBorrower());
    }
}
