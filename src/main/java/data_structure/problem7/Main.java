package data_structure.problem7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String requiredSubject = main.readOrderOfSubject();
		String plan = main.readOrderOfSubject();
		boolean result = main.isRight(main.convertStringToQueue(requiredSubject), main.convertStringToQueue(plan));

		main.printResult(result);
	}

	private String readOrderOfSubject() {
		return sc.next();
	}

	private Queue<String> convertStringToQueue(String s) {
		Queue<String> queue = new LinkedList<>();

		for (char c : s.toCharArray()) {
			String subject = String.valueOf(c);
			queue.add(subject);
		}

		return queue;
	}

	private boolean isRight(Queue<String> requiredSubject, Queue<String> plan) {
		while (!plan.isEmpty()) {
			String subject = plan.poll();

			if (requiredSubject.isEmpty()) {
				return true;
			}
			if (requiredSubject.peek().equals(subject)) {
				requiredSubject.remove();
			}
		}

		return false;
	}

	private void printResult(boolean result) {
		String answer = "NO";
		if (result) {
			answer = "YES";
		}
		System.out.println(answer);
	}
}
