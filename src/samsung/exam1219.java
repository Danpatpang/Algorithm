package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class exam1219 {
	static LinkedList<Integer>[] graph;
	static boolean[] isVisit;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int a = 1; a <= 10; a++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			graph = new LinkedList[100];
			for (int i = 0; i < 100; i++) {
				graph[i] = new LinkedList<Integer>();
			}
			isVisit = new boolean[100];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				graph[start].add(end);
			}

			result = 0;
			DFS(0);
			System.out.println("#" + T + " " + result);
		}
	}

	private static void DFS(int start) {
		isVisit[start] = true;
		if (start == 99) {
			result = 1;
		}

		for (int i : graph[start]) {
			if (!isVisit[i]) {
				DFS(i);
				isVisit[start] = false;
			}
		}
	}
}
