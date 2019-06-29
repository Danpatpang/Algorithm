package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1491 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("#" + i + " ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long A = Integer.parseInt(st.nextToken());
			long B = Integer.parseInt(st.nextToken());

			long min = Integer.MAX_VALUE;
			for (int R = 1; R <= N; R++) {
				for (int C = 1; C * R <= N; C++) {
					min = Math.min(min, A * Math.abs(R - C) + B * (N - (R * C)));
				}
			}
			sb.append(min);
			System.out.println(sb.toString());
		}
	}
}
