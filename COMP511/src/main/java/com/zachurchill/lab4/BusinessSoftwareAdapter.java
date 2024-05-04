package com.zachurchill.lab4;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Adapts a BusinessSoftware object to the MediaItem interface.
 *
 * @author Franklin University
 * @version Fall 2016
 */
public class BusinessSoftwareAdapter implements MediaItem {

    public BusinessSoftwareAdapter(BusinessSoftware software) {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Returns the call number of the item.
     *
     * @return      the call number.
     */
    public String getCallNumber() {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Sets the call number.
     *
     * @param   callNo the call number for the item
     */
    public void setCallNumber(String callNo) {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Returns the copy number of the item.
     *
     * @return  the copy number.
     */
    public int getCopyNumber() {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Sets copy number of the item.
     *
     * @param   copy    the copy number.
     */
    public void setCopyNumber(int copy) {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Returns the title of the item.
     *
     * @return  the title of the item.
     */
    public String getTitle() {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Sets the title of the item.
     *
     * @param   itemTitle  the title.
     */
    public void setTitle(String itemTitle) {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Returns the due date.
     *
     * @return  the due date.
     */
    public GregorianCalendar getDueDate() {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Sets the due date.
     *
     * @param   date    the due date.
     */
    public void setDueDate(GregorianCalendar date) {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Returns the id of the person who borrowed the item.
     *
     * @return  the borrower id.
     */
    public String getBorrower() {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Set the borrower.
     *
     * @param   borrowerId    the id of the borrower.
     */
    public void setBorrower(String borrowerId) {
        throw new UnsupportedOperationException("Not written");
    }

    /**
     * Calculates the fees owed by the borrower if the item is overdue.
     *
     * @param currentDate the date to be used in the calculation
     * @return the amount of overdue fees.
     */
    public Money calculateFees(GregorianCalendar currentDate) {
        throw new UnsupportedOperationException("Not written");
    }
}

