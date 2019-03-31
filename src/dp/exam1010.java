package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1010 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int west = Integer.parseInt(st.nextToken());
      int east = Integer.parseInt(st.nextToken());
      int[][] dp = new int[east + 1][east + 1];

      for (int j = 1; j <= east; j++) {
        dp[1][j] = j;
        for (int k = 2; k <= j; k++) {
          dp[k][j] = dp[k - 1][j - 1] + dp[k][j - 1];
        }
      }

      System.out.println(dp[west][east]);
    }
  }
}
