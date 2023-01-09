package example.object_orientation.chapter_2;

public class Controller {

	public void run() {

	}

	private void drinkBeverage() {
		Alice alice = new Alice();
		Beverage beverage = new Beverage(1);

		beverage.changeAmountOfBeverage(alice.drunken());
	}
}
