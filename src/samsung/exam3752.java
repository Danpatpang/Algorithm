package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class exam3752 {
	static HashSet<Integer> set;
	static int testNum;
	static int[] value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringBuffer sb = new StringBuffer("#" + i + " ");
			set = new HashSet<Integer>();
			testNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			value = new int[testNum];
			for (int j = 0; j < testNum; j++) {
				value[j] = Integer.parseInt(st.nextToken());
			}

			DFS(0, 0);
			sb.append(set.size());
			System.out.println(sb.toString());
		}
	}

	private static void DFS(int result, int num) {
		set.add(result);
		if (num == testNum) return;

		DFS(result, num + 1);
		DFS(result + value[num], num + 1);
	}
}
