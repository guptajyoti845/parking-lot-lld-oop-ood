package org.parking.lot.domain.model;

public class Customer {

	private String name;
	private Vehicle vehicle;
	private Wallet wallet;

	public Customer(String name, Vehicle vehicle) {
		this.name = name;
		this.vehicle = vehicle;
		this.wallet = new Wallet();
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void pay(Integer amount) {
		if (this.wallet.getAmount() < amount) {
			throw new RuntimeException("Insufficient funds in wallet");
		}
		this.wallet.setAmount(this.wallet.getAmount() - amount);
	}
}
