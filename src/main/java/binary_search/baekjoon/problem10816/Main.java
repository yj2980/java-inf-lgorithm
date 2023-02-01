package binary_search.baekjoon.problem10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
 fist try : false => time over

 [renew]
 1. scanner -> bufferReader change
 */

public class Main {
	static Main main = new Main();
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			int n = main.readNumber();
			List<Integer> first = main.createNumbers(n);
			int m = main.readNumber();
			List<Integer> second = main.createNumbers(m);

			main.solve(first, second);
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	private int readNumber() throws IOException {
		return Integer.parseInt(bf.readLine());
	}

	private List<Integer> createNumbers(int n) throws IOException {
		List<Integer> numbers = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

		for (int i = 0; i < n; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}

		return numbers;
	}

	public void solve(List<Integer> first, List<Integer> second) {
		first.sort(Comparator.naturalOrder());
		Map<Integer, Integer> duplication = countNumberOfCard(first);

		printResult(checkDuplication(second, duplication));
	}

	private Map<Integer, Integer> countNumberOfCard(List<Integer> first) {
		Map<Integer, Integer> duplication = new HashMap<>();

		for (int number : first) {
			duplication.put(number, duplication.getOrDefault(number, 0) + 1);
		}

		return duplication;
	}

	private List<Integer> checkDuplication(List<Integer> numbers, Map<Integer, Integer> card) {
		List<Integer> result = new ArrayList<>();

		for (int n : numbers) {
			result.add(card.getOrDefault(n, 0));
		}

		return result;
	}

	private void printResult(List<Integer> result) {
		result.forEach(v -> System.out.print(v + " "));
	}
}
