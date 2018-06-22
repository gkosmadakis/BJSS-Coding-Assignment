import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Map;

import org.junit.jupiter.api.Test;

import mainpackage.BasketItems;

class TestBasketItems {

	String discountFound = null;
	Double totalDiscount = 0.0;

	/*
	 * These three tests are for three scenarios. 1st the user purchases all 4
	 * items so we have one offer from apples available. 2nd the user purchases
	 * all 4 items plus an extra soup so we have both offers for apples and for
	 * bread available. 3rd the user purchases three items soup milk and bread
	 * so no offers are available
	 */
	@Test
	public void testAllItemsPurchasedApplesOffer() {

		BasketItems items = new BasketItems();

		ArrayList<String> itemsAddedByUser = new ArrayList<String>();

		setupForAllItemsPurchasedApplesOffer(itemsAddedByUser);

		assertEquals(3.75, items.CalculateSubtotal(itemsAddedByUser));

		for (Map.Entry<Double, String> entry : items.CalculateSpecialOffers(itemsAddedByUser).entrySet()) {

			discountFound = entry.getValue();

			totalDiscount = entry.getKey();
		}

		assertEquals("Apples 10% off", discountFound);
		assertEquals(Double.valueOf(0.10), totalDiscount);
		assertEquals(Double.valueOf(3.65), items.CalculateTotal(itemsAddedByUser, totalDiscount));
	}

	@Test
	public void testTwoSoupsPurchasedTwoOffersMade() {

		BasketItems items = new BasketItems();

		ArrayList<String> itemsAddedByUser = new ArrayList<String>();

		setupForTwoSoupsPurchasedTwoOffersMade(itemsAddedByUser);

		assertEquals(4.4, items.CalculateSubtotal(itemsAddedByUser));

		for (Map.Entry<Double, String> entry : items.CalculateSpecialOffers(itemsAddedByUser).entrySet()) {

			discountFound = entry.getValue();

			totalDiscount = entry.getKey();
		}

		assertEquals("Apples 10% off and Bread discount half price", discountFound);
		assertEquals(Double.valueOf(0.50), totalDiscount);
		assertEquals("3.90", String.format("%.2f", items.CalculateTotal(itemsAddedByUser, totalDiscount)));
	}

	@Test
	public void testNoOffersAvailable() {

		BasketItems items = new BasketItems();

		ArrayList<String> itemsAddedByUser = new ArrayList<String>();

		setupForNoOffersAvailable(itemsAddedByUser);

		assertEquals(2.75, items.CalculateSubtotal(itemsAddedByUser));

		for (Map.Entry<Double, String> entry : items.CalculateSpecialOffers(itemsAddedByUser).entrySet()) {

			discountFound = entry.getValue();

			totalDiscount = entry.getKey();
		}

		assertEquals("no offers available", discountFound);
		assertEquals(Double.valueOf(0.0), totalDiscount);
		assertEquals("2.75", String.format("%.2f", items.CalculateTotal(itemsAddedByUser, totalDiscount)));
	}

	public static void setupForAllItemsPurchasedApplesOffer(ArrayList<String> itemsAddedByUser) {

		itemsAddedByUser.add("Soup");
		itemsAddedByUser.add("Bread");
		itemsAddedByUser.add("Milk");
		itemsAddedByUser.add("Apples");
	}

	public static void setupForTwoSoupsPurchasedTwoOffersMade(ArrayList<String> itemsAddedByUser) {

		itemsAddedByUser.add("Soup");
		itemsAddedByUser.add("Soup");
		itemsAddedByUser.add("Bread");
		itemsAddedByUser.add("Milk");
		itemsAddedByUser.add("Apples");
	}

	public static void setupForNoOffersAvailable(ArrayList<String> itemsAddedByUser) {

		itemsAddedByUser.add("Soup");
		itemsAddedByUser.add("Bread");
		itemsAddedByUser.add("Milk");
	}

}
