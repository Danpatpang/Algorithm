package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <= 10; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] height = new int[N + 4];
			for (int j = 2; j <= N + 1; j++) {
				height[j] = Integer.parseInt(st.nextToken());
			}

			int result = 0;
			for (int j = 2; j <= N + 1; j++) {
				int left = Math.max(height[j - 2], height[j - 1]);
				int right = Math.max(height[j + 1], height[j + 2]);
				int limit = Math.max(left, right);

				if(height[j] > limit) {
					result += (height[j] - limit);
				}
			}

			sb.append(result);
			System.out.println(sb.toString());
		}
	}
}
