package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam8104 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int sum = 0;
			for (int j = 0; j < N; j += 2) {
				sum += (1 + j * K);
			}
			for (int j = 1; j < N; j += 2) {
				sum += ((j + 1) * K);
			}

			if (N % 2 == 0) {
				for (int j = 0; j < K; j++) {
					sb.append(sum + " ");
				}
			} else {
				for (int j = 0; j < K; j++) {
					sb.append(sum + j + " ");
				}
			}

			System.out.println(sb.toString());
		}
	}
}