package acmicpc.exam.gcd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1850 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < GCD(A, B); i++) {
			sb.append("1");
		}
		System.out.println(sb.toString());

	}

	public static long GCD(long x, long y) {
		if (x < y) {
			long temp = x;
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
