package acmicpc.basic.part3;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class exam15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int X = Integer.parseInt(str.split(" ")[0]);
            int Y = Integer.parseInt(str.split(" ")[1]);
            sum[i] = X + Y;
        }
        for (int i:sum) {
            bw.write(String.valueOf(i));
            bw.newLine();
        }
        bw.flush();
    }
}