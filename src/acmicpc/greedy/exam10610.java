package acmicpc.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam10610 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String N = br.readLine();
    long sum = 0;
    int[] numCount = new int[10];

    for (int i = 0; i < N.length(); i++) {
      int current = N.charAt(i) - '0';
      sum += current;
      numCount[current]++;
    }

    StringBuffer sb = new StringBuffer();
    for (int i = 9; i >= 0; i--) {
      for (int j = numCount[i]; j > 0; j--) {
        sb.append(i);
      }
    }

    if (sum % 3 != 0 || !N.contains("0")) {
      System.out.println(-1);
    } else {
      System.out.println(sb.toString());
    }
  }
}
