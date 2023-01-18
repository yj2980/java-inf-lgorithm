package sorting.problem4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int cache = main.readNumber();
		int length = main.readNumber();

		List<Integer> numbers = main.createList(length);
		main.printResult(main.LeastRecentlyUsed(cache, numbers));
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

	private Queue<Integer> LeastRecentlyUsed(int cache, List<Integer> numbers) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numbers.size(); i++) {
			if (queue.size() >= cache) {
				queue.poll();
			}
			if (queue.contains(numbers.get(i))) {
				queue.remove(numbers.get(i));
				queue.add(numbers.get(i));
			} else {
				queue.add(numbers.get(i));
			}
		}

		return queue;
	}

	private void printResult(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();

		while (!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
