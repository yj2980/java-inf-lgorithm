package array.problem12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<List<Integer>> test = main.readTestResult(main.readInitInfo());

		System.out.println(main.findMentorByTest(test));
	}

	private List<Integer> readInitInfo() {
		List<Integer> info = new ArrayList<>();

		info.add(Integer.parseInt(sc.next()));
		info.add(Integer.parseInt(sc.next()));

		return info;
	}

	private List<List<Integer>> readTestResult(List<Integer> info) {
		List<List<Integer>> test = new ArrayList<>();

		for (int i = 0; i < info.get(1); i++) {
			List<Integer> result = new ArrayList<>();

			for (int j = 0; j < info.get(0); j++) {
				result.add(Integer.parseInt(sc.next()));
			}
			test.add(result);
		}

		return test;
	}

	private int findMentorByTest(List<List<Integer>> test) {
		List<String> pair = findPairByTest(test.get(0));

		for (int i = 1; i < test.size(); i++) {
			isDuplicatePair(pair, findPairByTest(test.get(i)));
		}

		return pair.size();
	}

	private List<String> findPairByTest(List<Integer> test) {
		List<String> pair = new ArrayList<>();

		for (int i = 0; i < test.size(); i++) {
			String mentor = test.get(i).toString();
			for (int j = i + 1; j < test.size(); j++) {
				String mentee = test.get(j).toString();
				pair.add(mentor + "," + mentee);
			}
		}

		return pair;
	}

	private void isDuplicatePair(List<String> pair, List<String> candidate) {
		pair.sort(Comparator.naturalOrder());
		candidate.sort(Comparator.naturalOrder());

		for (int i = 0; i < pair.size(); i++) {
			boolean flag = false;

			for (String s : candidate) {
				if (pair.get(i).equals(s)) {
					flag = true;
					candidate.remove(s);
					break;
				}
			}
			if (!flag) {
				pair.remove(i);
				i--;
			}
		}
	}
}
