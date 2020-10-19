package com.capgemimi.summary;

public class InvoiceSummary {
	private int noOfRides;
	private double totalFare;
	private double avgFarePerRide;

	public InvoiceSummary(int noOfRides, double totalFare) {
		super();
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.avgFarePerRide = totalFare / noOfRides;
	}

	public int getNoOfRides() {
		return noOfRides;
	}

	public void setNoOfRides(int noOfRides) {
		this.noOfRides = noOfRides;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public double getAvgFarePerRide() {
		return avgFarePerRide;
	}

	public void setAvgFarePerRide(double avgFarePerRide) {
		this.avgFarePerRide = avgFarePerRide;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(avgFarePerRide) != Double.doubleToLongBits(other.avgFarePerRide))
			return false;
		if (noOfRides != other.noOfRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InvoiceSummary [noOfRides=" + noOfRides + ", totalFare=" + totalFare + ", avgFarePerRide="
				+ avgFarePerRide + "]";
	}

}
