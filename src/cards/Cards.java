package cards;

import java.util.Scanner;

public class Cards {

	public static void main(String args[]) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		CardIntf c = new CardImpl();
		int i = 0;
		while (i < 100) {

			System.out.println("press stop to exit");
			System.out.println("please enter string :");

			String string = sc.nextLine();

			// condition to break the loop
			if (string.equalsIgnoreCase(Constants.STOP)) {
				break;
			}

			// call method get response true or falue
			System.out.println(c.checkSequence(string));

			i++;
		}
	}

}
