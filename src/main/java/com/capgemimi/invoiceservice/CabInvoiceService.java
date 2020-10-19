package com.capgemimi.invoiceservice;

import com.capgemimi.ride.Ride;
import com.capgemimi.summary.InvoiceSummary;

public class CabInvoiceService {

	private static final double CHARGE_PER_KM =10.0;
	private static final double CHARGE_PER_MINUTE = 1.0;
	private static final double MIN_FARE = 5.0;
	

	public double getFare(double distance, double minutes) {
		double fare= CHARGE_PER_KM*distance+CHARGE_PER_MINUTE*minutes;
		return(fare<MIN_FARE)?MIN_FARE:fare;
	}


	public InvoiceSummary getFare(Ride[] rides) {
		double totalfare=0.0;
		for(Ride ride:rides) {
			totalfare+=this.getFare(ride.getDistance(),ride.getMinutes());
		}
		return new InvoiceSummary(rides.length,totalfare);
	}

}
