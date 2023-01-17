package sorting.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		List<Integer> numbers = main.createList(n);

		main.printResult(main.insertionSort(numbers));
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

	private List<Integer> insertionSort(List<Integer> numbers) {
		for (int i = 1; i < numbers.size(); i++) {
			for (int j = 0; j < i; j++) {
				if (numbers.get(i) < numbers.get(j)) {
					int tmp = numbers.get(i);
					numbers.set(i , numbers.get(j));
					numbers.set(j , tmp);
				}
			}
		}


		return numbers;
	}

	private void printResult(List<Integer> numbers) {
		numbers.forEach(v -> System.out.print(v + " "));
	}
}
