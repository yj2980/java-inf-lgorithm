package array.problem10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		List<List<Integer>> board;

		board = main.createBoard();

		int answer = main.countMountainTop(board);

		System.out.println(answer);
	}

	private List<Integer> convertStringToList(String numbers) {
		List<Integer> board = convertStringToInteger(Arrays
				.stream(numbers.split(" "))
				.collect(Collectors.toList()));
		board.add(0, 0);
		board.add(0);

		return board;
	}

	private List<Integer> convertStringToInteger(List<String> numbers) {
		List<Integer> board = new ArrayList<>();

		for (String number : numbers) {
			board.add(Integer.parseInt(number));
		}

		return board;
	}

	private List<Integer> initBoard(int n) {
		List<Integer> board = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			board.add(0);
		}

		return board;
	}

	private List<List<Integer>> createBoard() {
		List<List<Integer>> board = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		board.add(initBoard(n + 2));
		for (int i = 0; i < n; i++) {
			board.add(convertStringToList(sc.nextLine()));
		}
		board.add(initBoard(n + 2));

		return board;
	}

	private int countMountainTop(List<List<Integer>> board) {
		int cnt = 0;
		for (int i = 1; i < board.size() - 1; i++) {
			for (int j = 1; j < board.size() - 1; j++) {
				int mountainTop = board.get(i).get(j);

				if ((board.get(i - 1).get(j) < mountainTop)
						&& (board.get(i + 1).get(j) < mountainTop)
						&& (board.get(i).get(j - 1) < mountainTop)
						&& (board.get(i).get(j + 1) < mountainTop)) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}
