package com.capgemimi.invoiceservice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.capgemimi.ride.Ride;
import com.capgemimi.ride.Ride.RideType;
import com.capgemimi.summary.InvoiceSummary;

public class CabInvoiceService {
	public Map<Integer, List<Ride>> rideRepository;

	public CabInvoiceService() {
		rideRepository = new HashMap<>();
	}

	private static final double CHARGE_PER_KM = 10.0;
	private static final double CHARGE_PER_MINUTE = 1.0;
	private static final double MIN_FARE = 5.0;
	private static final double PREMIUM_CHARGE_PER_KM = 15.0;
	private static final double PREMIUM_CHARGE_PER_MINUTE = 2.0;
	private static final double PREMIUM_MIN_FARE = 20.0;

	public double getFare(double distance, double minutes, RideType type) {
		if (type.equals(RideType.NORMAL_RIDE)) {
			double fare = CHARGE_PER_KM * distance + CHARGE_PER_MINUTE * minutes;
			return (fare < MIN_FARE) ? MIN_FARE : fare;
		}
		if (type.equals(RideType.PREMIUM_RIDE)) {
			double fare = PREMIUM_CHARGE_PER_KM * distance + PREMIUM_CHARGE_PER_MINUTE * minutes;
			return (fare < PREMIUM_MIN_FARE) ? PREMIUM_MIN_FARE : fare;
		}
		return 0;
	}

	public InvoiceSummary getFare(Ride[] rides) {
		double totalfare = 0.0;
		for (Ride ride : rides) {
			totalfare += this.getFare(ride.getDistance(), ride.getMinutes(), ride.getRideType());
		}
		return new InvoiceSummary(rides.length, totalfare);
	}

	public InvoiceSummary getFare(List<Ride> ridelist) {
		double totalfare = 0.0;
		for (Ride ride : ridelist) {
			totalfare += getFare(ride.getDistance(), ride.getMinutes(), ride.getRideType());
		}
		return new InvoiceSummary(ridelist.size(), totalfare);
	}

	public void addRideDetailsForAnId(int id, Ride[] ridearr) {
		if (rideRepository.containsKey(id)) {
			for (Ride r : ridearr) {
				rideRepository.get(id).add(r);
			}
		} else {
			rideRepository.put(id, new LinkedList<Ride>());
			rideRepository.get(id).addAll(Arrays.asList(ridearr));
		}
	}

	public InvoiceSummary getInvoiceSummaryForAnId(int id) {
		if (!rideRepository.containsKey(id))
			System.out.println("User Id Not Found");
		else
			return getFare(rideRepository.get(id));
		return null;
	}

}
