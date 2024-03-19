package com.zachurchill.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * The test class AnytownLibraryTest.
 *
 * @author  Zach Churchill <church58@email.franklin.edu>
 * @version 2024-03-19
 */
public class AnytownLibraryTest {

    private AnytownLibrary library;
    private Book book;
    private AudioRecording audio;
    private VideoRecording video;
    private GregorianCalendar today;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        this.library = new AnytownLibrary();
        this.book = new Book();
        book.setCallNumber("book");
        this.audio = new AudioRecording();
        audio.setCallNumber("audio");
        this.video = new VideoRecording();
        video.setCallNumber("video");
        this.today = new GregorianCalendar(2024, 3, 19);
    }

    /**
     * Tests that a single copy of every MediaItem subclass can be added.
     */
    @Test
    void testAddSingleCopyOfItem() {
        assertTrue(this.library.addItem(this.book));
        assertTrue(this.library.addItem(this.audio));
        assertTrue(this.library.addItem(this.video));
    }

    /**
     * Tests that a multiple copies of MediaItem correctly increment copy.
     */
    @Test
    void testAddMultipleCopiesOfItem() {
        Book anotherBook = new Book();
        anotherBook.setCallNumber(this.book.getCallNumber());

        AudioRecording anotherAudio = new AudioRecording();
        anotherAudio.setCallNumber(this.audio.getCallNumber());

        VideoRecording anotherVideo = new VideoRecording();
        anotherVideo.setCallNumber(this.video.getCallNumber());

        assertTrue(this.library.addItem(this.book));
        assertEquals(1, this.book.getCopyNumber());

        assertTrue(this.library.addItem(anotherBook));
        assertEquals(2, anotherBook.getCopyNumber());

        assertTrue(this.library.addItem(this.audio));
        assertEquals(1, this.audio.getCopyNumber());

        assertTrue(this.library.addItem(anotherAudio));
        assertEquals(2, anotherAudio.getCopyNumber());

        assertTrue(this.library.addItem(this.video));
        assertEquals(1, this.video.getCopyNumber());

        assertTrue(this.library.addItem(anotherVideo));
        assertEquals(2, anotherVideo.getCopyNumber());
    }

    /**
     * Tests that this.library can only hold 500 items.
     */
    @Test
    void testLibraryLimit() {
        for (int i = 0; i < 500; i++) {
            assertTrue(this.library.addItem(this.book));
        }
        assertFalse(this.library.addItem(this.book));
    }

    /**
     * Test library returns empty list if no item found.
     */
    @Test
    void testFindNoCopiesOfItem() {
        library.addItem(this.book);
        MediaItem[] foundBooks = library.findItems("none exist");
        assertEquals(0, foundBooks.length);
    }

    /**
     * Test library can find single item in catalog.
     */
    @Test
    void testFindSingleCopyOfItem() {
        library.addItem(this.book);
        MediaItem[] foundBooks = library.findItems("book");
        assertEquals(1, foundBooks.length);
        assertEquals("book", foundBooks[0].getCallNumber());
    }

    /**
     * Test library returns multiple copies of item in catalog.
     */
    @Test
    void testFindMultipleCopiesOfItem() {
        library.addItem(this.book);
        library.addItem(this.audio);
        library.addItem(this.book);
        MediaItem[] foundBooks = library.findItems("book");
        assertEquals(2, foundBooks.length);
        for (MediaItem book : foundBooks) {
            assertEquals("book", book.getCallNumber());
        }
    }

    /**
     * Test library correctly deletes items from catalog.
     */
    @Test
    void testDeleteOnlyItem() {
        library.addItem(this.book);
        library.addItem(this.audio);
        library.addItem(this.video);
        assertTrue(library.deleteItem(book.getCallNumber(), 1));
        assertTrue(library.deleteItem(audio.getCallNumber(), 1));
        assertTrue(library.deleteItem(video.getCallNumber(), 1));
    }

    /**
     * Test library deletes correct copy of item.
     */
    @Test
    void testDeleteAndAddItems() {
        String callNo = this.book.getCallNumber();
        Book physicalCopyOfBook = new Book();
        physicalCopyOfBook.setCallNumber(callNo);

        library.addItem(this.book);
        library.addItem(this.audio);
        library.addItem(this.video);
        library.addItem(physicalCopyOfBook);

        assertTrue(library.deleteItem(callNo, 1));
        MediaItem[] books = library.findItems(callNo);
        assertEquals(1, books.length);
        assertEquals(2, books[0].getCopyNumber());

        Book anotherCopy = new Book();
        anotherCopy.setCallNumber(callNo);
        library.addItem(anotherCopy);
        assertEquals(3, anotherCopy.getCopyNumber());
    }

    /**
     * Test checking out nonexistent item returns null.
     */
    @Test
    void testCheckingOutNonexistentItemReturnsNull() {
        assertNull(library.checkOut("LOTR", 1, "ZAC", this.today));
    }

    /**
     * Test checking out book correctly sets borrower and due date.
     */
    @Test
    void testCheckingOutCorrectSetsValues() {
        library.addItem(this.book);

        GregorianCalendar expectedDueDate = new GregorianCalendar(2024, 4, 19);
        GregorianCalendar dueDate = library.checkOut(
            this.book.getCallNumber(),
            this.book.getCopyNumber(),
            "ZAC",
            this.today
        );
        assertEquals(expectedDueDate, dueDate);
        assertEquals(expectedDueDate, this.book.getDueDate());
        assertEquals("ZAC", this.book.getBorrower());
    }

    /**
     * Test checking out already checked out book returns null.
     */
    @Test
    void testCheckingOutAlreadyCheckedOutItemReturnsNull() {
        library.addItem(this.book);

        GregorianCalendar dueDate = library.checkOut(
            this.book.getCallNumber(),
            this.book.getCopyNumber(),
            "ZAC",
            this.today
        );
        assertNull(
            library.checkOut(
                this.book.getCallNumber(),
                this.book.getCopyNumber(),
                "ZAC",
                this.today
            )
        );
    }

    /**
     * Test checking in nonexistent item returns false.
     */
    @Test
    void testCheckingInNonexistentItemReturnsFalse() {
        assertFalse(library.checkIn("LOTR", 1));
    }

    /**
     * Test checking in not already checked out book returns false.
     */
    @Test
    void testCheckingInNotAlreadyCheckedOutItemReturnsFalse() {
        library.addItem(this.book);
        assertFalse(library.checkIn(this.book.getCallNumber(), this.book.getCopyNumber()));
    }

    /**
     * Test checkIn happy path.
     */
    @Test
    void testCheckingInBookReturnsTrueForCheckedOutBook() {
        library.addItem(this.book);
        GregorianCalendar expectedDueDate = new GregorianCalendar(2024, 4, 19);

        library.checkOut(this.book.getCallNumber(), this.book.getCopyNumber(), "ZAC", this.today);
        assertEquals(expectedDueDate, this.book.getDueDate());
        assertEquals("ZAC", this.book.getBorrower());
        assertTrue(library.checkIn(this.book.getCallNumber(), this.book.getCopyNumber()));
        assertNull(this.book.getBorrower());
        assertNull(this.book.getDueDate());
    }
}
