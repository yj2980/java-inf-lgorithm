package string.problem10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindShortestDistance {
	static FindShortestDistance main = new FindShortestDistance();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();
		String sep = sc.next();

		List<Integer> location = main.locateSpecificCharacter(word, sep.charAt(0));
		List<Integer> result = main.findShortestDistanceFromCharacter(word, location);

		result.forEach(v -> System.out.print(v + " "));

	}

	private List<Integer> locateSpecificCharacter(String word, char sep) {
		int index = 0;
		List<Integer> location = new ArrayList<>();

		for (char letter : word.toCharArray()) {
			if (letter == sep) {
				location.add(index);
			}
			index++;
		}

		return location;
	}

	private List<Integer> findDistanceFromSpecificCharacter(int currentLocation, List<Integer> location) {
		List<Integer> distance = new ArrayList<>();

		for (int d = 0; d < location.size(); d++) {
			int specificLocation = location.get(d);
			int max = Math.max(currentLocation, specificLocation);
			int min = Math.min(currentLocation, specificLocation);

			distance.add(max - min);
		}

		return distance;
	}

	private List<Integer> findShortestDistanceFromCharacter(String word, List<Integer> location) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			List<Integer> distance = findDistanceFromSpecificCharacter(i, location);
			result.add(Collections.min(distance));
		}

		return result;
	}
}
