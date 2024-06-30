package org.parking.lot.domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ParkingLot {

	private final Map<ParkingSpotSize, Integer> priceList;
	private final List<Floor> floorList;
	private final List<Ticket> ticketList;

	public ParkingLot(List<Floor> floorList) {
		this.floorList = floorList;
		this.priceList = new HashMap<>();
		this.priceList.put(ParkingSpotSize.LARGE, 1000);
		this.priceList.put(ParkingSpotSize.MEDIUM, 500);
		this.priceList.put(ParkingSpotSize.SMALL, 250);
		this.ticketList = new ArrayList<>();
	}

	public void createTicket(Vehicle vehicle) {
		Boolean isFull = this.isParkingLotFull();

		if (!Boolean.TRUE.equals(isFull)) {
			Ticket ticket = new Ticket(vehicle);
			this.ticketList.add(ticket);
			return;
		}

		System.out.println("The parking lot is full.");

		Optional<Floor> groundFloor = this.floorList.stream()
			.filter(floor -> floor.getFloorNumber().equals(0))
			.findFirst();

		groundFloor.ifPresent(Floor::displayFloorStatus);
	}

	public void deleteTicket(Vehicle vehicle) {
		Optional<Ticket> assignedTicket = this.ticketList.stream().filter(ticket ->
			vehicle.equals(ticket.getVehicle()) && ticket.getStatus().equals(TicketStatus.ACTIVE)
		).findFirst();

		assignedTicket.ifPresent(ticket -> ticket.setStatus(TicketStatus.CLOSE));
	}

	public Integer getAmount(VehicleSize vehicleSize) {
		return this.priceList.get(vehicleSize.toParkingSpotSize());
	}

	private Boolean isParkingLotFull() {
		return floorList.stream()
			.allMatch(Floor::getFloorFull);
	}

	public void park(Vehicle vehicle) {
		Optional<Floor> availableFloor = this.floorList.stream()
			.filter(floor -> !floor.getFloorFull())
			.findFirst();

		availableFloor.ifPresent(aFloor -> aFloor.park(vehicle));
	}

	public void unPark(Vehicle vehicle) {

		for (Floor floor : floorList) {
			for (ParkingSpot parkingSpot : floor.getParkingSpotList()) {
				if (vehicle.equals(parkingSpot.getVehicle())) {
					parkingSpot.setVehicle(null);
					parkingSpot.setOccupied(false);
					return;
				}
			}
		}
	}
}
