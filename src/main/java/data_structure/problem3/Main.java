package data_structure.problem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumber();
		List<List<Integer>> board = main.replaceBoard(main.readBoard(n));
		int m = main.readNumber();
		List<Integer> moving = main.readMoving(m);
		int answer = main.pickDollByCrane(board, moving);

		main.printResult(answer);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<List<Integer>> readBoard(int n) {
		List<List<Integer>> board = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			List<Integer> number = new ArrayList<>();

			for (int k = 0; k < n; k++) {
				number.add(Integer.parseInt(sc.next()));
			}
			board.add(number);
		}

		return board;
	}

	private List<List<Integer>> replaceBoard(List<List<Integer>> board) {
		List<List<Integer>> changeBoard = new ArrayList<>();

		for (int i = 0; i < board.size(); i++) {
			List<Integer> row = new ArrayList<>();

			for (List<Integer> integers : board) {
				row.add(integers.get(i));
			}
			changeBoard.add(row);
		}

		return changeBoard;
	}


	private List<Integer> readMoving(int m) {
		List<Integer> moving = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			moving.add(Integer.parseInt(sc.next()) - 1);
		}

		return moving;
	}

	private int pickDollByCrane(List<List<Integer>> board, List<Integer> moving) {
		int count = 0;
		List<Integer> basket = new ArrayList<>();

		for (int pickLine : moving) {
			for (int k = 0; k < board.get(pickLine).size(); k++) {
				if (board.get(pickLine).get(k) != 0) {
					basket.add(board.get(pickLine).get(k));
					board.get(pickLine).set(k, 0);
					break;
				}
			}

			count += isDuplication(basket);
		}

		return count;
	}

	private int isDuplication(List<Integer> basket) {
		int cnt = 0;

		for (int i = 0; i < basket.size() - 1; i++) {
			if (Objects.equals(basket.get(i), basket.get(i + 1))) {
				basket.remove(i);
				basket.remove(i);
				cnt++;
			}
		}

		return cnt;
	}

	private void printResult(int count) {
		System.out.println(count * 2);
	}
}
