package com.zachurchill.lab1;

import static org.junit.jupiter.api.Assertions.*;

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
        Book physicalCopyOfBook = new Book();
        physicalCopyOfBook.setCallNumber(this.book.getCallNumber());

        assertTrue(this.library.addItem(this.book));
        assertEquals(1, this.book.getCopyNumber());

        assertTrue(this.library.addItem(physicalCopyOfBook));
        assertEquals(2, physicalCopyOfBook.getCopyNumber());

        assertTrue(this.library.addItem(this.audio));
        assertEquals(1, this.audio.getCopyNumber());

        assertTrue(this.library.addItem(this.audio));
        assertEquals(2, this.audio.getCopyNumber());

        assertTrue(this.library.addItem(this.video));
        assertEquals(1, this.video.getCopyNumber());

        assertTrue(this.library.addItem(this.video));
        assertEquals(2, this.video.getCopyNumber());
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
        Book physicalCopyOfBook = new Book();
        physicalCopyOfBook.setCallNumber(this.book.getCallNumber());

        library.addItem(this.book);
        library.addItem(this.audio);
        library.addItem(this.video);
        library.addItem(physicalCopyOfBook);

        assertTrue(library.deleteItem(physicalCopyOfBook.getCallNumber(), 2));
        assertEquals(1, library.findItems(this.book.getCallNumber()).length);

        Book anotherCopy = new Book();
        anotherCopy.setCallNumber(this.book.getCallNumber());
        library.addItem(anotherCopy);
        assertEquals(2, anotherCopy.getCopyNumber());
    }
}
