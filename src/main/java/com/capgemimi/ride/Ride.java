package com.capgemimi.ride;

public class Ride {
	private double distance;
	private double minutes;

	public Ride(double distance, double minutes) {
		super();
		this.distance = distance;
		this.minutes = minutes;
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
