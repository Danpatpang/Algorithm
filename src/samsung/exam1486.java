//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b7Yf6ABcBBASw&categoryId=AV2b7Yf6ABcBBASw&categoryType=CODE
package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1486 {
	static int N, S;
	static int[] length;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(br.readLine());
			S = Integer.parseInt(br.readLine());

			length = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				length[j] = Integer.parseInt(st.nextToken());
			}

			System.out.println(sb.toString());
		}
	}
}
