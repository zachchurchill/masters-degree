package com.zachurchill.lab2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents a library.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnytownLibrary implements Library
{
    /**
     * The maximum number of items allowed in the library.
     */
    public static final int MAX_ITEMS = 500;
    
    // instance variables
    private MediaItem[] items;
    private int numItems;
    
    /**
     * Constructor for objects of class AnytownLibrary.
     */
    public AnytownLibrary()
    {
        items = new MediaItem[MAX_ITEMS];
        numItems = 0;
    }

    /**
     * Adds an item to the library. The call number within the item does
     * not exist in the library, the copy number within the item will be 
     * set to 1 by this method. If the copies of the item already exist in
     * the library, the copy number will be set to the next copy number. For
     * example, if the highest copy number is 3, the item added will be copy
     * number 4.                              
     * 
     * @param  item  the item to be added to library.
     * @return      <code>true</code> if the item was added successfully, 
     *              and <code>false</code> if the item was not added.
     */
    public boolean addItem(MediaItem item)
    {
        if ((item == null) || (numItems == MAX_ITEMS))
        {
            return false;
        }
        
        int highestCopy = 0;
        
        for (int i = 0; i < numItems; i++)
        {
            MediaItem anItem = items[i];
            if (item.getCallNumber().equals(anItem.getCallNumber()) &&
                            anItem.getCopyNumber() > highestCopy)
            {
                highestCopy = anItem.getCopyNumber();
            }
        }
        
        item.setCopyNumber(highestCopy + 1);
        
        items[numItems++] = item;
        return true;
    }
    
    /**
     * Finds an item by call number and copy number.
     * 
     * @param callNumber the call number
     * @param copy the copy number
     * @return the index of the item, or -1 if not found
     */
    private int findItem(String callNumber, int copy)
    {
        for (int i = 0; i < numItems; i++)
        {
            MediaItem item = items[i];
            if (callNumber.equals(item.getCallNumber()) &&
                            item.getCopyNumber() == copy)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Deletes a item from the library.
     * 
     * @param  callNumber  the call number of the item to be deleted.
     * @param  copy        the copy number of the item to be deleted.     
     * @return      <code>true</code> if the item was deleted successfully, 
     *              and <code> false</code> if the item was not deleted.
     */
    public boolean deleteItem(String callNumber, int copy)
    {
        if (callNumber == null)
        {
            return false;
        }

        int index = findItem(callNumber, copy);

        if (index == -1)
        {
            return false;
        }
        
        items[index] = items[numItems - 1];
        items[numItems - 1] = null;
        numItems--;
        return true;
    }
    
    /**
     * Checks out an item from the library. The borrower id and due date are
     * set in the item. The due date is set to 30 days from the current date.
     * 
     * @param  callNumber  the call number of the item to be checked out
     * @param  copy        the copy of the item to be checked out
     * @param  borrower    the id of the person borrowing the item
     * @return      the due date if the item was checked out successfully,
     *              and <code> null </code> if is was not.
     */
    public GregorianCalendar checkOut(String callNumber, 
                                      int copy, String borrower,
                                      GregorianCalendar dateCheckedOut)
    {
        int index = findItem(callNumber, copy);
        
        if (index == -1)
        {
            return null;
        }
        
        MediaItem item = items[index];
        
        //  Fail if the item is already checked out
        if (item.getDueDate() != null)
        {
            return null;
        }
        
        //  Set the due date 30 days from now
        GregorianCalendar dueDate = (GregorianCalendar)dateCheckedOut.clone();
        dueDate.add(Calendar.DAY_OF_MONTH, 30);
        item.setDueDate(dueDate); 
        item.setBorrower(borrower);
        return dueDate;
    }

    /**
     * Checks an item back into the library. The borrower id and due date are
     * set to <code> null </code> in the item. 
     * 
     * @param  callNumber  the call number of the item to be checked in
     * @param  copy        the copy of the item to be checked in
     * @return      <code>true</code> if the item was checked in successfully, 
     *              and <code> false</code> if it was not.
     */
    public boolean checkIn(String callNumber, int copy)
    {
        int index = findItem(callNumber, copy);
        
        if (index == -1)
        {
            return false;
        }
        
        MediaItem item = items[index];
        
        //  Fail if it wasn't checked out
        if (item.getBorrower() == null || item.getDueDate() == null)
        {
            return false;
        }
        
        item.setBorrower(null);
        item.setDueDate(null);
        return true;
    }

    /**
     * Creates and returns an array of media items that match the call number.
     * The length of the returned array is equal to the number of media items
     * that match the call number, and each element in the array is one of the
     * matching media items.
     * 
     * @param callNumber the call number of the media items
     * @return an array of matching media items.
     */
    public MediaItem [] findItems(String callNumber)
    {
        int matchCount = 0;
        for (int i = 0; i < numItems; i++)
        {
            if (callNumber.equals(items[i].getCallNumber()))
            {
                matchCount++;
            }
        }
        MediaItem [] found = new MediaItem[matchCount];
        matchCount = 0;
        for (int i = 0; i < numItems; i++)
        {
            if (callNumber.equals(items[i].getCallNumber()))
            {
                found[matchCount++] = items[i];
            }
        }
        return found;
    }
    
    private static long millisPerDay = 24 * 60 * 60 * 1000;
    
    /**
     * Returns the difference between the supplied dates in days.
     * 
     * @param startDate the starting date
     * @param endDate the ending date
     * @return
     */
    public static int calculateDateDiff(GregorianCalendar startDate, 
        GregorianCalendar endDate)
    {
        //  This contains a bug related to daylight savings time, 
        //  but is good enough for a lab.
        return (int)((endDate.getTimeInMillis() - 
                        startDate.getTimeInMillis()) / millisPerDay);
    }
    
    /**
     * Adds 14 days to the due date of the given book, and
     * returns the new due date.
     * 
     * @param callNumber the call number
     * @param copy the copy number
     * @param borrower the borrower id
     * @param currentDate the date the renewal was requested
     * @return the new due date
     */
    public GregorianCalendar renew(String callNumber, 
        int copy, String borrower, GregorianCalendar currentDate)
    {
        /*# TODO: insert Code here */ 
        return null;
    }
    
    /**
     * Renews all books checked out to the given borrower.
     * 
     * @param borrower the borrower
     * @param currentDate the date the renewal was requested
     * @return an array containing the books that were renewed
     */
    public Book[] renew(String borrower, GregorianCalendar currentDate)
    {
        /*# TODO: insert Code here */ 
        return null;
    }
}
