package binary_search.problem2.example.object_orientation.chapter_2;

public class Alice {

	private int height;
	private String location;

	private void changeLocation() {
		if (height > 40) {
			location = "통로";
		}
		if (height >= 40) {
			location = "정원";
		}
	}

	public double drunken() {
		getShorterHeight();
		changeLocation();

		return 0.5;
	}

	private void getShorterHeight() {
		this.height = 40;
	}

	private void getTaller() {
		this.height = 130;
	}
}
