package part36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2188 {

  public static boolean[] isVisit;
  public static int edge[][], N, M, B[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    edge = new int[N + 1][M + 1];
    isVisit = new boolean[N + 1];
    B = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      Arrays.fill(edge[i], -1);
      for (int j = 1; j <= length; j++) {
        edge[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int result = 0;
    for (int i = 1; i <= N; i++) {
    	if(DFS(i)) {
    		result++;
	    }
    }
    System.out.println(result);
  }

  public static boolean DFS(int start) {
    isVisit[start] = true;
    for (int i = 1; i <= M; i++) {
      if (edge[start][i] == -1) {
        break;
      }
      int v = edge[start][i];
      if (B[v] == 0 || (!isVisit[B[v]] && DFS(B[v]))) {
        B[v] = start;
        return true;
      }
    }
    return false;
  }
}
