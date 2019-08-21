package programmers.summer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Summer2017_3Test {
	@Test
	public void getSolution() {
		Summer2017_3 S2017_3 = new Summer2017_3();
		assertEquals(0, S2017_3.solution(new int[]{1, 2, 3}));
	}
}