package models;
import java.util.ArrayList;

import mainpackage.BasketItems;

public class BreadItem extends BasketItems {

	private int breadQuantity;
	private double breadPrice = 0.8;

	public BreadItem(int quantity) {
		this.breadQuantity = quantity;

	}

	/* Find the quantity of bread by iterating on the itemsAddedByUser list */
	public int findBreadQuantity(ArrayList<String> itemsAddedByUser) {
		int bread = 0;

		for (int i = 0; i < itemsAddedByUser.size(); i++) {

			/* For every item add its price to the subtotal */
			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("bread")) {

				bread++;
			}

		}
		/* set the bread quantity */
		setBreadQuantity(bread);

		return bread;
	}

	public int setBreadQuantity(int quantity) {

		return this.breadQuantity;
	}

	/* Getters and setters */
	public double getBreadPrice() {

		return this.breadPrice;
	}

	public int getBreadQuantity() {

		return this.breadQuantity;
	}
}
