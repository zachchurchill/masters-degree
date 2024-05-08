package com.zachurchill.lab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BusinessSoftwareAdapterTest {

    BusinessSoftware software;

    @BeforeEach
    public void setUp() {
        this.software = new BusinessSoftware();
        this.software.setPublisher("ZAC Enterprises");
        this.software.setBusinessId(1984);
        this.software.setApplicationName("Adapter 'de Extraordinaire");
        this.software.setDateToBeReturned("12/01/2030");
    }

    @Test
    public void testNoDefaultCallNumber() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertNull(adapter.getCallNumber());
    }

    @Test
    public void testSetNulls() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber(null));
        assertThrows(IllegalArgumentException.class, () -> adapter.setTitle(null));
        assertThrows(IllegalArgumentException.class, () -> adapter.setBorrower("0"));
    }

    @Test
    public void testEmptyStrings() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber(""));
        assertThrows(IllegalArgumentException.class, () -> adapter.setTitle(""));
        assertThrows(IllegalArgumentException.class, () -> adapter.setBorrower(""));
    }

    @Test
    public void testCallNumberNeedsAtleastOneAlphanumeric() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber("^?!"));
        adapter.setCallNumber("asdf!");
        assertEquals("asdf!", adapter.getCallNumber());
    }

    @Test
    public void testZeroDefaultCopyNumber() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertEquals(0, adapter.getCopyNumber());
    }

    @Test
    public void testSetCopyNumberToZeroThrowsError() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setCopyNumber(0));
    }

    @Test
    public void testGetTitleAdapter() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertEquals("ZAC Enterprises:Adapter 'de Extraordinaire", adapter.getTitle());
    }

    @Test
    public void testGetTitleBothNullReturnsNull() {
        this.software.setPublisher(null);
        this.software.setApplicationName(null);
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertNull(adapter.getTitle());
    }

    @Test
    public void testSetTitleExpectsColon() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setTitle("asdf"));
    }

    @Test
    public void testSetTitleHappyPath() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        adapter.setTitle("ZAC & Co:Dud Adapter");
        assertEquals("ZAC & Co:Dud Adapter", adapter.getTitle());
    }

    @Test
    public void testSetBorrowerShouldOnlyContainDigits() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setBorrower("asdf234"));
    }

    @Test
    public void testGetBorrowerReturnsBusinessId() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertEquals(String.format("%d", this.software.getBusinessId()), adapter.getBorrower());
    }

    @Test
    public void testSetBorrowerHappyPath() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        adapter.setBorrower("13908");
        assertEquals("13908", adapter.getBorrower());
    }

    @Test
    public void testGetBorrowerIdNullIfBusinessIdZero() {
        this.software.setBusinessId(0);
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertNull(adapter.getBorrower());
    }

    @Test
    public void testSetBorrowerToNullSetsBusinessIdNull() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        adapter.setBorrower(null);
        assertEquals(0, this.software.getBusinessId());
        assertNull(adapter.getBorrower());
    }

    @Test
    public void testGetDueDate() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        GregorianCalendar dueDate = new GregorianCalendar(2030, 11, 1);  // recall, MONTH starts at 0...
        assertEquals(dueDate, adapter.getDueDate());
    }

    @Test
    public void testSetDueDate() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        GregorianCalendar dueDate = new GregorianCalendar(2025, 11, 1);  // recall, MONTH starts at 0...
        adapter.setDueDate(dueDate);
        assertEquals("12/01/2025", this.software.getDateToBeReturned());
        assertEquals(dueDate, adapter.getDueDate());
    }

    @Test
    public void testSetDateNull() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        adapter.setDueDate(null);
        assertNull(this.software.getDateToBeReturned());
        assertNull(adapter.getDueDate());
    }

    @Test
    public void testCalculateFees() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        GregorianCalendar currentDate = adapter.getDueDate();
        assertEquals(new Dollar(0, 0), adapter.calculateFees(currentDate));

        currentDate.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(new Dollar(1, 0), adapter.calculateFees(currentDate));

        currentDate.add(Calendar.DAY_OF_MONTH, 1);
        assertEquals(new Dollar(2, 0), adapter.calculateFees(currentDate));
    }
}
