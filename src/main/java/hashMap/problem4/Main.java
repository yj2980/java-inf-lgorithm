package hashMap.problem4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Main main = new Main();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		String key = sc.next();

		int answer = main.findAnagram(word, key);

		System.out.println(answer);
	}

	private int findAnagram(String word, String key) {
		int count = 0;
		List<Map.Entry<String, Integer>> keyAlphabet = createMap(key);

		for (int i = 0; i <= word.length() - key.length(); i++) {
			List<Map.Entry<String, Integer>> wordAlphabet = createMap(word.substring(i , i + key.length()));
			if (isAnagram(wordAlphabet, keyAlphabet)) {
				count++;
			}
		}

		return count;
	}


	private List<Map.Entry<String, Integer>> createMap(String word) {
		Map<String, Integer> alpha = new HashMap<>();

		for (char c : word.toCharArray()) {
			String alphabet = String.valueOf(c);

			alpha.put(alphabet, alpha.getOrDefault(alphabet, 0) + 1);
		}

		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(alpha.entrySet());
		entryList.sort(Map.Entry.comparingByKey());

		return entryList;
	}

	private boolean isAnagram(List<Map.Entry<String, Integer>> word, List<Map.Entry<String, Integer>> key) {
		for (int i = 0; i < word.size(); i++) {
			if (word.get(i).equals(key.get(i))) {
				continue;
			}
			return false;
		}

		return true;
	}
}
