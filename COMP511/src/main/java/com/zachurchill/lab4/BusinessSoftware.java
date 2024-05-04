package com.zachurchill.lab4;

// not much to look at here, but this is what you will be adapting
// Don't change this as it will not be used when testSomething

public class BusinessSoftware
{
    private String publisher;
    private String applicationName;
    private int businessId;
    private String dateToBeReturned;
    
    public void setPublisher(final String name) {
        this.publisher = name;
    }
    
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setApplicationName(final String name) {
        this.applicationName = name;
    }
    
    public String getApplicationName() {
        return this.applicationName;
    }
    
    public void setBusinessId(final int id) {
        this.businessId = id;
    }
    
    public int getBusinessId() {
        return this.businessId;
    }
    
    public void setDateToBeReturned(final String date) {
        this.dateToBeReturned = date;
    }
    
    public String getDateToBeReturned() {
        return this.dateToBeReturned;
    }
}
