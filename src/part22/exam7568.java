package part22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N + 1];
        int[] y = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int k = 0;
            for (int j = 1; j <= N; j++) {
                if(i == j) {
                    continue;
                }
                if(x[i] < x[j] && y[i] < y[j]) {
                    k++;
                }
            }
            System.out.println(k + 1);
        }
    }
}


//public class exam7568 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int N = Integer.parseInt(br.readLine());
//        int[] x = new int[N + 1];
//        int[] y = new int[N + 1];
//        boolean[][] result = new boolean[N + 1][N + 1];
//
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            x[i] = Integer.parseInt(st.nextToken());
//            y[i] = Integer.parseInt(st.nextToken());
//        }
//        // result[i][j]는 항상 result[j][i]와 다르다.
//        for (int i = 1; i < N; i++) {
//            for (int j = i + 1; j <= N; j++) {
//                if (x[i] < x[j]) {
//                    result[i][j] = true;
//                }
//
//                if (!result[i][j] && x[i] != x[j]) {
//                    result[j][i] = true;
//                }
//            }
//        }
//
//        for (int i = 1; i <= N; i++) {
//            int k = 0;
//            for (int j = 1; j <= N; j++) {
//                if (result[i][j]) {
//                    if (y[i] < y[j]) {
//                        k++;
//                    }
//                }
//            }
//            System.out.println(k + 1);
//        }
//    }
//}