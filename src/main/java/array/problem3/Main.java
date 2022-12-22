package array.problem3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String round = sc.nextLine();
		String aUser = sc.nextLine();
		String bUser = sc.nextLine();

		List<String> aUser_Info = main.convertStringToList(aUser);
		List<String> bUser_Info = main.convertStringToList(bUser);

		main.run(aUser_Info, bUser_Info);

	}


	private void run(List<String> a, List<String> b) {
		for (int i = 0; i < a.size(); i++) {
			char result = compareResult(convertStringToInt(a.get(i)),
					convertStringToInt(b.get(i)));
			System.out.println(result);
		}
	}

	private char compareResult(int a, int b) {
		if (a == b) {

			return 'D';
		}
		if ((a == 1 && b == 3) || (a == 2 && b == 1)
				|| (a == 3 && b == 2)) {

			return 'A';
		} else {

			return 'B';
		}
	}

	private int convertStringToInt(String number){
		return Integer.parseInt(number);
	}

	private List<String> convertStringToList(String info) {
		return Arrays.stream(info.split(" "))
				.collect(Collectors.toList());
	}
}
