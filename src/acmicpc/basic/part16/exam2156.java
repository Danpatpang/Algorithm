package acmicpc.basic.part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        int[] amountOfWine = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            amountOfWine[i] = Integer.parseInt(br.readLine());
        }

        if (n >= 1) {
            dp[1] = amountOfWine[1];
        }
        if (n >= 2) {
            dp[2] = dp[1] + amountOfWine[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + amountOfWine[i], dp[i - 3] + amountOfWine[i - 1] + amountOfWine[i]));
        }

        System.out.println(dp[n]);
    }
}
