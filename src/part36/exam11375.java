package part36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11375 {
  public static int N, M;
  public static int flow[][], backFlow[][];
  public static boolean isVisit[];
  public static int result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    flow = new int[N + 1][M + 1];
    backFlow = new int[N + 1][M + 1];
    isVisit = new boolean[M + 1];

    // graph 연결
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int job = Integer.parseInt(st.nextToken());

      for (int j = 0; j < job; j++) {
        flow[i][Integer.parseInt(st.nextToken())] = 1;
      }
    }

    result = 0;
    for (int i = 1; i <= N; i++) {
      DFS(i);
    }
    System.out.println(result);
  }

  public static void DFS(int node) {
    for (int i = 1; i <= M; i++) {
      if (flow[node][i] == 1) {
        if (!isVisit[i]) {
          result++;
          isVisit[i] = true;
          flow[node][i] = 0;
          backFlow[i][node] = 1;
          return;
        } else {
          for (int j = 1; j <= i; j++) {
	          if(backFlow[i][j] == 1) {
	          	DFS(j);
	          }
          }
        }
      }
    }
  }
}
