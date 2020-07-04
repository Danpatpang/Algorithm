package acmicpc.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam1094 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        cut(64, X);
        System.out.println(count);
    }

    public static void cut(int length, int X) {
        if (length == X) {
            count++;
            return;
        }

        if (length > X) {
            cut(length / 2, X);
            return;
        }

        if (length < X) {
            count++;
            cut(length / 2, X - length);
        }
    }
}