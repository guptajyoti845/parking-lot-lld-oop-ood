package org.parking.lot;

import java.util.ArrayList;
import java.util.List;
import org.parking.lot.domain.model.Customer;
import org.parking.lot.domain.model.Floor;
import org.parking.lot.domain.model.ParkingLot;
import org.parking.lot.domain.model.ParkingSpot;
import org.parking.lot.domain.model.ParkingSpotSize;
import org.parking.lot.domain.model.Vehicle;
import org.parking.lot.domain.model.VehicleSize;

public class Main {

	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle("DL 152", VehicleSize.MEDIUM);

		Customer customer = new Customer("Jyoti Gupta", vehicle);

		customer.getWallet().setAmount(2000);

		ParkingSpot parkingSpot1 = new ParkingSpot(1, ParkingSpotSize.MEDIUM);
		ParkingSpot parkingSpot2 = new ParkingSpot(2, ParkingSpotSize.MEDIUM);
		ParkingSpot parkingSpot3 = new ParkingSpot(3, ParkingSpotSize.MEDIUM);
		ParkingSpot parkingSpot4 = new ParkingSpot(4, ParkingSpotSize.MEDIUM);
		ParkingSpot parkingSpot5 = new ParkingSpot(5, ParkingSpotSize.MEDIUM);
		ParkingSpot parkingSpot6 = new ParkingSpot(6, ParkingSpotSize.MEDIUM);

		List<ParkingSpot> parkingSpotList1 = new ArrayList<>();
		parkingSpotList1.add(parkingSpot1);
		parkingSpotList1.add(parkingSpot2);
		parkingSpotList1.add(parkingSpot3);

		List<ParkingSpot> parkingSpotList2 = new ArrayList<>();
		parkingSpotList2.add(parkingSpot4);
		parkingSpotList2.add(parkingSpot5);
		parkingSpotList2.add(parkingSpot6);

		Floor floor1 = new Floor(0, parkingSpotList1);
		Floor floor2 = new Floor(1, parkingSpotList2);

		List<Floor> floorList = new ArrayList<>();
		floorList.add(floor1);
		floorList.add(floor2);

		ParkingLot parkingLot = new ParkingLot(floorList);

		parkingLot.createTicket(vehicle);
		parkingLot.park(vehicle);

		customer.pay(parkingLot.getAmount(vehicle.getVehicleSize()));
		parkingLot.unPark(vehicle);
		parkingLot.deleteTicket(vehicle);
	}
}
