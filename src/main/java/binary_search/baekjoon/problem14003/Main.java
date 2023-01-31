package binary_search.baekjoon.problem14003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		List<Integer> numbers = main.createList(n);

		main.solve(numbers);
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

	public void solve(List<Integer> numbers) {
		// time
		long start = System.currentTimeMillis();

		List<Integer> lis = new ArrayList<>();

		lis.add(numbers.get(0));
		for (int i = 1; i < numbers.size(); i++) {

			if (lis.get(lis.size() - 1) < numbers.get(i)) {
				lis.add(numbers.get(i));
				continue;
			}
			binarySearch(lis, numbers.get(i));
		}

		printResult(lis, lis.size());

		// time
		long end = System.currentTimeMillis();
		System.out.println("time : " + ((end - start) / 1000.0));
	}

	private void binarySearch(List<Integer> lis , int target) {
		int lf = 0;
		int rf = lis.size() - 1;

		while (lf < rf) {
			int mid = (lf + rf) / 2;

			if (lis.get(mid) < target) {
				lf = mid + 1;
			} else {
				rf = mid;
			}
		}

		lis.set(lf, target);
	}

	private void printResult(List<Integer> numbers, int result) {
		System.out.println(result);
		numbers.forEach(v -> System.out.print(v + " "));
	}

}
