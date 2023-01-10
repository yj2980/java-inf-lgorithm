package twoPointers_slidingWindow.problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		main.joinNumbers(main.readNumber(), main.readNumber());
	}

	private List<Integer> readNumber() {
		List<Integer> numbers = new ArrayList<>();
		int length = Integer.parseInt(sc.next());

		for (int i = 0; i < length; i++) {
			numbers.add(Integer.parseInt(sc.next()));
		}

		return numbers;
	}

	private void joinNumbers(List<Integer> first, List<Integer> second) {
		first.addAll(second);
		first.sort(Comparator.naturalOrder());
		first.forEach(v -> System.out.print(v + " "));
	}
}
