package acmicpc.basic.part16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] firstString = br.readLine().toCharArray();
        char[] secondString = br.readLine().toCharArray();
        int firstLength = firstString.length;
        int secondLength = secondString.length;

        String[][] dp = new String[firstLength + 1][secondLength + 1];
        for (int i = 0; i <= firstLength; i++) {
            for (int j = 0; j <= secondLength; j++) {
                dp[i][j] = "";
            }
        }

        for (int i = 0; i < firstString.length; i++) {
            for (int j = 0; j < secondString.length; j++) {
                if (firstString[i] == secondString[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + firstString[i];
                } else {
                    if (dp[i][j + 1].length() > dp[i + 1][j].length()) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j];
                    }
                }
            }
        }

        System.out.println(dp[firstLength][secondLength].length());
        System.out.println(dp[firstLength][secondLength]);
    }
}
