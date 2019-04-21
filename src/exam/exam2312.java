package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2312 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int temp = N;

			for (int j = 2; j <= N; j++) {
				int cnt = 0;
				while (temp % j == 0) {
					cnt++;
					temp /= j;
				}

				if (cnt > 0) {
					System.out.println(j + " " + cnt);
				}
			}
		}
	}
}
