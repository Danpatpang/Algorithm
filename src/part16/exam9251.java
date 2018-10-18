package part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] dp = new int[1001][1001];
        char[] firstLine = br.readLine().toCharArray();
        char[] secondLine = br.readLine().toCharArray();

        int firstLineLength = firstLine.length;
        int secondLineLength = secondLine.length;

        for (int i = 0; i < firstLineLength; i++) {
            for (int j = 0; j < secondLineLength; j++) {
                if (firstLine[i] == secondLine[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        System.out.println(dp[firstLineLength][secondLineLength]);
    }
}
