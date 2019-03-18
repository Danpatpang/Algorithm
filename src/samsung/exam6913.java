package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam6913 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] map = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= M; k++) {
                    map[j] += Integer.parseInt(st.nextToken());
                }
            }

            int numPeople = 0;
            int maxScore = 0;
            for (int j = 1; j <= N; j++) {
                if (map[j] > maxScore) {
                    maxScore = map[j];
                }
            }

            for (int j = 1; j <= N; j++) {
                if (map[j] == maxScore) {
                    numPeople++;
                }
            }

            System.out.println("#" + i + " " + numPeople + " " + maxScore);
        }
    }
}
