package array.problem8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int length = Integer.parseInt(sc.nextLine());
		List<Integer> score = main.convertStringToInteger(sc.nextLine());
		main.printResult(score, main.convertListToMap(score));
	}

	private List<String> convertStringToList(String point) {

		return Arrays.stream(point.split(" "))
				.collect(Collectors.toList());
	}

	private List<Integer> convertStringToInteger(String point) {
		List<Integer> score = new ArrayList<>();
		List<String> temp = convertStringToList(point);

		for (String s : temp) {
			score.add(Integer.parseInt(s));
		}

		return score;
	}

	private Map<Integer, Integer> convertListToMap(List<Integer> score) {
		Map<Integer, Integer> rank = new HashMap<>();

		for (int i = 0; i < score.size(); i++) {
			rank.put(i , score.get(i));
		}

		return rank;
	}

	private void rank(List<Integer> score) {
		score.sort(Comparator.reverseOrder());
	}

	private void printResult(List<Integer> score, Map<Integer, Integer> rank) {
		rank(score);

		for (int i = 0; i < rank.size(); i++) {
			System.out.print(score.indexOf(rank.get(i))+ 1 + " ");
		}
	}
}
