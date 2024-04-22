package com.zachurchill.lab3;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthorMatchTest {

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

        AuthorMatch nope = new AuthorMatch("Hopkins");
        List<MediaItem> found = this.library.searchItems(nope);
        assertEquals(0, found.size());
    }

    @Test
    public void testIsCaseSensitive() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        AuthorMatch tolkienLowerCase = new AuthorMatch("tolkien");
        List<MediaItem> found = this.library.searchItems(tolkienLowerCase);
        assertEquals(0, found.size());
    }

    @Test
    public void testOnlyLastName() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        AuthorMatch jrr = new AuthorMatch("JRR");
        List<MediaItem> found = this.library.searchItems(jrr);
        assertEquals(0, found.size());
    }

    @Test
    public void testLastNamesWork() {
        Book lotr = new Book();
        lotr.setTitle("Lord of the Rings");
        lotr.setAuthor("JRR Tolkien");
        this.library.addItem(lotr);

        AuthorMatch tolkien = new AuthorMatch("Tolkien");
        List<MediaItem> found = this.library.searchItems(tolkien);
        assertEquals(1, found.size());
    }

    @Test
    public void testVideoRecordingsNotUsed() {
        VideoRecording starWars = new VideoRecording();
        starWars.setTitle("Star Wars");
        this.library.addItem(starWars);
        AuthorMatch wars = new AuthorMatch("Wars");
        List<MediaItem> found = this.library.searchItems(wars);
        assertEquals(0, found.size());
    }

    @Test
    public void testAudioRecordingsNotUsed() {
        AudioRecording barkAtTheMoon = new AudioRecording();
        barkAtTheMoon.setTitle("Bark at the Moon");
        this.library.addItem(barkAtTheMoon);
        AuthorMatch moon = new AuthorMatch("Moon");
        List<MediaItem> found = this.library.searchItems(moon);
        assertEquals(0, found.size());
    }
}
