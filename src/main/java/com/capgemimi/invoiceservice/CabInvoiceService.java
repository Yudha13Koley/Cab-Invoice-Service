package com.capgemimi.invoiceservice;

public class CabInvoiceService {

	private static final double CHARGE_PER_KM =10.0;
	private static final double CHARGE_PER_MINUTE = 1.0;
	private static final double MIN_FARE = 5.0;
	

	public double getFare(double distance, double minutes) {
		double fare= CHARGE_PER_KM*distance+CHARGE_PER_MINUTE*minutes;
		return(fare<MIN_FARE)?MIN_FARE:fare;
	}

}
