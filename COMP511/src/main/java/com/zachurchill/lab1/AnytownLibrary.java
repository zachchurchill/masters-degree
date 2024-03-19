package com.zachurchill.lab1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Write a description of class AnytownLibrary here.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-03-19
 */
public class AnytownLibrary implements Library
{
    /**
     * The maximum number of items allowed in the library.
     */
    public static final int MAX_ITEMS = 500;
    // instance variables
    private ArrayList<MediaItem> catalog = new ArrayList<>();
    
    /**
     * Constructor for objects of class AnytownLibrary.
     */
    public AnytownLibrary()
    {
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
        if (catalog.size() < MAX_ITEMS) {
            // Add item to the catalog
            catalog.add(item);

            // Now assign appropriate copy number
            MediaItem[] copies = this.findItems(item.getCallNumber());
            int maxCopyNumber = copies.length;
            for (MediaItem copy : copies) {
                if (copy.getCopyNumber() ==  maxCopyNumber) {
                    maxCopyNumber++;
                }
            }
            item.setCopyNumber(maxCopyNumber);
            return true;
        } else {
            return false;
        }
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
        // This is a fancy way of doing it!
        return this.catalog.removeIf(
            item -> item.getCallNumber() == callNumber && item.getCopyNumber() == copy
        );
    }

    /**
     * Checks out an item from the library. The borrower id and due date are
     * set in the item. The due date is set to 30 days from the supplied date.
     * 
     * @param  callNumber  the call number of the item to be checked out
     * @param  copy        the copy of the item to be checked out
     * @param  borrower    the id of the person borrowing the item
     * @param  dateCheckedOut the date the item was checked out.
     * @return      the due date if the item was checked out successfully,
     *              and <code> null </code> if is was not.
     */
    public GregorianCalendar checkOut(String callNumber, 
                                      int copy, String borrower,
                                      GregorianCalendar dateCheckedOut)
    {
        MediaItem[] items = this.findItems(callNumber);
        // If no items with callNumber exist, return null.
        if (items.length == 0) {
            return null;
        }

        // Now check for the item with the copy number & whether it is available
        MediaItem foundItem = null;
        for (MediaItem item : items) {
            if (item.getCopyNumber() == copy) {
                foundItem = item;
                break;
            }
        }
        if (foundItem == null || foundItem.getBorrower() != null) {
            return null; 
        }

        // Finally, check book out with appropriate due date
        foundItem.setBorrower(borrower);
        GregorianCalendar dueDate = (GregorianCalendar)dateCheckedOut.clone();
        dueDate.add(Calendar.DAY_OF_MONTH, 30);
        foundItem.setDueDate(dueDate);

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
        MediaItem[] items = this.findItems(callNumber);
        // If no items with callNumber exist, return false.
        if (items.length == 0) {
            return false;
        }

        // Now check for the item with the copy number & whether it is checked out
        MediaItem foundItem = null;
        for (MediaItem item : items) {
            if (item.getCopyNumber() == copy) {
                foundItem = item;
                break;
            }
        }
        if (foundItem == null || foundItem.getBorrower() == null) {
            return false; 
        }

        // Finally, check in item
        foundItem.setBorrower(null);
        foundItem.setDueDate(null);
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
        ArrayList<Integer> foundIndexes = new ArrayList<>();
        for (int i = 0; i < this.catalog.size(); i++) {
            MediaItem item = this.catalog.get(i);
            if (item.getCallNumber() == callNumber) {
                foundIndexes.add(i);
            }
        }
        MediaItem[] items = new MediaItem[foundIndexes.size()];
        for (int i = 0; i < foundIndexes.size(); i++) {
            items[i] = this.catalog.get(foundIndexes.get(i));
        }
        return items;
    }
    
    //There are 1000 milliseconds in one second, sixty seconds in a minute
    // sixty minutes in an hour and 24 hours in a day.  The resulting variable
    // is a calculation of 24 * 60 * 60 * 1000:
    private static long millisPerDay = 86400000;
    
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
        //  For the purposes of this assignment, please disregard any concern
        //  about daylight savings time.
        return (int)((endDate.getTimeInMillis() - 
                        startDate.getTimeInMillis()) / millisPerDay);
    }
}

