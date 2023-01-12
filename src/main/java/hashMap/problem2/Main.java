package hashMap.problem2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String answer = "NO";

		boolean result = main.isAnagram(main.createMap(main.readWord()), main.createMap(main.readWord()));

		if (result) {
			answer = "YES";
		}

		System.out.println(answer);
	}

	private String readWord() {
		return sc.nextLine();
	}

	public List<Map.Entry<String, Integer>> createMap(String word) {
		Map<String, Integer> alphabet = new HashMap<>();

		for (char c : word.toCharArray()) {
			String alpha = String.valueOf(c);
			if (!alphabet.containsKey(alpha)) {
				alphabet.put(alpha, 1);
			}
			if (alphabet.containsKey(alpha)) {
				alphabet.put(alpha, alphabet.get(alpha) + 1);
			}
		}

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(alphabet.entrySet());
		entryList.sort(Map.Entry.comparingByKey());

		return entryList;
	}

	private boolean isAnagram(List<Map.Entry<String, Integer>> first, List<Map.Entry<String, Integer>> second) {
		if (first.size() != second.size()) {
			return false;
		}

		for (int i = 0; i < first.size(); i++) {
			if (first.get(i).getValue() == second.get(i).getValue()) {
				continue;
			}
			return false;
		}

		return true;
	}
}
