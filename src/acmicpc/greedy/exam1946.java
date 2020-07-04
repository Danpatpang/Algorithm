package acmicpc.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1946 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
          for (int i = 0; i < T; i++) {
              int N = Integer.parseInt(br.readLine());
              int[][] score = new int[N][2];

              int firstLimit = Integer.MAX_VALUE, secondLimit = Integer.MAX_VALUE;
              for (int j = 0; j < N; j++) {
                  st = new StringTokenizer(br.readLine());
                  score[j][0] = Integer.parseInt(st.nextToken());
                  score[j][1] = Integer.parseInt(st.nextToken());

        if (score[j][0] == 1) {
          secondLimit = score[j][1];
        }
        if (score[j][1] == 1) {
          firstLimit = score[j][0];
        }
      }

      int count = 0;
      for (int j = 0; j < N; j++) {
        if (score[j][0] <= firstLimit && score[j][1] <= secondLimit) {
          count++;
        }
      }

      System.out.println(count);
    }
  }
}
