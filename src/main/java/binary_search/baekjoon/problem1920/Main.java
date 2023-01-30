package binary_search.baekjoon.problem1920;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		final int N = main.readNumber();
		List<Integer> first = main.createList(N);
		final int M = main.readNumber();
		List<Integer> second = main.createList(M);

		main.solve(first, second);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> createList(int N) {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			numbers.add(readNumber());
		}

		return numbers;
	}

	private void solve(List<Integer> first, List<Integer> second) {
		first.sort(Comparator.naturalOrder());

		for (int x : second) {
			printResult(binarySearch(x, 0, first.size() - 1, first));
		}
	}

	private int binarySearch(int key, int lf, int rf, List<Integer> numbers) {
		int mid;

		while (lf <= rf) {
			mid = (lf + rf) / 2;

			if (key == numbers.get(mid)) {
				return 1;
			} else if (key > numbers.get(mid)) {
				lf = mid + 1;
			} else {
				rf = mid - 1;
			}
		}

		return 0;
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
