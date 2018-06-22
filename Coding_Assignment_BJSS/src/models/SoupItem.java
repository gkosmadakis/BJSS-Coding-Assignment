package models;
import java.util.ArrayList;

import mainpackage.BasketItems;

public class SoupItem extends BasketItems {

	private int soupQuantity;
	private double soupPrice = 0.65;

	public SoupItem(int quantity) {
		this.soupQuantity = quantity;

	}

	/* Find the quantity of soups by iterating on the itemsAddedByUser list */
	public int findSoupQuantity(ArrayList<String> itemsAddedByUser) {
		int soup = 0;

		for (int i = 0; i < itemsAddedByUser.size(); i++) {

			/* For every item add its price to the subtotal */
			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("soup")) {

				soup++;
			}

		}
		/* set the soup quantity */
		setSoupQuantity(soup);

		return soup;
	}

	public int setSoupQuantity(int quantity) {

		return this.soupQuantity;
	}

	/* Getters and setters */
	public double getSoupPrice() {

		return this.soupPrice;
	}

	public int getSoupQuantity() {

		return this.soupQuantity;
	}
}
