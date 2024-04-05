package com.zachurchill.lab2;

import java.util.GregorianCalendar;
/**
 * Defines the interface for a library system that keeps track of media in
 * a library. There are three different types of media items: books,
 * audio recordings, and video recordings. Items can be added to or deleted
 * from the library. There can be multiple copies of an item in the library.
 * Items may be checked out, and the borrower id and due date are recorded in
 * the item.
 *
 * @author Franklin University
 * @version Fall 2022
 */

public interface Library
{

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
    boolean addItem(MediaItem item);

    /**
     * Deletes a item from the library.
     *
     * @param  callNumber  the call number of the item to be deleted.
     * @param  copy        the copy number of the item to be deleted.
     * @return      <code>true</code> if the item was deleted successfully,
     *              and <code> false</code> if the item was not deleted.
     */
    boolean deleteItem(String callNumber, int copy);

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
    GregorianCalendar checkOut(String callNumber,
                                      int copy, String borrower,
                                      GregorianCalendar dateCheckedOut);

    /**
     * Checks an item back into the library. The borrower id and due date are
     * set to <code> null </code> in the item.
     *
     * @param  callNumber  the call number of the item to be checked in
     * @param  copy        the copy of the item to be checked in
     * @return      <code>true</code> if the item was checked in successfully,
     *              and <code> false</code> if it was not.
     */
    boolean checkIn(String callNumber, int copy);

    /**
     * Creates and returns an array of media items that match the call number.
     * The length of the returned array is equal to the number of media items
     * that match the call number, and each element in the array is one of the
     * matching media items.
     *
     * @param callNumber the call number of the media items
     * @return an array of matching media items.
     */
    MediaItem [] findItems(String callNumber);

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
    GregorianCalendar renew(String callNumber, 
        int copy, String borrower, GregorianCalendar currentDate);
    
    /**
     * Renews all books checked out to the given borrower.
     * 
     * @param borrower the borrower
     * @param currentDate the date the renewal was requested
     * @return an array containing the books that were renewed
     */
    Book[] renew(String borrower, GregorianCalendar currentDate);
}
