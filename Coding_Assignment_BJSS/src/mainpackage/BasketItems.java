package mainpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import interfaces.BasketInterface;
import models.ApplesItem;
import models.BreadItem;
import models.MilkItem;
import models.SoupItem;

public class BasketItems extends BasketMain implements BasketInterface {

	private double soupPrice;
	private double breadPrice;
	private double milkPrice;
	private double applesPrice;

	private int applesQuantity;
	private int breadQuantity;
	private int soupQuantity;
	private int milkQuantity;

	public BasketItems() {

	}

	public double CalculateSubtotal(ArrayList<String> itemsAddedByUser) {

		double subtotal = 0.0;
		/*
		 * Create objects from the subclasses, find price and quantity and set
		 * it to the variables of this class
		 */
		SoupItem soupItem = new SoupItem(soupQuantity);
		this.soupPrice = soupItem.getSoupPrice();
		this.soupQuantity = soupItem.findSoupQuantity(itemsAddedByUser);

		BreadItem breadItem = new BreadItem(breadQuantity);
		this.breadPrice = breadItem.getBreadPrice();
		this.breadQuantity = breadItem.findBreadQuantity(itemsAddedByUser);

		MilkItem milkItem = new MilkItem(milkQuantity);
		this.milkPrice = milkItem.getMilkPrice();

		ApplesItem applesItem = new ApplesItem(applesQuantity);
		this.applesPrice = applesItem.getApplesPrice();
		this.applesQuantity = applesItem.findApplesQuantity(itemsAddedByUser);

		/* Iterate through the list added by user */
		for (int i = 0; i < itemsAddedByUser.size(); i++) {

			/* For every item add its price to the subtotal */
			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("soup")) {

				subtotal += soupPrice;
			}

			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("bread")) {

				subtotal += breadPrice;
			}

			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("milk")) {

				subtotal += milkPrice;
			}

			if (itemsAddedByUser.get(i).toString().toLowerCase().equals("apples")) {

				subtotal += applesPrice;
			}

		}

		return subtotal;

	}

	public Map<Double, String> CalculateSpecialOffers(ArrayList<String> itemsAddedByUser) {
		/*
		 * initialise a Map that will store a double which will be the discount
		 * i.e 0.1 and a string which will be the type of discount i.e Apples
		 * 10% off
		 */
		discountAndOffers = new HashMap<Double, String>();

		double totalDiscount = 0.0;
		double applesDiscount = 0.0;
		double breadDiscount = 0.0;

		/*
		 * If it contains apples initialise and calculate the apples discount
		 */
		if (applesQuantity > 0) {

			applesDiscount = 0.1;

			applesDiscount = applesDiscount * applesPrice;
		}

		/*
		 * if the soup quantity is 2 and the bread quantity is one then
		 * initialise and calculate the bread discount. At this point i make the
		 * assumption that 4 soups is not giving twice the discount in breads
		 */
		if (soupQuantity >= 2 && breadQuantity >= 1) {

			breadDiscount = 0.5;

			breadDiscount = breadDiscount * breadPrice;

		}
		/* calculate total discount */
		totalDiscount = applesDiscount + breadDiscount;

		/*
		 * add to the map total discount as a double and a string of the type of
		 * discount
		 */
		if (applesDiscount > 0 && breadDiscount == 0) {

			discountAndOffers.put(totalDiscount, "Apples 10% off");
		}

		else if (applesDiscount == 0 && breadDiscount > 0) {

			discountAndOffers.put(totalDiscount, "Bread discount half price");
		}

		else if (applesDiscount > 0 && breadDiscount > 0) {

			discountAndOffers.put(totalDiscount, "Apples 10% off and Bread discount half price");
		}

		else if (applesDiscount == 0 && breadDiscount == 0) {

			discountAndOffers.put(totalDiscount, "no offers available");
		}

		return discountAndOffers;
	}

	public Double CalculateTotal(ArrayList<String> itemsAddedByUser, Double totalDiscount) {

		double total = 0.0;

		total = CalculateSubtotal(itemsAddedByUser) - totalDiscount;

		return total;

	}

}
