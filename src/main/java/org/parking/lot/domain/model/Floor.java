package org.parking.lot.domain.model;

import java.util.List;
import java.util.Optional;

public class Floor {

	private Integer floorNumber;
	private Boolean isFloorFull;
	private List<ParkingSpot> parkingSpotList;

	public Floor(Integer floorNumber, List<ParkingSpot> parkingSpotList) {
		this.floorNumber = floorNumber;
		this.isFloorFull = false;
		this.parkingSpotList = parkingSpotList;
	}

	public void displayFloorStatus() {

		if (Boolean.TRUE.equals(this.isFloorFull)) {
			DisplayBoard.showMessage("Floor parking is full");
			return;
		}

		Optional<ParkingSpot> availableParkingSlot = this.parkingSpotList.stream()
			.filter(parkingSpot -> !parkingSpot.getOccupied()).findFirst();

		availableParkingSlot.ifPresent(
			slot -> DisplayBoard.showMessage(slot.getSerialNumber().toString() + "is available"));
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public Boolean getFloorFull() {
		return isFloorFull;
	}

	public List<ParkingSpot> getParkingSpotList() {
		return parkingSpotList;
	}

	public void park(Vehicle vehicle) {
		Optional<ParkingSpot> availableParkingSlot = this.parkingSpotList.stream()
			.filter(parkingSpot -> (!parkingSpot.getOccupied()) && parkingSpot.getParkingSpotSize()
				.equals(vehicle.getVehicleSize().toParkingSpotSize()))
			.findFirst();

		availableParkingSlot.ifPresent(slot -> {
			slot.setOccupied(true);
			slot.setVehicle(vehicle);
		});

	}
}
