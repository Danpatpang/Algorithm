package acmicpc.basic.part33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam4307 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int length = Integer.parseInt(st.nextToken());
      int antCount = Integer.parseInt(st.nextToken());

      int min = 0, max = 0;
      for (int j = 0; j < antCount; j++) {
        int ant = Integer.parseInt(br.readLine());

        int antMin = Math.min(ant, length - ant);
        int antMax = Math.max(ant, length - ant);

        min = Math.max(min, antMin);
        max = Math.max(max, antMax);
      }

      System.out.println(min);
      System.out.println(max);
    }
  }
}
