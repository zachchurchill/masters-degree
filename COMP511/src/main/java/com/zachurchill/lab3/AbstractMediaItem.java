package com.zachurchill.lab3;

import java.util.GregorianCalendar;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Defines an abstract media item in a library system.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-04-09
 */
public abstract class AbstractMediaItem implements MediaItem
{
    // instance variables
    protected String callNumber;
    protected int copyNumber;
    protected String title;
    protected GregorianCalendar dueDate;
    protected String borrowerId;

    /**
     * Returns the call number of the item.
     * 
     * @return      the call number. 
     */
    public String getCallNumber()
    {
        return this.callNumber;
    }
    
    /**
     * Sets the call number. 
     * 
     * @param   callNo the call number for the item
     */
    public void setCallNumber(String callNo)
    {
        if (callNo == null || callNo.trim() == "") {
            throw new IllegalArgumentException("non-empty string expected");
        }
        Matcher unacceptableMatcher = Pattern.compile("[^\\d|\\s|\\.|a-z|A-Z]+").matcher(callNo);
        if (unacceptableMatcher.find()) {
            System.out.println(unacceptableMatcher.group());
            throw new IllegalArgumentException("Digits, whitespace, period and characters accepted");
        }
        this.callNumber = callNo;
    }
    
    /**
     * Returns the copy number of the item.
     * 
     * @return  the copy number.
     */
    public int getCopyNumber()
    {
        return this.copyNumber;
    }

    /**
     * Sets copy number of the item.
     * 
     * @param   copy    the copy number.
     */
    public void setCopyNumber(int copy)
    {
        if (copy <= 0) {
            throw new IllegalArgumentException("copy must be positive");
        }
        this.copyNumber = copy;
    }

    /**
     * Returns the title of the item.
     * 
     * @return  the title of the item.
     */
    public String getTitle()
    {
        return this.title;
    }
    
    /**
     * Sets the title of the item.
     * 
     * @param   itemTitle  the title.
     */
    public void setTitle(String itemTitle)
    {
        if (itemTitle == null || itemTitle.trim() == "") {
            throw new IllegalArgumentException("non-empty string expected");
        }
        this.title = itemTitle;
    }

    /**
     * Returns the due date.
     * 
     * @return  the due date.
     */
    public GregorianCalendar getDueDate()
    {
        return this.dueDate;
    }
    
    /**
     * Sets the due date.
     * 
     * @param   date    the due date.
     */
    public void setDueDate(GregorianCalendar date)
    {
        this.dueDate = date;
    }
    
    /**
     * Returns the id of the person who borrowed the item.
     * 
     * @return  the borrower id. 
     */
    public String getBorrower()
    {
        return this.borrowerId;
    }

    /**
     * Set the borrower. 
     * 
     * @param   borrowerId    the id of the borrower.
     */
    public void setBorrower(String borrowerId)
    {
        if (borrowerId != null && borrowerId.trim() == "") {
            throw new IllegalArgumentException("must be null or non-empty string");
        }
        this.borrowerId = borrowerId;
    }

    /**
     * Returns the overdue fee.
     *
     * @return the fee associated with the item
     */
    public Money getOverdueFee()
    {
        return null;
    }

    /**
     * Calculates the fees owed by the borrower if the item is overdue.
     *
     * @param currentDate the date to be used in the calculation
     * @return the amount of overdue fees.
     */
    public Money calculateFees(GregorianCalendar currentDate)
    {
        if (this.dueDate.compareTo(currentDate) < 0) {
            int daysPastDue = AnytownLibrary.calculateDateDiff(this.dueDate, currentDate);
            return this.getOverdueFee().mul(daysPastDue);
        } else {
            return new Dollar(0);
        }
    }
}
