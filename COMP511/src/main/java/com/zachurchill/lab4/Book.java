package com.zachurchill.lab4;

/**
 * Book provides media item related to books.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public class Book extends AbstractMediaItem
{
    // instance variables
    private String author;
    
    /**
     * Returns the name of the author.
     * 
     * @return  the name of the author.
     */
    public String getAuthor()
    {
        return this.author;
    }    
    
    /**
     * Sets the name of the author.
     * 
     * @param   name    the name of the author.
     */
    public void setAuthor(String name)
    {
        if (name == null || name.trim() == "") {
            throw new IllegalArgumentException("non-empty string expected");
        }
        this.author = name;
    } 
    
    @Override
    public Money getOverdueFee() {
        return new Dollar(0, 25);
    }
}
