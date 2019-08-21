package programmers.summer;

public class Summer2017_3 {
	private static boolean[] isNotPrime;
	private static void makePrime() {
		isNotPrime = new boolean[3000];
		isNotPrime[1] = true;
		for (int i = 2; i <= Math.sqrt(3000); i++) {
			if (!isNotPrime[i]) {
				for (int j = i + i; j < 3000; j += i) {
					isNotPrime[j] = true;
				}
			}
		}
	}

	public int solution(int[] nums) {
		int count = 0;
		makePrime();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if (!isNotPrime[temp]) {
						count++;
					}
				}
			}
		}

		return count;
	}
}