package com.capgemimi.invoiceservice;

import java.util.List;

import com.capgemimi.data.RideRepository;
import com.capgemimi.ride.Ride;
import com.capgemimi.summary.InvoiceSummary;

public class CabInvoiceService {

	private RideRepository rideRepository;

	public CabInvoiceService(RideRepository rideRepository) {
		super();
		this.rideRepository = rideRepository;
	}

	// Method to get invoice summary of a ride array
	public InvoiceSummary getFare(Ride[] rides) {
		double totalfare = 0.0;
		for (Ride ride : rides) {
			totalfare += ride.getRideType().getFare(ride.getDistance(), ride.getMinutes());
		}
		return new InvoiceSummary(rides.length, totalfare);
	}

	// Internal private method to calculate fare and generate invoice summary of
	// ride list
	private InvoiceSummary getFare(List<Ride> ridelist) {
		double totalfare = 0.0;
		for (Ride ride : ridelist) {
			totalfare += ride.getRideType().getFare(ride.getDistance(), ride.getMinutes());
		}
		return new InvoiceSummary(ridelist.size(), totalfare);
	}

	// Method to get the invoice summary of a particular user id
	public InvoiceSummary getInvoiceSummaryForAnId(int id) {
		return (rideRepository.getRides(id) == null) ? null : getFare(rideRepository.getRides(id));
	}

	// Method to add rides to a particular User Id
	public void addRides(int i, Ride[] rides) {
		this.rideRepository.addRideDetailsForAnId(i, rides);
	}

	// Getters & Setters
	public RideRepository getRideRepository() {
		return rideRepository;
	}

	public void setRideRepository(RideRepository rideRepository) {
		this.rideRepository = rideRepository;
	}

}
