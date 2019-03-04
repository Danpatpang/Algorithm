package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam7102 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] sum = new int[M + N + 1];
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    sum[j + k]++;
                }
            }

            int max = 0;
            StringBuffer sb = new StringBuffer("#" + i);
            for (int j = 1; j < sum.length; j++) {
                max = Math.max(max, sum[j]);
            }

            for (int j = 1; j < sum.length; j++) {
                if (sum[j] == max) {
                    sb.append(" " + sum[j]);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
