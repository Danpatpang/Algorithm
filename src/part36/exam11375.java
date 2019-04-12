package part36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam11375 {
  public static int N, M;
  public static int flow[][], parents[];
  public static boolean isVisit[];
  public static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    flow = new int[N + M + 2][N + M + 2];
    parents = new int[N + M + 2];
    isVisit = new boolean[N + M + 2];

    // graph 연결
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int job = Integer.parseInt(st.nextToken());

      for (int j = 0; j < job; j++) {
        int current = Integer.parseInt(st.nextToken());
        flow[i][N + current] = 1;
      }
    }

    // graph S, E 초기화
    for (int i = 1; i <= N; i++) {
      flow[0][i] = 1;
    }
    for (int i = N + 1; i <= N + M; i++) {
      flow[i][N + M + 1] = 1;
    }

    result = 0;
    while (DFS(0)) {
      result++;
      backPath(N + M + 1);
      Arrays.fill(isVisit, false);
    }
    System.out.println(result);
  }

  public static void backPath(int n) {
  	while(n != 0) {
  		int child = n;
  		n = parents[n];
  		flow[n][child]--;
  		flow[child][n]++;
    }
  }

  public static boolean DFS(int start) {
    if (start == N + M + 1) {
      return true;
    }
    for (int i = 0; i <= N + M + 1; i++) {
      if(flow[start][i] <= 0 || isVisit[i]) {
      	continue;
      }
      parents[i] = start;
      isVisit[i] = true;
      if(DFS(i)) {
      	return true;
      }
    }
    return false;
  }
}
