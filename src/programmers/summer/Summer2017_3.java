package programmers.summer;

import java.util.Arrays;

public class Summer2017_3 {
	private static boolean[] isVisit, isPrime;

	public int solution(int[] nums) {
		isVisit = new boolean[3000];
		isPrime = new boolean[3000];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		for (int i = 2; i <= Math.sqrt(3000); i++) {
			if (isPrime[i]) {
				for (int j = i + i; j < 3000; j += i) {
					isPrime[j] = false;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if (!isVisit[temp] && isPrime[temp]) {
						count++;
						isVisit[temp] = true;
					}
				}
			}
		}

		return count;
	}
}