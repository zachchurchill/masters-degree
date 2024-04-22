package com.zachurchill.lab3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ListIterator;

/**
 * Represents a library.
 *
 * @author Franklin University
 * @version Fall 2016
 */
public class AnytownLibrary implements Library
{

    private ArrayList<MediaItem> items;

    /**
     * Constructor for objects of class AnytownLibrary.
     */
    public AnytownLibrary()
    {
        this.items = new ArrayList<>();
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
        if (item == null) {
            return false;
        }

        int highestCopy = 0;
        for (MediaItem anItem : this.items) {
            if (item.getCallNumber().equals(anItem.getCallNumber()) &&
                            anItem.getCopyNumber() > highestCopy)
            {
                highestCopy = anItem.getCopyNumber();
            }

        }

        item.setCopyNumber(highestCopy + 1);

        return this.items.add(item);
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
        ListIterator<MediaItem> itr = this.items.listIterator();
        while (itr.hasNext()) {
            MediaItem item = itr.next();
            if (callNumber.equals(item.getCallNumber()) &&
                            item.getCopyNumber() == copy)
            {
                return itr.previousIndex();
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
        this.items.remove(index);
        return true;
    }

    /**
     * Checks out an item from the library. The borrower id and due date are
     * set in the item. The due date is set to 30 days from the current date.
     *
     * @param  callNumber  	the call number of the item to be checked out
     * @param  copy        	the copy of the item to be checked out
     * @param  borrower    	the id of the person borrowing the item
	  * @param  dateCheckedOut the date the item was checked out
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

        MediaItem item = this.items.get(index);

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

        MediaItem item = this.items.get(index);

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

        for (MediaItem item : this.items)
        {
            if (callNumber.equals(item.getCallNumber()))
            {
                matchCount++;
            }
        }
        MediaItem [] found = new MediaItem[matchCount];
        matchCount = 0;
        for (MediaItem item : this.items)
        {
            if (callNumber.equals(item.getCallNumber()))
            {
                found[matchCount++] = item;
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
     * @return an integer representing the difference in dates
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
        int index = findItem(callNumber, copy);
        if (index == -1)
        {
            return null;
        }

        MediaItem item = this.items.get(index);
        if (canRenew(item, borrower, currentDate))
        {
            return renewBook((Book)item);
        }

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

        int numToRenew = 0;

        //  First count how many we can renew
        for (MediaItem item : this.items) {
            if (canRenew(item, borrower, currentDate))
            {
                numToRenew++;
            }
        }

        Book[] books = new Book[numToRenew];
        int numRenewed = 0;

        //  Now renew them, and put them into the array
        for (MediaItem item : this.items) {
            if (canRenew(item, borrower, currentDate))
            {
                Book book = (Book)item;
                renewBook(book);
                books[numRenewed] = book;
                numRenewed++;
            }
        }

        return books;
    }

    /**
     * Returns true if an item can be renewed.
     *
     * @param item the item
     * @param borrower the borrower attempting to renew it
     * @param currentDate the current date
     * @return true if it can be renewed
     */
    private boolean canRenew(MediaItem item, String borrower,
        GregorianCalendar currentDate)
    {
        if (!(item instanceof Book) || !borrower.equals(item.getBorrower()))
        {
            //  Not a book, or wrong borrower
            return false;
        }

        GregorianCalendar dueDate = item.getDueDate();
        if (dueDate != null &&
                calculateDateDiff(dueDate, currentDate) > 0)
        {
            //  Overdue
            return false;
        }

        return true;
    }

    /**
     * Renews a book.
     *
     * @param book the book
     * @return the new due date
     */
    private GregorianCalendar renewBook(Book book)
    {
        GregorianCalendar dueDate = book.getDueDate();
        dueDate.add(Calendar.DAY_OF_MONTH, 14);
        book.setDueDate(dueDate);
        return dueDate;
    }

    /**
     * Creates and returns an array containing all items in the library.
     *
     * @return the array
     */
    public MediaItem [] getItems()
    {
        return this.items.toArray(new MediaItem[0]);
    }
    
    /**
    * Creates and returns a list of media items that match the criterion.
    * If the <code>MatchMaker</code> was not set prior to this method being
    * called, the method will return <code>null</code>.
    * If no items are found, the method will return an empty list.
    *
    * @param criterion the search criterion
    * @return a list of matching media items or <code>null</code>.
    */
    public List<MediaItem> searchItems(MatchMaker criterion)
    {
        /*# TODO: insert Code here */
        throw new UnsupportedOperationException();
    }
}
