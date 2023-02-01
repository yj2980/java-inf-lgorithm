package binary_search.baekjoon.problem1654;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int k = main.readNumber();
		int n = main.readNumber();

		List<Integer> numbers = main.createNumbers(k);
		numbers.sort(Comparator.naturalOrder());
		main.binarySearch(numbers, n);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> createNumbers(int n) {
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			numbers.add(readNumber());
		}

		return numbers;
	}

	private void binarySearch(List<Integer> lan, int n) {
		long result = 0;
		long left = 1;
		long right = lan.get(lan.size() - 1);


		while (left <= right) {
			long mid = (left + right) / 2;


			if (cuttingRanLine(lan, mid) >= n) {
				result = mid;
				left = mid + 1;
				continue;
			}
			right = mid - 1;
		}

		printResult(result);
	}

	private int cuttingRanLine(List<Integer> lan, long cutting) {
		int cnt = 0;

		for (int line : lan) {
			cnt += (line / cutting);
		}
		return cnt;
	}

	private void printResult(long result) {
		System.out.println(result);
	}
}
