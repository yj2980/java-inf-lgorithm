package binary_search.baekjoon.problem2110;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		int router = main.readNumber();
		List<Integer> coordinate = main.readCoordinate(n);

		main.binarySearch(coordinate, router);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> readCoordinate(int n) {
		List<Integer> coordinate = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			coordinate.add(readNumber());
		}

		return coordinate;
	}

	private void binarySearch(List<Integer> house, int router) {
		int result = 0;

		house.sort(Comparator.naturalOrder());

		int lf = 1;
		int rf = house.get(house.size() - 1) - house.get(0);

		while (lf <= rf) {
			int mid = (lf + rf) / 2;

			if (count(house, mid) >= router) {
				result = mid;
				lf = mid + 1;
			} else {
				rf = mid - 1;
			}
		}

		printResult(result);
	}

	private int count(List<Integer> numbers, int distance) {
		int cnt = 1;
		int coordinate = numbers.get(0);

		for (int x : numbers) {
			if (x - coordinate >= distance) {
				cnt++;
				coordinate = x;
			}
		}

		return cnt;
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
