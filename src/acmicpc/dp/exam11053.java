package acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11053 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] value = new int[N];
    int[] dp = new int[N];

    for (int i = 0; i < N; i++) {
      value[i] = Integer.parseInt(st.nextToken());
    }

    int count = 0;
    for (int i = 0; i < N; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (value[i] > value[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      count = Math.max(count, dp[i]);
    }
    System.out.println(count);
  }
}
