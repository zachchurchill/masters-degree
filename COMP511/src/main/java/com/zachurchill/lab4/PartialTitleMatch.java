package com.zachurchill.lab4;

/**
 * Provides matching criterion for non-case sensitive partial matches on the title.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-23
 */
public class PartialTitleMatch implements MatchMaker
{
    private String titleContains;

    public PartialTitleMatch(String title) {
        this.titleContains = title.toLowerCase();
    }

    @Override
    public boolean matches(MediaItem item) {
        return item.getTitle().toLowerCase().contains(this.titleContains);
    }
}
