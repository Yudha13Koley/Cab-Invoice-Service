package com.capgemimi.data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.capgemimi.ride.Ride;

public class RideRepository {
	private Map<Integer, List<Ride>> rideRepository;

	public RideRepository() {
		rideRepository = new HashMap<>();
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

	public List<Ride> getRides(int id) {
		if (!rideRepository.containsKey(id))
			System.out.println("User Id Not Found");
		else
			return rideRepository.get(id);
		return null;
	}

	// Getters & Setters
	public Map<Integer, List<Ride>> getRideRepository() {
		return rideRepository;
	}

	public void setRideRepository(Map<Integer, List<Ride>> rideRepository) {
		this.rideRepository = rideRepository;
	}
}
