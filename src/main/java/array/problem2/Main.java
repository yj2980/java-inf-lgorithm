package array.problem2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String length = sc.nextLine();
		String height = sc.nextLine();

		System.out.println(main.countNumberOfStudentsByHeight(main.convertStringToList(height)));
	}

	private int countNumberOfStudentsByHeight(List<String> height) {
		int count = 1;
		int max = convertStringToInt(height.get(0));

		for (int i = 1; i < height.size(); i++) {
			if (max < convertStringToInt(height.get(i))) {
				count++;
				max = convertStringToInt(height.get(i));
			}
		}

		return count;
	}


	private int convertStringToInt(String height) {
		return Integer.parseInt(height);
	}

	private List<String> convertStringToList(String height) {
		return Arrays.stream(height.split(" "))
				.collect(Collectors.toList());
	}
}
