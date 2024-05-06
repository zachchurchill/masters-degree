package com.zachurchill.lab4;

import static org.junit.jupiter.api.Assertions.*;

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
        this.software.setDateToBeReturned("01/01/2030");
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
    }

    @Test
    public void testEmptyStrings() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber(""));
        assertThrows(IllegalArgumentException.class, () -> adapter.setTitle(""));
        assertThrows(IllegalArgumentException.class, () -> adapter.setBorrower(""));
    }

    @Test
    public void testSetCallNumberSpecialCharThrowsError() {
        BusinessSoftwareAdapter adapter = new BusinessSoftwareAdapter(this.software);
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber("@asdf"));
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber("asdf!"));
        assertThrows(IllegalArgumentException.class, () -> adapter.setCallNumber("^?!"));
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
}
