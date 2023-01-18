package sorting.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		List<Integer> numbers = main.readHeightByStudent(n);

		main.isRight(numbers);
	}
	private int readNumber(){
		return Integer.parseInt(sc.next());
	}

	private List<Integer> readHeightByStudent(int n){
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			numbers.add(readNumber());
		}

		return numbers;
	}

	private void isRight(List<Integer> height) {
		int chulsoo = 0;
		int partner = 0;

		for (int i = 0; i < height.size() - 1; i++) {
			if (height.get(i) > height.get(i + 1)) {
				if (chulsoo == 0) {
					chulsoo = height.indexOf(height.get(i));
				}
				partner = i + 1;
			}
		}

		System.out.println(++chulsoo + " " + ++partner);
	}
}
