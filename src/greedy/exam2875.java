package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2875 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int cntTeam = Math.min((N / 2), M);
    int restN = N - (cntTeam * 2);
    int restM = M - cntTeam;
    K = K - restM - restN;

    while (K > 0) {
      cntTeam--;
      K -= 3;
    }

    System.out.println(cntTeam);
  }
}
