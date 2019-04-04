package part35;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2042 {
  public static long[] tree;

  public static void init() {
    for (int i = tree.length - 1; i >= 0; i -= 2) {
      tree[i / 2] = tree[i] + tree[i - 1];
    }
  }

  // 업데이트
  public static void updateTree(int position, long value) {
    tree[position] = value;

    for (int i = position; i > 0; i /= 2) {
      if(i % 2 == 0) {
        tree[i / 2] = tree[i] + tree[i + 1];
      } else {
        tree[i / 2] = tree[i] + tree[i - 1];
      }

    }
  }

  // 출력
  public static void sum(int start, int finish) {
    long result = 0;
    while (start <= finish) {
      if (start % 2 == 1) {
        result += tree[start];
        start++;
      }
      if (finish % 2 == 0) {
        result += tree[finish];
        finish--;
      }

      start /= 2;
      finish /= 2;
    }
    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int S = 1;
    while (S < N) {
      S <<= 1;
    }
    tree = new long[S * 2];
    for (int i = S; i < S + N; i++) {
      tree[i] = Long.parseLong(br.readLine());
    }
    init();

    for (int i = (N + 2); i <= (N + M + K + 1); i++) {
      st = new StringTokenizer(br.readLine());
      int select = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (select == 1) {
        updateTree(S + a - 1, b);
      } else if (select == 2) {
        sum(S + a - 1, S + b - 1);
      }
    }
  }
}
