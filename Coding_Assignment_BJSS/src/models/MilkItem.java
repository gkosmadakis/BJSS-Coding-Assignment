package models;
import mainpackage.BasketItems;

public class MilkItem extends BasketItems {

	private int milkQuantity;
	private double milkPrice = 1.30;

	public MilkItem(int quantity) {
		this.milkQuantity = quantity;

	}

	/* Getters and setters */ /* No need to find quantity for Milk */
	public double getMilkPrice() {

		return this.milkPrice;
	}

	public int getMilkQuantity() {

		return this.milkQuantity;
	}
}
