package part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] value = new int[N + 1];
        int[] temp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = -1000;
        for (int i = 1; i <= N; i++) {
            if (temp[i - 1] < 0) {
                temp[i] = value[i];
            } else {
                temp[i] = temp[i - 1] + value[i];
            }
            dp[i] = Math.max(dp[i - 1], temp[i]);
        }

        System.out.println(dp[N]);
    }
}
