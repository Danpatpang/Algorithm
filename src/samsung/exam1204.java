package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int[] score = new int[101];
            int test = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 1000; j++) {
                score[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            int index = 0;
            for (int j = 100; j >= 0; j--) {
                if(score[j] > max) {
                    max = score[j];
                    index = j;
                }
            }

            System.out.println("#" + test + " " + index);
        }
    }
}