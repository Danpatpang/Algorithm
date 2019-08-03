package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1860 {
	static int N, M, K;
	static int[] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			time = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(time);

			if(isPossible()) {
				sb.append("Possible");
			} else {
				sb.append("Impossible");
			}
			System.out.println(sb.toString());
		}
	}

	private static boolean isPossible() {
		for (int i = 0; i < time.length; i++) {
			int bread = (time[i] / M) * K;
			if (bread - i - 1 < 0) return false;
		}
		return true;
	}
}
