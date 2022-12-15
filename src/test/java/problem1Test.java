import org.junit.jupiter.api.Test;

import problem1.FindText;

public class problem1Test {

	@Test
	void run() {
		String word = "Consistence";
		char sep = 'c';

		FindText problem = new FindText();

		int answer = problem.solution(word, sep);

		if (answer != 2) {
			System.out.println("result = " + answer);
			throw new IllegalStateException();
		}
	}
}
