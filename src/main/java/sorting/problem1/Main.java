package sorting.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		List<Integer> numbers = main.createList(n);

		main.printResult(main.selectionSort(numbers));
	}

	private int readNumber(){
		return Integer.parseInt(sc.next());
	}

	private List<Integer> createList(int n){
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			numbers.add(readNumber());
		}

		return numbers;
	}

	private List<Integer> selectionSort(List<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) {
			int minIndex = findMinNumber(numbers, i);
			int tmp = numbers.get(minIndex);

			numbers.set(minIndex, numbers.get(i));
			numbers.set(i, tmp);
		}

		return numbers;
	}

	private int findMinNumber(List<Integer> numbers, int minIndex) {
		for (int i = minIndex + 1; i < numbers.size(); i++) {
			if (numbers.get(i) < numbers.get(minIndex)) {
				minIndex = i;
			}
		}

		return minIndex;
	}

	private void printResult(List<Integer> numbers) {
		numbers.forEach(v -> System.out.print(v + " "));
	}
}
