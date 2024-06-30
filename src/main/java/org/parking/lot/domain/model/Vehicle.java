package org.parking.lot.domain.model;

import java.util.Objects;

public class Vehicle {
	private String vehicleNumber;

	public VehicleSize getVehicleSize() {
		return vehicleSize;
	}

	private VehicleSize vehicleSize;

	public Vehicle(String vehicleNumber, VehicleSize vehicleSize) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleSize = vehicleSize;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Vehicle vehicle = (Vehicle) o;
		return Objects.equals(vehicleNumber, vehicle.vehicleNumber)
			&& vehicleSize == vehicle.vehicleSize;
	}

	@Override
	public int hashCode() {
		return Objects.hash(vehicleNumber, vehicleSize);
	}
}
