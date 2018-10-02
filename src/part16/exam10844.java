package part16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class exam10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] count = new long[10][N + 1];
        long sum = 0L;

        for (int i = 0; i <= 9; i++) {
            count[i][1] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    count[0][i] = count[1][i - 1] % 1000000000L;
                } else if (j == 9) {
                    count[9][i] = count[8][i - 1] % 1000000000L;
                } else {
                    count[j][i] = (count[j - 1][i - 1] + count[j + 1][i - 1]) % 1000000000L;
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            // sum += (count[i][N] % 1000000000L);// 은 틀렸다고 나온다.
            sum = (sum + count[i][N]) % 1000000000L;
        }
        System.out.println();
        System.out.println(sum);
    }
}
