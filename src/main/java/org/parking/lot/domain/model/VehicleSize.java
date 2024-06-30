package org.parking.lot.domain.model;

public enum VehicleSize {
	LARGE,
	MEDIUM,
	SMALL;

	public ParkingSpotSize toParkingSpotSize() {
		return switch (this) {
			case LARGE -> ParkingSpotSize.LARGE;
			case MEDIUM -> ParkingSpotSize.MEDIUM;
			case SMALL -> ParkingSpotSize.SMALL;
			default -> throw new IllegalArgumentException("Unknown VehicleSize: " + this);
		};
	}
}
