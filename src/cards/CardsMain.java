package cards;

import java.util.Scanner;

public class CardsMain {

	public static void main(String args[]) {

		@SuppressWarnings("resource")
		// for input string
		Scanner sc = new Scanner(System.in);

		CardIntf c = new CardImpl();

		System.out.println("please enter string :");

		// to read line
		String string = sc.nextLine();

		// call method get response true or falue
		System.out.println(c.checkSequence(string));

	}

}
