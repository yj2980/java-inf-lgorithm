package array.problem7;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = Integer.parseInt(sc.nextLine());
		List<String> point = main.convertStringToList(sc.nextLine());
		int answer = main.score(point);

		System.out.println(answer);
	}

	private List<String> convertStringToList(String point) {
		return Arrays.stream(point.split(" "))
				.collect(Collectors.toList());
	}

	private int score(List<String> point) {
		int count = 0;
		int result = 0;

		for (int i = 0; i < point.size(); i++) {
			if (isConsecutiveNumbers(point.get(i))) {
				count++;
			} else {
				count = 0;
			}
			result += count;
		}

		return result;
	}

	private boolean isConsecutiveNumbers(String point) {
		if (point.equals("1")) {
			return true;
		}
		return false;
	}

}
