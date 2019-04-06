package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam14501 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int T = Integer.parseInt(st.nextToken());
      int P = Integer.parseInt(st.nextToken());

      int day = i + T - 1;
      if (day <= N) {
        dp[i] = Math.max(dp[day] + P, dp[i]);
      } else {
        dp[i] = dp[i - 1];
      }
    }
    for (int i = 1; i <= N; i++) {
      System.out.println(dp[i]);
    }
  }
}
