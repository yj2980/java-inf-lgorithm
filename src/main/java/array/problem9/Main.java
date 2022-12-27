package array.problem9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		List<List<String>> board;

		board = main.createBoard();
		int answer = main.findSumMax(board);

		System.out.println(answer);
	}

	private List<String> convertStringToList(String numbers) {
		return Arrays.stream(numbers.split(" "))
				.collect(Collectors.toList());
	}

	private List<List<String>> createBoard() {
		List<List<String>> board = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < n; i++) {
			board.add(convertStringToList(sc.nextLine()));
		}

		return board;
	}

	private int findSumMax(List<List<String>> board) {
		int max = 0;

		for (int i = 0; i < board.size(); i++) {
			// 열
			max = Math.max(max, sum(board.get(i)));
			// 행
			max = Math.max(max, sum(findColumn(board, i)));
		}
		// 대각선
		max = Math.max(max, sum(findDiagonal(board)));

		return max;
	}

	private List<String> findColumn(List<List<String>> board, int c) {
		List<String> column = new ArrayList<>();

		for (List<String> strings : board) {
			column.add(strings.get(c));
		}

		return column;
	}

	private List<String> findDiagonal(List<List<String>> board) {
		List<String> diagonal = new ArrayList<>();

		for (int i = 0; i < board.size(); i++) {
			diagonal.add(board.get(i).get(i));
		}

		return diagonal;
	}

	private int sum(List<String> numbers) {
		int sum = 0;

		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}

		return sum;
	}
}
