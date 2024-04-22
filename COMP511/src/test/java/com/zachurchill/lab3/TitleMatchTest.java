package com.zachurchill.lab3;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TitleMatchTest {

    private AnytownLibrary library;

    @BeforeEach
    public void setUp() {
        this.library = new AnytownLibrary();
    }

    @Test
    public void testNoMatchingTitlesReturnsEmptyList() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        TitleMatch theHobbit = new TitleMatch("The Hobbit");
        List<MediaItem> found = this.library.searchItems(theHobbit);
        assertEquals(0, found.size());
    }

    @Test void testTitleMustMatchExactly() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        TitleMatch lotrLowerCase = new TitleMatch("lord of the rings");
        List<MediaItem> found = this.library.searchItems(lotrLowerCase);
        assertEquals(0, found.size());

        TitleMatch lotrCorrect = new TitleMatch("Lord of the Rings");
        found = this.library.searchItems(lotrCorrect);
        assertEquals(1, found.size());
    }
}
