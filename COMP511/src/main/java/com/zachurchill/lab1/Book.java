package com.zachurchill.lab1;

import java.util.GregorianCalendar;
/**
 * Book implements the MediaType interface for print-related mediums.
 * 
 * @author Zach Churchill <church58@email.franklin.edu>
 * @version 2024-03-19
 */

public class Book implements MediaItem
{
    // instance variables
    private String title = null;
    private String author = null;
    private String callNumber = null;
    private int copyNumber = 0;
    private GregorianCalendar dueDate = null;
    private String borrower = null;
    private final Dollar LATE_FEE_CHARGE = new Dollar(0, 25);

    /**
     * Constructor for objects of class Book.
     */
    public Book()
    {
    }

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
        return this.borrower;
    }

    /**
     * Set the borrower. 
     * 
     * @param   borrowerId    the id of the borrower.
     */
    public void setBorrower(String borrowerId)
    {
        this.borrower = borrowerId;
    }

    /**
     * Calculates the fees owed by the borrower if the item is overdue.
     * 
     * @param currentDate the date to use for the calculation
     * @return the amount of overdue fees.
     */
    public Money calculateFees(GregorianCalendar currentDate)
    {
        if (this.dueDate.compareTo(currentDate) < 0) {
            int daysPastDue = AnytownLibrary.calculateDateDiff(this.dueDate, currentDate);
            return this.LATE_FEE_CHARGE.mul(daysPastDue);
        } else {
            return new Dollar(0);
        }
    }
    
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
        this.author = name;
    }
}
