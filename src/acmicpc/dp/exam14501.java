package acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 2];
    int[] T = new int[N + 2];
    int[] P = new int[N + 2];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = N; i > 0; i--) {
      int day = i + T[i];
      if (day <= N + 1) {
        dp[i] = Math.max(P[i] + dp[day], dp[i + 1]);
      } else {
        dp[i] = dp[i + 1];
      }
    }

    System.out.println(dp[1]);
  }
}
