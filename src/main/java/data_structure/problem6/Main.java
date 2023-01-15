package data_structure.problem6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int prince = main.pickPrinceToSavePrincess(main.readNumber(), main.readNumber());

		System.out.println(prince);
	}

	private int readNumber() {
		return Integer.parseInt(sc.next());
	}

	private int pickPrinceToSavePrincess(int n, int excludedNumber) {
		Queue<Integer> prince = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			prince.add(i);
		}

		while (prince.size() > 1) {
			for (int k = 1; k < excludedNumber; k++) {
				prince.add(prince.remove());
			}
			prince.remove();
		}

		return prince.poll();
	}
}
