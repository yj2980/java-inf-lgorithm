package twoPointers_slidingWindow.problem4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> numbers = new ArrayList<>();
		int length = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		for (int i = 0; i < length; i++) {
			numbers.add(Integer.parseInt(sc.next()));
		}

		main.solution(m, numbers);
	}

	private void solution(int m, List<Integer> numbers) {
		int sum = 0;
		int count = 0;
		int k = 0;

		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);

			if (sum == m) {
				count++;
			}

			while (sum >= m) {
				sum -= numbers.get(k++);
				if (sum == m) {
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
