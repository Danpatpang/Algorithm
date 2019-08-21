package programmers.summer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Summer2017_5Test {
	@Test
	public void getResult() {
		Summer2017_5 S2017_5 = new Summer2017_5();
		assertEquals(5, S2017_5.solution(5000));
		assertEquals(1, S2017_5.solution(1));
		assertEquals(2, S2017_5.solution(10));
		assertEquals(2, S2017_5.solution(6));
	}
}