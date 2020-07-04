package acmicpc.basic.part29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1920 {
  public static int[] value;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    value = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      value[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(value);

    int M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int goal = Integer.parseInt(st.nextToken());
      boolean isExist = find(0, N - 1, goal);

      if (isExist) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }

      //      if(Arrays.binarySearch(value, goal) >= 0) {
      //        System.out.println(1);
      //      } else {
      //        System.out.println(0);
      //      }
    }
  }

  public static boolean find(int start, int end, int goal) {
    while (start <= end) {
      int temp = (start + end) / 2;
      int result = Integer.compare(value[temp], goal);

      if (result == 0) {
        return true;
      } else if (result < 0) {
        start = temp + 1;
      } else {
        end = temp - 1;
      }
    }
    return false;
  }
}
