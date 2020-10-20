package com.capgemimi.ride;

public class Ride {
	private double distance;
	private double minutes;
	private RideType rideType;

	public enum RideType {
		NORMAL_RIDE(10.0, 1.0, 5.0), PREMIUM_RIDE(15.0, 2.0, 20.0);

		private final double CHARGE_PER_KM;
		private final double CHARGE_PER_MINUTE;
		private final double MIN_FARE;

		RideType(double d, double e, double f) {
			this.CHARGE_PER_KM = d;
			this.CHARGE_PER_MINUTE = e;
			this.MIN_FARE = f;
		}

		public double getFare(double distance, double minutes) {
			double fare = CHARGE_PER_KM * distance + CHARGE_PER_MINUTE * minutes;
			return (fare < MIN_FARE) ? MIN_FARE : fare;
		}
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
