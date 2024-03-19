package com.zachurchill.lab1;

import java.util.GregorianCalendar;
/**
 * Defines the interface for media items in a library system.
 *
 * @author Franklin University
 * @version Fall 2022
 */
public interface MediaItem {
    /**
     * Returns the call number of the item.
     *
     * @return      the call number.
     */
    String getCallNumber();

    /**
     * Sets the call number.
     *
     * @param   callNo the call number for the item
     */
    void setCallNumber(String callNo);

    /**
     * Returns the copy number of the item.
     *
     * @return  the copy number.
     */
    int getCopyNumber();

    /**
     * Sets copy number of the item.
     *
     * @param   copy    the copy number.
     */
    void setCopyNumber(int copy);

    /**
     * Returns the title of the item.
     *
     * @return  the title of the item.
     */
    String getTitle();

    /**
     * Sets the title of the item.
     *
     * @param   itemTitle  the title.
     */
    void setTitle(String itemTitle);

    /**
     * Returns the due date.
     *
     * @return  the due date.
     */
    GregorianCalendar getDueDate();

    /**
     * Sets the due date.
     *
     * @param   date    the due date.
     */
    void setDueDate(GregorianCalendar date);

    /**
     * Returns the id of the person who borrowed the item.
     *
     * @return  the borrower id.
     */
    String getBorrower();

    /**
     * Set the borrower.
     *
     * @param   borrowerId    the id of the borrower.
     */
    void setBorrower(String borrowerId);

    /**
     * Calculates the fees owed by the borrower if the item is overdue.
     *
     * @param currentDate the date to use for the calculation
     * @return the amount of overdue fees.
     */
    Money calculateFees(GregorianCalendar currentDate);
}
