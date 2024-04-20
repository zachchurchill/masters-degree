package com.zachurchill.lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * The test class AnytownLibraryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AnytownLibraryTest {

    private Book book;
    private AudioRecording audio;
    private VideoRecording video;
    private AnytownLibrary library;
    private GregorianCalendar dueDate;
    private GregorianCalendar today;
    private GregorianCalendar pastDueDate;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        this.book = new Book();
        this.audio = new AudioRecording();
        this.video = new VideoRecording();
        this.library = new AnytownLibrary();
        this.dueDate = new GregorianCalendar(2024, 4, 9);
        this.today = new GregorianCalendar(2024, 4, 7);
        this.pastDueDate = new GregorianCalendar(2024, 5, 1);
    }

    @Test
    void testRenewingAudioRecordingReturnsNull() {
        this.audio.setCallNumber("abc123");
        this.audio.setCopyNumber(1);
        this.audio.setBorrower("ZAC");
        this.audio.setDueDate(this.dueDate);
        this.library.addItem(this.audio);
        assertNull(this.library.renew("abc123", 1, "ZAC", this.today));
    }

    @Test
    void testRenewingVideoRecordingReturnsNull() {
        this.video.setCallNumber("abc123");
        this.video.setCopyNumber(1);
        this.video.setBorrower("ZAC");
        this.video.setDueDate(this.dueDate);
        this.library.addItem(this.video);
        assertNull(this.library.renew("abc123", 1, "ZAC", this.today));
    }

    @Test
    void testRenewingBookReturnsDateForValidInputs() {
        this.book.setCallNumber("abc123");
        this.book.setCopyNumber(1);
        this.book.setBorrower("ZAC");
        this.book.setDueDate(this.dueDate);
        this.library.addItem(this.book);
        this.dueDate.add(Calendar.DAY_OF_YEAR, 14);
        assertEquals(this.dueDate, this.library.renew("abc123", 1, "ZAC", this.today));
    }

    @Test
    void testRenewingOverdueBookReturnsNull() {
        this.book.setCallNumber("abc123");
        this.book.setCopyNumber(1);
        this.book.setBorrower("ZAC");
        this.book.setDueDate(this.dueDate);
        this.library.addItem(this.book);
        assertNull(this.library.renew("abc123", 1, "ZAC", this.pastDueDate));
    }

    @Test
    void testDifferentBorrowerCannotRenewBook() {
        this.book.setCallNumber("abc123");
        this.book.setCopyNumber(1);
        this.book.setBorrower("ZAC");
        this.book.setDueDate(this.dueDate);
        this.library.addItem(this.book);
        assertNull(this.library.renew("abc123", 1, "XYZ", this.today));
    }

    @Test
    void testOnlyBooksBeforeDueDateRenewed() {
        this.audio.setCallNumber("nopersAudio");
        this.audio.setCopyNumber(1);
        this.audio.setBorrower("ZAC");
        this.audio.setDueDate(this.dueDate);
        this.library.addItem(this.audio);

        this.video.setCallNumber("nopersVideo");
        this.video.setCopyNumber(2);
        this.video.setBorrower("ZAC");
        this.video.setDueDate(this.dueDate);
        this.library.addItem(this.video);

        this.book.setCallNumber("yeppers");
        this.book.setCopyNumber(1);
        this.book.setBorrower("ZAC");
        this.book.setDueDate(this.dueDate);
        this.library.addItem(this.book);

        Book oldBook = new Book();
        GregorianCalendar pastDue = new GregorianCalendar(2024, 4, 1);
        oldBook.setCallNumber("pastDueBook");
        oldBook.setCopyNumber(9);
        oldBook.setBorrower("ZAC");
        oldBook.setDueDate(pastDue);
        this.library.addItem(oldBook);

        Book[] renewedBooks = this.library.renew("ZAC", this.today);
        assertEquals(1, renewedBooks.length);
        assertEquals(this.book, renewedBooks[0]);
    }
}
