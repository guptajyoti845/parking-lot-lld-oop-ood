package org.parking.lot.domain.model;

public class ParkingSpot {

	private Boolean isOccupied;
	private final Integer serialNumber;
	private final ParkingSpotSize parkingSpotSize;
	private Vehicle vehicle;


	public ParkingSpot(Integer serialNumber, ParkingSpotSize parkingSpotSize) {
		this.serialNumber = serialNumber;
		this.parkingSpotSize = parkingSpotSize;
		this.isOccupied = false;
		this.vehicle = null;
	}

	public ParkingSpotSize getParkingSpotSize() {
		return parkingSpotSize;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public Boolean getOccupied() {
		return isOccupied;
	}

	public void setOccupied(Boolean occupied) {
		isOccupied = occupied;
	}

}
