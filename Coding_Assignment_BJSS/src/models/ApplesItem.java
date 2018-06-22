package models;

import java.util.ArrayList;

import mainpackage.BasketItems;

public class ApplesItem extends BasketItems {

	private int applesQuantity;
	private double applesPrice = 1.00;

	public ApplesItem(int quantity) {
		this.applesQuantity = quantity;

	}

	/* Find the quantity of apples by iterating on the itemsAddedByUser list */
	public int findApplesQuantity(ArrayList<String> itemsAddedByUser) {
		int apples = 0;

		for (int i = 0; i < itemsAddedByUser.size(); i++) {

			/* For every item add its price to the subtotal */
			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("apples")) {

				apples++;
			}

		}
		/* set the quantity */
		setApplesQuantity(apples);

		return apples;
	}

	/* Getters and setters */
	public int setApplesQuantity(int quantity) {

		return this.applesQuantity;
	}

	public double getApplesPrice() {

		return this.applesPrice;
	}

	public int getApplesQuantity() {

		return this.applesQuantity;
	}
}
