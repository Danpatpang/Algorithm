package part36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam2188 {

  public static boolean[] isVisit;
  public static int flow[][], backflow[][], N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    flow = new int[N + 1][M + 1];
    backflow = new int[N + 1][N + 1];
    isVisit = new boolean[N + 1];
    }
}
