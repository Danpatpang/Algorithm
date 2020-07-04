package acmicpc.basic.part33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam2217 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] rope = new int[N];

    for (int i = 0; i < N; i++) {
      rope[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(rope);
    // 물체의 최대 중량을 구해야 한다.
    int maximumWeight = 0;
    for (int i = N - 1; i >= 0; i--) {
      maximumWeight = Math.max(maximumWeight, rope[i] * (N - i));
    }
    System.out.println(maximumWeight);
  }
}
