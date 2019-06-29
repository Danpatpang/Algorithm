package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1215 {
	static int L;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			L = Integer.parseInt(br.readLine());
			map = new int[8][8];
			for (int j = 0; j < 8; j++) {
				String s = br.readLine();
				for (int k = 0; k < 8; k++) {
					map[j][k] = s.charAt(k) - '0';
				}
			}

			StringBuffer sb = new StringBuffer();
			sb.append("#" + i + " ");

			if (L == 1) {
				sb.append(64);
				System.out.println(sb.toString());
				continue;
			}

			int sum = 0;
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k <= 8 - L; k++) {
					if (Check(j, k, 1)) {
						sum++;
					}
					if (Check(j, k, 2)) {
						sum++;
					}
				}
			}

			sb.append(sum);
			System.out.println(sb.toString());
		}
	}

	static boolean Check(int n, int index, int type) {
		int start = index;
		int end = index + L - 1;

		if (type == 1) {
			while (start <= end) {
				if (map[n][start] == map[n][end]) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		} else {
			while (start <= end) {
				if (map[start][n] == map[end][n]) {
					start++;
					end--;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
