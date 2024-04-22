package com.zachurchill.lab3;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PartialTitleMatchTest {

    private AnytownLibrary library;

    @BeforeEach
    public void setUp() {
        this.library = new AnytownLibrary();
    }

    @Test
    public void testNoMatchesReturnsEmptyList() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        PartialTitleMatch nope = new PartialTitleMatch("nopers");
        List<MediaItem> found = this.library.searchItems(nope);
        assertEquals(0, found.size());
    }

    @Test
    public void testNotCaseSensitive() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        PartialTitleMatch lotrLowerCase = new PartialTitleMatch("lord of the rings");
        List<MediaItem> found = this.library.searchItems(lotrLowerCase);
        assertEquals(1, found.size());
    }

    @Test
    public void testSnippetsWork() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        PartialTitleMatch lord = new PartialTitleMatch("Lord");
        List<MediaItem> found = this.library.searchItems(lord);
        assertEquals(1, found.size());
    }
}
