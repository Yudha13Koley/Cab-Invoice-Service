package com.capgemimi.ride;

public class Ride {
	private double distance;
	private double minutes;
	private RideType rideType;

	public enum RideType {
		NORMAL_RIDE, PREMIUM_RIDE
	}

	public Ride(double distance, double minutes, RideType type) {
		super();
		this.distance = distance;
		this.minutes = minutes;
		this.rideType = type;
	}

	public RideType getRideType() {
		return rideType;
	}

	public void setRideType(RideType rideType) {
		this.rideType = rideType;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getMinutes() {
		return minutes;
	}

	public void setMinutes(double minutes) {
		this.minutes = minutes;
	}

}
