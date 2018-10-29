package part22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = Integer.toString(N).length();  // N의 길이
        int result = 0;

        for (int i = N - (length * 9); i <= N; i++) {
            // 자연수가 아닐 경우 생략
            if (i <= 0) {
                continue;
            }

            // sum = abc + a + b + c
            int sum = i;
            for (int j = 0; j < length; j++) {
                sum += (i / Math.pow(10, j)) % 10;
            }

            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
