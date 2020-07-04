package acmicpc.basic.part29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1654 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int[] line = new int[K];

    for (int i = 0; i < K; i++) {
      line[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(line);

    long max = line[K - 1];
    long min = 1;
    long middle = 0;
    while (max >= min) {
      middle = (max + min) / 2;

      long count = 0;
      for (int i = 0; i < line.length; i++) {
        count += line[i] / middle;
      }

      if (count >= N) {
        min = middle + 1;
      } else {
        max = middle - 1;
      }
    }
    System.out.println(max);
  }
}
