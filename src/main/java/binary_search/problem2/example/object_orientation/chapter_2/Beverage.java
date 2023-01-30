package example.object_orientation.chapter_2;

public class Beverage {

	private double quantity;


	public Beverage(double quantity) {
		this.quantity = quantity;
	}
	public void changeAmountOfBeverage(double amount) {
		this.quantity = quantity - amount;
	}
}
