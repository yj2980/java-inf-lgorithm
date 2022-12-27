package array.problem11;

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
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = main.readNumberOfStudent();

		Map<Integer, Integer> student = main.createStudent(n);
		main.isFriendOfStudent(student, main.createClassRoomInfo(n));

		int answer = student.keySet().stream()
				.max(Comparator.comparing(student::get))
				.orElse(-1);

		System.out.println(answer);
	}

	private int readNumberOfStudent() {
		return Integer.parseInt(input());
	}

	private String readClassRoomNumber() {
		return input();
	}

	private String input() {

		return sc.nextLine();
	}

	private Map<Integer, Integer> createStudent(int n) {
		Map<Integer, Integer> student = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			student.put(i, 0);
		}

		return student;
	}

	private List<List<String>> createClassRoomInfo(int n) {
		List<List<String>> classRoom = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			classRoom.add(convertStringToList(readClassRoomNumber()));
		}

		return classRoom;
	}

	private List<String> convertStringToList(String s) {
		return Arrays.stream(s.split(" "))
				.collect(Collectors.toList());
	}

	private void isFriendOfStudent(Map<Integer, Integer> point, List<List<String>> classRoom) {
		for (int i = 0; i < point.size(); i++) {
			countPointByFriendOfStudent(point, i, classRoom);
		}

	}

	private void countPointByFriendOfStudent(Map<Integer, Integer> point, int studentNumber, List<List<String>> classRoom) {
		List<String> student = classRoom.get(studentNumber);

		for (int i = studentNumber + 1; i < point.size(); i++) {
			List<String> friend = classRoom.get(i);

			if (isSameClassRoom(student, friend)) {
				point.replace(studentNumber + 1, point.get(studentNumber + 1) + 1);
				point.replace(i + 1, point.get(i + 1) + 1);
			}

		}
	}

	private boolean isSameClassRoom(List<String> student, List<String> friend) {
		for (int i = 0; i < student.size(); i++) {
			if (student.get(i).equals(friend.get(i))) {

				return true;
			}
		}

		return false;
	}
}
