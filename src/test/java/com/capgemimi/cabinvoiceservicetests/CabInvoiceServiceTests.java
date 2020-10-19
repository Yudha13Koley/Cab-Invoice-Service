package com.capgemimi.cabinvoiceservicetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemimi.invoiceservice.CabInvoiceService;
import com.capgemimi.ride.Ride;
import com.capgemimi.summary.InvoiceSummary;

public class CabInvoiceServiceTests {
	CabInvoiceService cabInvoiceService;

	@Before
	public void init() {
		cabInvoiceService = new CabInvoiceService();
	}

	@Test
	public void GivenDistanceAndMinutes_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		double distance = 2.0;
		double minutes = 5;
		double fare = cabInvoiceService.getFare(distance, minutes);
		Assert.assertEquals(25, fare, 0.01);
	}

	@Test
	public void GivenShortDistanceAndMinutes_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		double distance = 0.1;
		double minutes = 2;
		double fare = cabInvoiceService.getFare(distance, minutes);
		Assert.assertEquals(5, fare, 0.01);
	}

	@Test
	public void GivenMultipleRides_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2, 5), new Ride(0.1, 2) };
		double fare = cabInvoiceService.getFare(rides).getTotalFare();
		Assert.assertEquals(30, fare, 0.01);
	}
	
	@Test
	public void GivenMultipleRides_WhenGeneratedInvoice_ShouldReturnSummary() {
		Ride[] rides = { new Ride(2, 5), new Ride(0.1, 2) };
		InvoiceSummary summary = cabInvoiceService.getFare(rides);
		InvoiceSummary expectedSummary=new InvoiceSummary(2,30);
		Assert.assertEquals(expectedSummary,summary);
	}

}
