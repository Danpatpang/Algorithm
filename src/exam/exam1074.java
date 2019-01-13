package exam;

import java.io.*;
import java.util.StringTokenizer;

public class exam1074 {
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        divide(N, c, r);
        System.out.println(count);
    }

    public static void divide(int n, int x, int y) {
        if (n == 0) {
            return;
        }

        int len = (int) Math.pow(2, n);
        int size = len * len;
        int partLen = len / 2;

        if (x < partLen && y < partLen) {
            divide(n - 1, x, y);
        } else if (partLen <= x && y < partLen) {
            count += (size / 4);
            divide(n - 1, x - partLen, y);
        } else if (x < partLen && partLen <= y) {
            count += (size / 4) * 2;
            divide(n - 1, x, y - partLen);
        } else if (partLen <= x && partLen <= y) {
            count += (size / 4) * 3;
            divide(n - 1, x - partLen, y - partLen);
        }
    }
}
