package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam3975 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			String result = Play((double) A / B, (double) C / D);
			sb.append(result);
			System.out.println(sb.toString());
		}
	}

	private static String Play(double alice, double bob) {
		if (alice > bob) return "ALICE";
		else if (alice < bob) return "BOB";
		else return "DRAW";
	}
}
