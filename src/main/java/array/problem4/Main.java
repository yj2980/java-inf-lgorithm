package array.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		main.fibonacci(Integer.parseInt(sc.next()));
	}

	private void fibonacci(int number) {
		List<Integer> fibo = initial();

		for (int i = 0; i < number - 2; i++) {
			fibo.add(fibo.get(i) + fibo.get(i + 1));
		}

		fibo.forEach(v -> System.out.print(v + " "));
	}

	private List<Integer> initial() {
		List<Integer> fibonacci = new ArrayList<>();

		fibonacci.add(1);
		fibonacci.add(1);

		return fibonacci;
	}
}
