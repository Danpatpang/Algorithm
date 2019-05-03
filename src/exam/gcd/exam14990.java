package exam.gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam14990 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] value = br.readLine().split(":");

		int n = Integer.parseInt(value[0]);
		int m = Integer.parseInt(value[1]);
		int gcd = GCD(n, m);
		int[] result = {n / gcd, m / gcd};
		System.out.println(result[0] + ":" + result[1]);
	}

	public static int GCD(int x, int y) {
		if (x < y) {
			int temp = x;
			x = y;
			y = temp;
		}
		if (x % y == 0) {
			return y;
		} else {
			return GCD(y, x % y);
		}
	}
}
