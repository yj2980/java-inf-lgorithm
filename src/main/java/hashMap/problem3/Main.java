package hashMap.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Main main = new Main();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readSalesRecordDate();
		int k = main.readDay();

		List<Integer> record = main.findTypeOfSales(k, main.readSalesRecord(n));

		record.forEach(v -> System.out.print(v + " "));
	}

	private int readDay() {
		return Integer.parseInt(sc.next());
	}

	private int readSalesRecordDate() {
		return Integer.parseInt(sc.next());
	}

	private List<Integer> readSalesRecord(int n) {
		List<Integer> record = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			record.add(Integer.parseInt(sc.next()));
		}

		return record;
	}

	private List<Integer> findTypeOfSales(int k, List<Integer> record) {
		List<Integer> salesType = new ArrayList<>();

		for (int i = 0; i <= record.size() - k; i++) {
			Map<Integer, Integer> salesRecord = new HashMap<>();

			for (int j = i; j < i + k; j++) {
				salesRecord.put(record.get(j), 0);
			}
			salesType.add(salesRecord.size());
		}

		return salesType;
	}
}
