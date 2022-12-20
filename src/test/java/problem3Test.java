import org.junit.jupiter.api.Test;

import string.problem3.WordInSentence;

public class problem3Test {

	@Test
	void split_test() {
		String sentence = "it is time to study";

		WordInSentence problem = new WordInSentence();

		if (!(problem.solution(sentence).equals("study"))) {
			throw new IllegalStateException();
		}
	}
}
