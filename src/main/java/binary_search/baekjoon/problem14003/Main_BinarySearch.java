package binary_search.baekjoon.problem14003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main_BinarySearch {
	static Main_BinarySearch main = new Main_BinarySearch();

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
		long start = System.currentTimeMillis();

		List<Integer> lis = new ArrayList<>();
		List<Integer> index = new ArrayList<>();

		lis.add(numbers.get(0));
		for (int i = 1; i < numbers.size(); i++) {
			if (numbers.get(i - 1) < numbers.get(i)) {
				lis.add(numbers.get(i));
				index.add(lis.size() - 1);
			}
			if (numbers.get(i - 1) >= numbers.get(i)) {
				int right = binarySearch(lis, numbers.get(i));
				lis.set(right, numbers.get(i));
				index.add(right);
			}

		}

		printResult(index, numbers, lis.size() - 1);

		long end = System.currentTimeMillis();

		System.out.println("time : " + ((end - start) / 1000.0));
	}

	private void printResult(List<Integer> index ,List<Integer> numbers, int result) {
		System.out.println(result);

		Stack<Integer> stack = new Stack<>();

		int x = numbers.size() - 1;
		for (int i = numbers.size() - 1; i > 0; i--) {
			if (index.get(i) == x) {
				x--;
				stack.push(numbers.get(i));
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	private int binarySearch(List<Integer> numbers, int target) {
		int left = 1;
		int right = numbers.size() - 1;

		while (left < right) {
			int mid = (left + right) / 2;

			if (numbers.get(mid) > target) {
				right = mid;
			}
			if (numbers.get(mid) < target) {
				left = mid + 1;
			}
		}

		return right;
	}
}
