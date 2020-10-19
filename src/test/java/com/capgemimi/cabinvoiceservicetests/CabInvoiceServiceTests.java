package com.capgemimi.cabinvoiceservicetests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemimi.invoiceservice.CabInvoiceService;
import com.capgemimi.ride.Ride;
import com.capgemimi.ride.Ride.RideType;
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
		double fare = cabInvoiceService.getFare(distance, minutes, RideType.NORMAL_RIDE);
		Assert.assertEquals(25, fare, 0.01);
	}

	@Test
	public void GivenShortDistanceAndMinutes_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		double distance = 0.1;
		double minutes = 2;
		double fare = cabInvoiceService.getFare(distance, minutes, RideType.NORMAL_RIDE);
		Assert.assertEquals(5, fare, 0.01);
	}

	@Test
	public void GivenMultipleRides_WhenGeneratedInvoice_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2, 5, RideType.NORMAL_RIDE), new Ride(0.1, 2, RideType.NORMAL_RIDE) };
		double fare = cabInvoiceService.getFare(rides).getTotalFare();
		Assert.assertEquals(30, fare, 0.01);
	}

	@Test
	public void GivenMultipleRides_WhenGeneratedInvoice_ShouldReturnSummary() {
		Ride[] rides = { new Ride(2, 5, RideType.NORMAL_RIDE), new Ride(0.1, 2, RideType.NORMAL_RIDE) };
		InvoiceSummary summary = cabInvoiceService.getFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void GivenMultipleRidesForAnID_WhenGeneratedInvoice_ShouldReturnSummaryForThatId() {
		Ride[] rides = { new Ride(2, 5, RideType.NORMAL_RIDE), new Ride(0.1, 2, RideType.NORMAL_RIDE) };
		cabInvoiceService.addRideDetailsForAnId(1, rides);
		InvoiceSummary summary = cabInvoiceService.getInvoiceSummaryForAnId(1);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void GivenMultipleRidesForPremiumRides_WhenGeneratedInvoice_ShouldReturnSummaryForThatId() {
		Ride[] rides = { new Ride(2, 5, RideType.PREMIUM_RIDE), new Ride(0.1, 2, RideType.PREMIUM_RIDE) };
		cabInvoiceService.addRideDetailsForAnId(1, rides);
		InvoiceSummary summary = cabInvoiceService.getInvoiceSummaryForAnId(1);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 60);
		Assert.assertEquals(expectedSummary, summary);
	}

}
