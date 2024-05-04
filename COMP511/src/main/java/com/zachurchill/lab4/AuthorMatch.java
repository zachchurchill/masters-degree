package com.zachurchill.lab4;

/**
 * Provides matching criterion on exact last names for authors.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-23
 */
public class AuthorMatch implements MatchMaker
{
    private String lastName;

    public AuthorMatch(String author) {
        this.lastName = author;
    }
    
    @Override
    public boolean matches(MediaItem item) {
        if (!(item instanceof Book)) {
            return false;
        }
        Book book = (Book) item;
        String[] names = book.getAuthor().split(" ");
        return this.lastName.equals(names[names.length - 1]);
    }
}
