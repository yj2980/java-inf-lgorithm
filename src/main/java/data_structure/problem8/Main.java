package data_structure.problem8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int NumberOfPatients = main.readNumber();
		int m = main.readNumber();
		List<Integer> patients = main.readPatients(NumberOfPatients);

		main.printResult(main.solution(patients, m));

	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> readPatients(int n) {
		List<Integer> patients = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			patients.add(Integer.parseInt(sc.next()));
		}


		return patients;
	}

	private int solution(List<Integer> patients, int m) {
		int answer = 1;
		Queue<Person> queue = new LinkedList<>();

		for (int i = 0; i < patients.size(); i++) {
			queue.add(new Person(i, patients.get(i)));
		}

		while (!queue.isEmpty()) {
			Person tmp = queue.poll();
			for (Person patient : queue) {
				if (patient.risk > tmp.risk) {
					queue.add(tmp);
					tmp = null;
					break;
				}
			}
			if (tmp != null) {
				if (tmp.id == m) {
					return answer;
				}
				answer++;
			}
		}
		return answer;
	}

	private void printResult(int n) {
		System.out.println(n);
	}
}
