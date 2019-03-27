package part33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11047 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] coinValue = new int[N];
    for (int i = 0; i < N; i++) {
      coinValue[i] = Integer.parseInt(br.readLine());
    }

    int now = K;
    int count = 0;

    for (int i = N - 1; i >= 0; i--) {
      int tempCoin = now / coinValue[i];
      now = now - (coinValue[i] * tempCoin);
      count += tempCoin;
    }

    System.out.println(count);
  }
}
