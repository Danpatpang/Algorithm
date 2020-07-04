package acmicpc.exam.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam11758 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int[] x = new int[3];
    int[] y = new int[3];

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    int temp = (x[1] - x[0]) * (y[2] - y[0]) - (x[2] - x[0]) * (y[1] - y[0]);
    if (temp > 0) {
      System.out.println(1);
    } else if (temp < 0) {
      System.out.println(-1);
    } else {
      System.out.println(0);
    }
  }
}
