package com.zachurchill.lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
/**
 * The test class BookTest.
 *
 * @author  Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public class BookTest {

    private Book lotr;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        this.lotr = new Book();
    }

    @Test
    public void testOverdueFeeCorrectlyOverriden() {
        assertEquals(new Dollar(0, 25), this.lotr.getOverdueFee());
    }

    @Test
    public void testGettersAndSettersHappyPath() {
        this.lotr.setCallNumber("LOTR");
        assertEquals("LOTR", this.lotr.getCallNumber());

        this.lotr.setCopyNumber(1);
        assertEquals(1, this.lotr.getCopyNumber());

        this.lotr.setTitle("Lord of the Rings");
        assertEquals("Lord of the Rings", this.lotr.getTitle());

        this.lotr.setDueDate(new GregorianCalendar(2024, 4, 9));
        assertEquals(new GregorianCalendar(2024, 4, 9), this.lotr.getDueDate());

        this.lotr.setBorrower("ZAC");
        assertEquals("ZAC", this.lotr.getBorrower());

        this.lotr.setAuthor("J.R.R. Tolkien");
        assertEquals("J.R.R. Tolkien", this.lotr.getAuthor());
    }

    @Test
    public void testAuthorShouldBeNonEmptyString() {
        boolean emptyStringCaught = false;
        try {
            this.lotr.setAuthor("");
        } catch(IllegalArgumentException e) {
            emptyStringCaught = true;
        }
        assertTrue(emptyStringCaught);

        boolean onlySpacesCaught = false;
        try {
            this.lotr.setAuthor("     ");
        } catch(IllegalArgumentException e) {
            onlySpacesCaught = true;
        }
        assertTrue(onlySpacesCaught);

        boolean nullCaught = false;
        try {
            this.lotr.setAuthor(null);
        } catch(IllegalArgumentException e) {
            nullCaught = true;
        }
        assertTrue(nullCaught);
    }
}
