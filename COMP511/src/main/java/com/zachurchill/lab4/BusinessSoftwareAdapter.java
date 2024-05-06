package com.zachurchill.lab4;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Adapts a BusinessSoftware object to the MediaItem interface.
 *
 * @author Franklin University
 * @version Fall 2016
 */
public class BusinessSoftwareAdapter implements MediaItem {

    private BusinessSoftware businessSoftware;
    private String callNumber;
    private int copyNumber;

    public BusinessSoftwareAdapter(BusinessSoftware software) {
        this.businessSoftware = software;
    }

    /**
     * Returns the call number of the item.
     *
     * @return      the call number.
     */
    public String getCallNumber() {
        return this.callNumber;
    }

    /**
     * Sets the call number.
     *
     * @param   callNo the call number for the item
     */
    public void setCallNumber(String callNo) {
        if (callNo == null || callNo.length() == 0) {
            throw new IllegalArgumentException();
        }
        Matcher specialChars = Pattern.compile("[^a-zA-Z0-9]").matcher(callNo);
        if (specialChars.find()) {
            throw new IllegalArgumentException("no special characters");
        }
        this.callNumber = callNo;
    }

    /**
     * Returns the copy number of the item.
     *
     * @return  the copy number.
     */
    public int getCopyNumber() {
        return this.copyNumber;
    }

    /**
     * Sets copy number of the item.
     *
     * @param   copy    the copy number.
     */
    public void setCopyNumber(int copy) {
        if (copy < 1) {
            throw new IllegalArgumentException();
        }
        this.copyNumber = copy;
    }

    /**
     * Returns the title of the item.
     *
     * @return  the title of the item.
     */
    public String getTitle() {
        if (this.businessSoftware.getApplicationName() == null && this.businessSoftware.getPublisher() == null) {
            return null;
        }
        return String.format(
            "%s:%s",
            this.businessSoftware.getPublisher(),
            this.businessSoftware.getApplicationName()
        );
    }

    /**
     * Sets the title of the item.
     *
     * @param   itemTitle  the title.
     */
    public void setTitle(String itemTitle) {
        if (itemTitle == null) {
            throw new IllegalArgumentException("non null string required");
        } else if (!itemTitle.contains(":")) {
            throw new IllegalArgumentException(
                String.format("`itemTitle` must contain ':'; received '%s'", itemTitle)
            );
        }
        String[] titleParts = itemTitle.split(":");
        this.businessSoftware.setPublisher(titleParts[0]);
        this.businessSoftware.setApplicationName(titleParts[1]);
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
        if (borrowerId == null || borrowerId.length() == 0) {
            throw new IllegalArgumentException();
        }
        Matcher nonDigitChars = Pattern.compile("[^0-9]").matcher(borrowerId);
        if (nonDigitChars.find()) {
            throw new IllegalArgumentException("must only be digits");
        }
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

