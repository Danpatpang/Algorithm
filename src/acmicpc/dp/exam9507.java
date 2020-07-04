package acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9507 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			long[] koong = new long[68];

			koong[0] = 1;
			koong[1] = 1;
			koong[2] = 2;
			koong[3] = 4;
			for (int j = 4; j <= N; j++) {
				koong[j] = koong[j - 1] + koong[j - 2] + koong[j - 3] + koong[j - 4];
			}

			System.out.println(koong[N]);
		}
	}
}
