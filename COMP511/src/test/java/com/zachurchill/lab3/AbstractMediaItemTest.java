package com.zachurchill.lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


/**
 * Dummy class that extends {@link AbstractMediaItem} for testing
 */
class DummyMediaItem extends AbstractMediaItem {
}

/**
 * Tests the default setters for AbstractMediaItem by using a simple class that extends this abstract class.
 *
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public class AbstractMediaItemTest {

    private AbstractMediaItem item;

    @BeforeEach
    void setUp() {
        this.item = new DummyMediaItem();
    }

    @Test
    void testTitleShouldBeNonEmptyString() {
        boolean emptyStringCaught = false;
        try {
            this.item.setTitle("");
        } catch(IllegalArgumentException e) {
            emptyStringCaught = true;
        }
        assertTrue(emptyStringCaught);

        boolean onlySpacesCaught = false;
        try {
            this.item.setTitle("     ");
        } catch(IllegalArgumentException e) {
            onlySpacesCaught = true;
        }
        assertTrue(onlySpacesCaught);

        boolean nullCaught = false;
        try {
            this.item.setTitle(null);
        } catch(IllegalArgumentException e) {
            nullCaught = true;
        }
        assertTrue(nullCaught);
    }

    @Test
    void testBorrowerCanBeNull() {
        this.item.setBorrower(null);
        assertNull(this.item.getBorrower());
    }

    @Test
    void testBorrowerShouldStillBeNonEmptyString() {
        boolean caught = false;
        try {
            this.item.setBorrower("    ");
        } catch(IllegalArgumentException e) {
            caught = true;
        }
        assertTrue(caught);
    }

    @Test
    void testDueDateCanBeNull() {
        this.item.setDueDate(null);
        assertNull(this.item.getDueDate());
    }

    @Test
    void testCopyNumberMustBePositive() {
        boolean negativeCaught = false;
        try {
            this.item.setCopyNumber(-1);
        } catch(IllegalArgumentException e) {
            negativeCaught = true;
        }
        assertTrue(negativeCaught);

        boolean zeroCaught = false;
        try {
            this.item.setCopyNumber(0);
        } catch(IllegalArgumentException e) {
            zeroCaught = true;
        }
        assertTrue(zeroCaught);
    }

    @Test
    void testCallNumberAdheresToAllowedCharacters() {
        boolean nullCaught = false;
        try {
            this.item.setCallNumber(null);
        } catch(IllegalArgumentException e) {
            nullCaught = true;
        }
        assertTrue(nullCaught);

        boolean specialCharsCaught = false;
        try {
            this.item.setCallNumber("asdf$$$123ASDF");
        } catch(IllegalArgumentException e) {
            specialCharsCaught = true;
        }
        assertTrue(specialCharsCaught);
    }
}
