package com.zachurchill.lab3;

/**
 * Provides matching criterion on exact title matches.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-23
 */
public class TitleMatch implements MatchMaker
{
    private String title;

    public TitleMatch(String title) {
        this.title = title;
    }

    @Override
    public boolean matches(MediaItem item) {
        return title == item.getTitle();
    }
}
