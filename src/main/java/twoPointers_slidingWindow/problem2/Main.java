package twoPointers_slidingWindow.problem2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Integer> answer = main.joinNumbers(main.readNumber(), main.readNumber());

		answer.forEach(v -> System.out.print(v + " "));
	}

	private List<Integer> readNumber() {
		List<Integer> numbers = new ArrayList<>();
		int length = Integer.parseInt(sc.next());

		for (int i = 0; i < length; i++) {
			numbers.add(Integer.parseInt(sc.next()));
		}

		return numbers;
	}

	private List<Integer> joinNumbers(List<Integer> first, List<Integer> second) {
		List<Integer> result = new ArrayList<>();
		first.addAll(second);
		first.sort(Comparator.naturalOrder());

		for (int i = 0; i < first.size() - 1; i++) {
			if (first.get(i).equals(first.get(i + 1))) {
				result.add(first.get(i));
			}
		}

		return result;
	}
}
