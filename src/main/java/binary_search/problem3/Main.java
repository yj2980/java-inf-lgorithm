package binary_search.problem3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		int c = main.readNumber();
		List<Integer> coordinate = main.createList(n);

		main.binarySearch(coordinate, c);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> createList(int n) {
		List<Integer> coordinate = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			coordinate.add(readNumber());
		}

		return coordinate;
	}

	private void binarySearch(List<Integer> stable, int horse) {
		int result = 0;

		stable.sort(Comparator.naturalOrder());

		int left = stable.get(0);
		int right = stable.get(stable.size() - 1);

		while (left <= right) {
			int mid = (left + right) / 2;

			if (count(stable, mid) >= horse) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		printResult(result);
	}

	private int count(List<Integer> numbers, int distance) {
		int cnt = 1;
		int coordinate = numbers.get(0);

		for (int x : numbers) {
			if (x - coordinate >= distance) {
				cnt++;
				coordinate = x;
			}
		}

		return cnt;
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
