package sorting.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		List<Integer> numbers = main.createList(n);

		main.printResult(main.bubbleSort(numbers));
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

	private List<Integer> bubbleSort(List<Integer> numbers) {
		for (int j = 0; j < numbers.size(); j++) {
			for (int i = 0; i < numbers.size() - 1; i++) {
				if (numbers.get(i) > numbers.get(i + 1)) {
					int tmp = numbers.get(i);

					numbers.set(i, numbers.get(i + 1));
					numbers.set(i + 1, tmp);
				}
			}
		}
		return numbers;
	}

	private void printResult(List<Integer> numbers) {
		numbers.forEach(v -> System.out.print(v + " "));
	}
}
