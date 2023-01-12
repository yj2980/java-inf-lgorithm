package hashMap.problem1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int length = main.readLength();
		String record = main.readVotingRecord();

		String answer = main.pickSchoolPresident(record);
		System.out.println(answer);
	}

	private int readLength() {
		return Integer.parseInt(sc.next());
	}

	private String readVotingRecord() {
		return sc.next();
	}

	private String pickSchoolPresident(String votingRecord) {
		Map<String, Integer> candidate = new HashMap<>();

		for (char c : votingRecord.toCharArray()) {
			if (!candidate.containsKey(String.valueOf(c))) {
				candidate.put(String.valueOf(c), 1);
			}
			if (candidate.containsKey(String.valueOf(c))) {
				candidate.put(String.valueOf(c), candidate.get(String.valueOf(c)) + 1);
			}
		}

		List<Map.Entry<String, Integer>> entryList =  new LinkedList<>(candidate.entrySet());
		entryList.sort(Map.Entry.comparingByValue());

		String schoolPresident = entryList.get(entryList.size() - 1).getKey();

		return schoolPresident;
	}
}
