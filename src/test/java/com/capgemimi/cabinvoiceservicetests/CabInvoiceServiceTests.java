package com.capgemimi.cabinvoiceservicetests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.capgemimi.invoiceservice.CabInvoiceService;

public class CabInvoiceServiceTests {

	@Test
	public void GivenDistanceAndMinutes_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		CabInvoiceService CIS = new CabInvoiceService();
		double distance = 2.0;
		double minutes = 5;
		double fare = CIS.getFare(distance, minutes);
		Assert.assertEquals(25, fare, 0.01);
	}
	
	@Test
	public void GivenShortDistanceAndMinutes_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		CabInvoiceService CIS = new CabInvoiceService();
		double distance = 0.1;
		double minutes = 2;
		double fare = CIS.getFare(distance, minutes);
		Assert.assertEquals(5, fare, 0.01);
	}

}
