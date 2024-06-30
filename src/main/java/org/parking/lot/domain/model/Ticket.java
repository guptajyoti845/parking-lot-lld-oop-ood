package org.parking.lot.domain.model;

public class Ticket {

	private Vehicle vehicle;
	private TicketStatus status;

	public Ticket(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.status = TicketStatus.ACTIVE;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}
}
