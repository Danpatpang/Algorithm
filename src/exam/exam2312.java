package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2312 {
	static boolean[] isNotPrime;
	static int[] prime;

	public static void init() {
		for (int i = 2; i <= (int) Math.sqrt(100000); i++) {
			if (!isNotPrime[i]) {
				for (int j = (2 * i); j <= (int) Math.sqrt(100000); j += i) {
					if (isNotPrime[j]) {
						continue;
					}
					isNotPrime[j] = true;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < isNotPrime.length; i++) {
			if (!isNotPrime[i]) {
				count++;
			}
		}

		prime = new int[count + 1];
		prime[count] = Integer.MAX_VALUE;
		count = 0;
		for (int i = 2; i < isNotPrime.length; i++) {
			if (!isNotPrime[i]) {
				prime[count++] = i;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		isNotPrime = new boolean[(int) Math.sqrt(100000) + 1];
		init();

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int temp = N;
			int[] value = new int[N + 1];

			int num = 0;
			for (int j = prime[num]; j <= temp; ) {
				if (temp % j == 0) {
					value[j]++;
					temp /= j;
				} else {
					j = prime[++num];
				}
			}

			for (int j = 2; j < value.length; j++) {
				if (value[j] > 0) {
					System.out.println(j + " " + value[j]);
				}
			}
		}
	}
}
