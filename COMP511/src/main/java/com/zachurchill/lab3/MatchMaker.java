package com.zachurchill.lab3;

/**
 * Defines an interface for an object that encapsulates a search algorithm.
 *
 * @author Franklin University
 * @version Fall 2016
 */

public interface MatchMaker
{
    /**
     * Returns true if the item matches the criterion.
     *
     * @param  item the item to match
     * @return true if the item matches the criterion.
     */
    boolean matches (MediaItem item);
}

