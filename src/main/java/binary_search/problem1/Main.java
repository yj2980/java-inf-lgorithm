package binary_search.problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int size = main.readNumber();
		int key = main.readNumber();
		List<Integer> numbers = main.createList(size);

		main.solution(numbers, key);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> createList(int n) {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			numbers.add(readNumber());
		}

		return numbers;
	}

	private void solution(List<Integer> numbers, int key) {
		numbers.sort(Comparator.naturalOrder());
		int result = binarySearch(key, 0, numbers.size() - 1, numbers) + 1;

		printResult(result);
	}

	private int binarySearch(int key, int low, int high, List<Integer> numbers) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (key == numbers.get(mid)) {
				return mid;
			} else if (key < numbers.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		// false
		return -1;
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
