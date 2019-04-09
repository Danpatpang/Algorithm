package part29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam10815 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] card = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      card[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(card);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int value = Integer.parseInt(st.nextToken());
      int result = Arrays.binarySearch(card, value);

      if(result >= 0) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }
  }
}
