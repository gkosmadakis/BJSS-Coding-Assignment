package mainpackage;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class BasketMain {

	public static ArrayList<String> itemsDefined;
	public static ArrayList<String> itemsAddedByUser;

	public static Map<Double, String> discountAndOffers;

	private static String discountFound;
	public static Double totalDiscount;

	public static void main(String[] args) {

		/*
		 * this is the arraylist where items are defined
		 */
		itemsDefined = new ArrayList<String>();
		itemsDefined.add("Soup");
		itemsDefined.add("Bread");
		itemsDefined.add("Milk");
		itemsDefined.add("Apples");
		/*
		 * this is the arraylist where i store the items that the user has typed
		 */
		itemsAddedByUser = new ArrayList<String>();

		/* create a scanner so we can read the command-line input */
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter your items: ");
		/*
		 * Iterate through the line added by user. If the line does not start
		 * with PriceBasket then show an error
		 */
		while (scanner.hasNextLine()) {

			if (!scanner.next().equals("PriceBasket")) {

				System.out.print("Wrong input, your line should start with the word PriceBasket");
				break;
			}

			/* A second scanner for every item added by user */
			Scanner wordScanner = new Scanner(scanner.nextLine());

			while (wordScanner.hasNext()) {

				String itemAddedByUser = wordScanner.next();
				/*
				 * if a user adds an item that does not belong in the item list
				 * i.e. Oranges then show an error. The items added by user are
				 * not case sensitive
				 */
				if (!itemsDefined.toString().toLowerCase().contains(itemAddedByUser.toLowerCase())) {

					System.out.print("Wrong input, You entered an item that does not exist" + "\n");
					break;
				}

				else {
					/*
					 * if everything is added correctly add every item in the
					 * arraylist itemsAddedByUser
					 */
					itemsAddedByUser.add(itemAddedByUser);

				}

			}
			wordScanner.close();

			BasketItems items = new BasketItems();
			/*
			 * Calculate the subtotal. Takes the arraylist added by user as a
			 * parameter
			 */
			System.out.println("Subtotal: £" + String.format("%.2f", items.CalculateSubtotal(itemsAddedByUser)));

			/*
			 * Calculate the offers. Takes the itemsAddedByUser as a parameter
			 */
			items.CalculateSpecialOffers(itemsAddedByUser);

			/*
			 * Get from the map discountAndOffers the discountFound which is a
			 * string and is the type of discount i.e Apples 10% off and the
			 * totalDiscount which is the discount number as a double
			 */
			for (Map.Entry<Double, String> entry : discountAndOffers.entrySet()) {

				discountFound = entry.getValue();

				totalDiscount = entry.getKey();
			}

			int totalDiscountInt = 0;

			/*
			 * this is for formatting for example the 0.10 to be displayed as
			 * -10p
			 */
			if (totalDiscount < 1 && totalDiscount > 0) {

				totalDiscountInt = (int) (totalDiscount * 100);

				System.out.println(discountFound + ": " + "-" + totalDiscountInt + "p");
			}

			/*
			 * if there is no discount then show the discount found type which
			 * is no offers available
			 */
			else if (totalDiscount == 0) {

				System.out.println(discountFound);
			}

			/* Calculate and show the Total */
			System.out.println("Total: £" + String.format("%.2f", items.CalculateTotal(itemsAddedByUser, totalDiscount)));
		}

		scanner.close();

	}

}
