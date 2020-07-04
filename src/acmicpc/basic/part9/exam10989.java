package acmicpc.basic.part9;

import java.io.*;

public class exam10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];

        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(br.readLine())]++;
        }

        for (int i = 1; i <= 10000; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    bw.write(i + "\n");
                }
            }
        }

        br.close();
        bw.close();
    }
}
