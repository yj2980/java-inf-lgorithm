package binary_search.baekjoon.problem2805;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = main.readNumber();
		int length = main.readNumber();

		List<Integer> wood = main.createList(N);

		main.binarySearch(wood, length);
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

	private void binarySearch(List<Integer> wood, int length) {
		int result = 0;
		
		int lf = 0;
		int rf = wood.stream().mapToInt(v -> v).max().getAsInt();

		while (lf <= rf) {
			int mid = (lf + rf) / 2;
			long total = cutWood(wood, mid);

			if (total >= length) {
				result = mid;
				lf = mid + 1;
			}
			if (total < length) {
				rf = mid - 1;
			}
		}

		printResult(result);
	}

	private long cutWood(List<Integer> wood, int cutter) {
		long sum = 0;

		for (int x : wood) {
			long length = x - cutter;

			if (length > 0) {
				sum += length;
			}
		}

		return sum;
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
