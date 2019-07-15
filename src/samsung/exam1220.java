package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1220 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());

			map = new int[100][100];
			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int result = 0;
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					if (map[j][k] == 1) {
						if (isFindBlue(j, k)) {
							result++;
						}
					}
				}
			}

			sb.append(result);
			System.out.println(sb.toString());
		}
	}

	private static boolean isFindBlue(int j, int k) {
		for (int i = j + 1; i < 100; i++) {
			if (map[i][k] == 1) {
				return false;
			}
			if (map[i][k] == 2) {
				return true;
			}
		}
		return false;
	}
}
