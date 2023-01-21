package binary_search.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 결정 트리 알고리즘
public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int size = main.readNumber();
		int dvd = main.readNumber();
		List<Integer> numbers = main.createList(size);

		main.solution(numbers, dvd);
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

	private void solution(List<Integer> song, int dvd) {
		int result = 0;

		// dvd 용량이 될 수 이는 최솟값과 최대값을 설정
		int left = song.stream().mapToInt(v -> v).max().getAsInt();
		int right = song.stream().mapToInt(v -> v).sum();

		// 양쪽 값이 교차할때까지 검사사
		while (left <= right) {
			int mid = (left + right) / 2;

			// dvd 개수가 넘지 않는지 확인
			if (count(song, mid) <= dvd) {
				// 만족하면 보다 큰 값을 날린다.
				result = mid;
				right = mid - 1;
			} else {
				// 작은 값을 날린다.
				left = mid + 1;
			}
		}
		printResult(result);
	}

	private int count(List<Integer> song, int capacity) {
		int cnt = 1;
		int sum = 0;

		for (int x : song) {
			if (sum + x > capacity) {
				cnt++;
				sum = x;
			} else {
				sum += x;
			}
		}
		return cnt;
	}

	private void printResult(int result) {
		System.out.println(result);
	}
}
